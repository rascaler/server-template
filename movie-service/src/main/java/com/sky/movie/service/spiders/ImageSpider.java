package com.sky.movie.service.spiders;

import com.alibaba.fastjson.JSON;
import com.sky.commons.utils.constant.BasicCode;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.movie.infrastructure.domain.Category;
import com.sky.movie.infrastructure.manager.CategoryManager;
import com.sky.movie.infrastructure.manager.ImageManager;
import com.sky.movie.infrastructure.pojo.dto.ImageInfo;
import com.sky.movie.infrastructure.utils.JsoupHelper;
import com.sky.movie.service.CategoryService;
import com.sky.movie.service.ImageService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rascaler on 3/21/18.
 */
@Service
public class ImageSpider {
    Logger logger = LoggerFactory.getLogger(ImageSpider.class);

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageManager imageManager;

    @Autowired
    private CategoryManager categoryManager;

    public void startImageSpider(String key) {
        String domain = "https://777av.vip";
        Map<String,String> map = getUrlTemplate();
        String template = map.get(key);
        int categoryId = formatCategory(key);
        if(StringUtils.isNotEmpty(template)) {
            ArrayList<String> urls = new ArrayList<String>();
            urls.add(String.format(template, ""));
            for (int index = 2;index < 10;index++){
                urls.add(String.format(template, "_" + index));
            }
            for(String url: urls) {
                try {
                    logger.info("开始抓取图片列表：url:" + url);
                    String content = JsoupHelper.get(url, null, "UTF-8", null);
                    Document doc = Jsoup.parse(content);
                    Elements lis = doc.select("div.art").select("ul").select("li");
                    if(null == lis || lis.size() == 0)
                        continue;
                    for (int index=0;index<lis.size();index++) {
                        try {
                            Element a = lis.get(index).select("a").first();
                            ImageInfo imageInfo = new ImageInfo();
                            imageInfo.setCategoryId(categoryId);
                            imageInfo.setName(a.text());
                            imageInfo.setUrl(domain + a.attr("href"));
                            String detailContent = JsoupHelper.get(imageInfo.getUrl(), null, "UTF-8", null);
                            Document detailDoc = Jsoup.parse(detailContent);
                            Elements imageEls = detailDoc.select("div.imgbody").select("img");
//                        List<String> imgUrls = new ArrayList<String>();
                            StringBuffer imgUrls = new StringBuffer();
                            imageEls.forEach(ie -> {
                                String imgUrl = "http:" + ie.attr("src");
                                if(imgUrl.endsWith(".jpg")) {
                                    if(imgUrls.length() == 0)
                                        imgUrls.append(imgUrl);
                                    else
                                        imgUrls.append(",").append(imgUrl);
                                }
                            });
                            imageInfo.setImageUrls(imgUrls.toString());
                            // 插入数据库
                            imageManager.saveImage(imageInfo);
                        }catch (Exception e) {
                            logger.error(String.format("列表第%s条数据抓取图片失败：url:%s",index + 1,url), e);
                        }
                    }
                }catch (Exception ex) {
                    logger.error(String.format("图片列表抓取失败：url:%s",url), ex);
                }

                logger.info("图片列表抓取成功：url:" + url);
            }
        }

    }


    public Map<String,String> getUrlTemplate () {
        Map<String,String> map = new HashMap<String,String>();
        map.put("toupai","https://777av.vip/html/tupian/toupai/index%s.html");
        map.put("yazhou","https://777av.vip/html/tupian/yazhou/index%s.html");
        map.put("siwa","https://777av.vip/html/tupian/siwa/index%s.html");
        map.put("oumei","https://777av.vip/html/tupian/oumei/index%s.html");
        map.put("mingxing","https://777av.vip/html/tupian/mingxing/index%s.html");
        map.put("qingchun","https://777av.vip/html/tupian/qingchun/index%s.html");
        map.put("dongman","https://777av.vip/html/tupian/dongman/index%s.html");
        return map;
    }

    public int formatCategory(String key) {
        String cateName = "";
        switch (key) {
            case "toupai": cateName = "偷拍自拍";break;
            case "yazhou": cateName = "亚洲色图";break;
            case "siwa": cateName = "丝袜美腿";break;
            case "oumei": cateName = "欧美性爱";break;
            case "mingxing": cateName = "激情明星";break;
            case "qingchun": cateName = "清纯唯美";break;
            case "dongman": cateName = "成人动漫";break;
        }
        if(StringUtils.isEmpty(cateName))
            throw new ServiceException(BasicCode.FAILED);
        Category query = new Category();
        query.setName(cateName);
        query.setParentId(2);
        Category category = categoryManager.selectOne(query);
        if(null == category)
            throw new ServiceException(BasicCode.FAILED);
        return category.getId();
    }
}

package com.sky.movie.service.spiders;

import com.alibaba.fastjson.JSON;
import com.sky.movie.infrastructure.pojo.dto.ImageInfo;
import com.sky.movie.infrastructure.utils.JsoupHelper;
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

    public void startImageSpider(String key) {
        String domain = "https://777av.vip";
        Map<String,String> map = getUrlTemplate();
        String template = map.get(key);
        if(StringUtils.isNotEmpty(template)) {
            ArrayList<String> urls = new ArrayList<String>();
            urls.add(String.format(template, ""));
            for (int index = 2;index < 10;index++){
                urls.add(String.format(template, "_" + index));
            }
            for(String url: urls) {
                logger.info("开始抓取图片：url:" + url);
                String content = JsoupHelper.get(url, null, "UTF-8", null);
                Document doc = Jsoup.parse(content);
                Elements lis = doc.select("div.art").select("ul").select("li");
                List<ImageInfo> imageInfos = new ArrayList<ImageInfo>();
                if(null != lis && lis.size() > 0) {
                    lis.forEach(l -> {
                        Element a = l.select("a").first();
                        ImageInfo imageInfo = new ImageInfo();
                        imageInfo.setName(a.text());
                        imageInfo.setUrl(domain + a.attr("href"));
                        imageInfos.add(imageInfo);
                        logger.info(a.text());
                        logger.info(domain +a.attr("href"));
                    });
                    // 抓取图片
                    imageInfos.forEach(i -> {
                        String detailContent = JsoupHelper.get(i.getUrl(), null, "UTF-8", null);
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
                        i.setImageUrls(imgUrls.toString());
                    });
                }
                logger.info(JSON.toJSONString(imageInfos));
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
}

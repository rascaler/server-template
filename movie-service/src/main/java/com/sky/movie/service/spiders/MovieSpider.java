package com.sky.movie.service.spiders;

import com.alibaba.fastjson.JSON;
import com.sky.movie.infrastructure.pojo.dto.MovieInfo;
import com.sky.movie.infrastructure.utils.JsoupHelper;
import com.sky.movie.service.VideoService;
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

/**
 * Created by rascaler on 3/2/18.
 */
@Service
public class MovieSpider {
    Logger logger = LoggerFactory.getLogger(MovieSpider.class);

    @Autowired
    private VideoService videoService;

    public void startSpider (String id) {
        String domain = "https://777av.vip";
        String template = "https://777av.vip/list/"+id+"%s.html";
        ArrayList<String> urls = new ArrayList<String>();
        urls.add(String.format(template, ""));
        for (int index = 2;index < 10;index++){
            urls.add(String.format(template, "-" + index));
        }

        for(String url : urls) {
            try {
                logger.info("开始抓取电影：url:" + url);
                ArrayList<String> movieUrls = new ArrayList<String>();
                String content = JsoupHelper.get(url, null, "UTF-8", null);
                Document doc = Jsoup.parse(content);
                Elements ul = doc.select("ul.mlist");
                Elements lis =ul.select("li");
                for(Element element: lis) {
                    movieUrls.add(domain + element.select("a").attr("href"));
                }

                ArrayList<MovieInfo> movies = new ArrayList<MovieInfo>();
                for(String mv : movieUrls) {
                    if(StringUtils.isNotEmpty(mv)) {
                        MovieInfo movieInfo = new MovieInfo();
                        String mvcontent = JsoupHelper.get(mv, null, "UTF-8", null);
                        Document mvDoc = Jsoup.parse(mvcontent);
                        // 获取图片地址
                        movieInfo.setImgUrl("http:" + mvDoc.select("div.pic").select("img").attr("src"));
                        // 获取影片信息
                        movieInfo.setName(mvDoc.select("div").select("h1").text());
                        Elements mvUl = mvDoc.select("div.info").select("ul");
                        movieInfo.setType(mvUl.select("li").eq(0).text().replace("影片类型：",""));
                        movieInfo.setUpdatedDate(mvUl.select("li").eq(3).select("div").text().replace("更新日期：",""));
                        // 获取播放地址和下载地址
//                System.out.println(doc.select("div.play-list").eq(0).select("a").eq(1).attr("href"));
//                System.out.println(doc.select("textarea").val());
                        ArrayList<String> downloadUrls = new ArrayList<String>();
                        Elements downlist = mvDoc.select("div.downlist").select("a");
                        for(Element el: downlist) {
                            downloadUrls.add(el.attr("href"));
                        }
                        //获取剧情图片
                        Elements imgs = mvDoc.select("div.endtext").select("img");
                        ArrayList<String> plotUrls = new ArrayList<String>();
                        for(Element img: imgs) {
                            plotUrls.add("http:" + img.attr("src"));
                        }
                        movieInfo.setDownloadUrls(downloadUrls);
                        movieInfo.setPlots(plotUrls);
                        logger.info(JSON.toJSONString(movieInfo));
                        movies.add(movieInfo);
                    }
                }
                videoService.addVideos(movies);
                logger.info("抓取电影完成：url:" + url);
            }catch (Exception e) {
                logger.error("抓取电影失败 url:" + url, e);
            }
        }

    }

}

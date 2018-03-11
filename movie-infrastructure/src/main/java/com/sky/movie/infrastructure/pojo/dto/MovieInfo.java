package com.sky.movie.infrastructure.pojo.dto;

import java.util.ArrayList;

/**
 * Created by rascaler on 3/2/18.
 */
public class MovieInfo {
    private String name;
    private String title;
    private String link;
    private String type;
    private String updatedDate;
    private String imgUrl;
    private ArrayList<String> downloadUrls;
    private ArrayList<String> plots;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ArrayList<String> getDownloadUrls() {
        return downloadUrls;
    }

    public void setDownloadUrls(ArrayList<String> downloadUrls) {
        this.downloadUrls = downloadUrls;
    }

    public ArrayList<String> getPlots() {
        return plots;
    }

    public void setPlots(ArrayList<String> plots) {
        this.plots = plots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

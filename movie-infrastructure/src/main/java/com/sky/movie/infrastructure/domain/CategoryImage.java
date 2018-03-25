package com.sky.movie.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_category_image")
public class CategoryImage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name = "imageId")
    private Integer imageId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return imageId
     */
    public Integer getImageId() {
        return imageId;
    }

    /**
     * @param imageId
     */
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
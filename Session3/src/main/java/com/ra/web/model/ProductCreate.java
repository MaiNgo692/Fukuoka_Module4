package com.ra.web.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class ProductCreate {
    private String id;
    private String name;
    private MultipartFile image;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    private boolean status;
    private float price;

    public ProductCreate() {
    }

    public ProductCreate(String id, String name, MultipartFile image, Date created, boolean status, float price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.created = created;
        this.status = status;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

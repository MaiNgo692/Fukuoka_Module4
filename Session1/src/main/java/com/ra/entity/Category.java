package com.ra.entity;

import com.ra.util.Column;
import com.ra.util.Id;
import com.ra.util.Table;
import sun.reflect.CallerSensitive;

@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "categoryNam")
    private String categoryNam;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private boolean status;
    public Category() {
    }

    public Category(String categoryNam,String description, boolean status) {
        this.categoryNam = categoryNam;
        this.description = description;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryNam() {
        return categoryNam;
    }

    public void setCategoryNam(String categoryNam) {
        this.categoryNam = categoryNam;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

package com.subi.cookingshare.data.model;

import java.io.Serializable;

public class Food  implements Serializable {
    private String id, name,  des;
    private int img;
    public Food() {
    }

    public Food(String id, String name, int img, String des) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.des = des;
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

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}

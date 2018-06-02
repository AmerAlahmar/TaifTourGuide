package com.testspace.amer.taiftourguide;

import java.io.Serializable;

public class Place implements Serializable {
    public static final String NO_PHONE = "empty";
    public static final String NO_WH = "empty";
    private int imgId;
    private String name;
    private String shortDesc;
    private String longDesc;
    private String phone;
    private String wh;
    private String location;

    Place(int imgId, String name, String shortDesc, String longDesc, String phone, String wh, String location) {
        this.imgId = imgId;
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.phone = phone;
        this.wh = wh;
        this.location = location;
    }

    public int getImgId() {
        return imgId;
    }

    public String getName() {
        return name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public String getPhone() {
        return phone;
    }

    public String getWh() {
        return wh;
    }

    public String getLocation() {
        return location;
    }
}
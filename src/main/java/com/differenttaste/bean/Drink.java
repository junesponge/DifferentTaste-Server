package com.differenttaste.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Drink {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String type;
    private String prices;
    private String sizes;
    private String hotTypes;
    private int count;
    private double discount;
    private String imagesName;
    private boolean isOnsale;
    private Date changeTime;
    private String changeStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getHotTypes() {
        return hotTypes;
    }

    public void setHotTypes(String hotTypes) {
        this.hotTypes = hotTypes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getImagesName() {
        return imagesName;
    }

    public void setImagesName(String imagesName) {
        this.imagesName = imagesName;
    }

    public boolean isOnsale() {
        return isOnsale;
    }

    public void setOnsale(boolean onsale) {
        isOnsale = onsale;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public String getChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(String changeStatus) {
        this.changeStatus = changeStatus;
    }
}

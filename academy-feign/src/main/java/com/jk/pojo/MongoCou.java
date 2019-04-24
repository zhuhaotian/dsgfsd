package com.jk.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: mavenmodule
 * @Date: 2019/4/24 21:11
 * @Author: Mr.Deng
 * @Description:
 */
@Document(collection="mongodb_course")
public class MongoCou {

    private  String id;

    private  String noopsycheName;

    private  String noopsycheHome;

    private  String noopsychePrice;

    private  String noopsycheImg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoopsycheName() {
        return noopsycheName;
    }

    public void setNoopsycheName(String noopsycheName) {
        this.noopsycheName = noopsycheName;
    }

    public String getNoopsycheHome() {
        return noopsycheHome;
    }

    public void setNoopsycheHome(String noopsycheHome) {
        this.noopsycheHome = noopsycheHome;
    }

    public String getNoopsychePrice() {
        return noopsychePrice;
    }

    public void setNoopsychePrice(String noopsychePrice) {
        this.noopsychePrice = noopsychePrice;
    }

    public String getNoopsycheImg() {
        return noopsycheImg;
    }

    public void setNoopsycheImg(String noopsycheImg) {
        this.noopsycheImg = noopsycheImg;
    }

    @Override
    public String toString() {
        return "Mongo{" +
                "id='" + id + '\'' +
                ", noopsycheName='" + noopsycheName + '\'' +
                ", noopsycheHome='" + noopsycheHome + '\'' +
                ", noopsychePrice='" + noopsychePrice + '\'' +
                ", noopsycheImg='" + noopsycheImg + '\'' +
                '}';
    }
}

package com.jk.pojo;

/**
 * @program: mavenmodule
 * @Date: 2019/4/19 18:36
 * @Author: Mr.Deng
 * @Description:
 */
public class Course {

    private  Integer id;

    private  String noopsycheName;

    private  Integer noopsycheHome;

    private  Double noopsychePrice;

    private  String noopsycheImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoopsycheName() {
        return noopsycheName;
    }

    public void setNoopsycheName(String noopsycheName) {
        this.noopsycheName = noopsycheName;
    }

    public Integer getNoopsycheHome() {
        return noopsycheHome;
    }

    public void setNoopsycheHome(Integer noopsycheHome) {
        this.noopsycheHome = noopsycheHome;
    }

    public Double getNoopsychePrice() {
        return noopsychePrice;
    }

    public void setNoopsychePrice(Double noopsychePrice) {
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
        return "Course{" +
                "id=" + id +
                ", noopsycheName='" + noopsycheName + '\'' +
                ", noopsycheHome=" + noopsycheHome +
                ", noopsychePrice=" + noopsychePrice +
                ", noopsycheImg='" + noopsycheImg + '\'' +
                '}';
    }
}

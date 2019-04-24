package com.jk.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @program: mavenmodule
 * @Date: 2019/4/19 18:36
 * @Author: Mr.Deng
 * @Description:@Data
 * @Document(indexName = "ordeo",type = "orvideo")
 * public class VideoBean implements Serializable {
 *
 *     private static final long serialVersionUID = -6914584810275278086L;
 *     @Id
 *     private  String courseId;
 *     @Field(analyzer = "ik_max_word")
 */
@Document(collection="mon_course")
public class Course implements Serializable{

    private static final long serialVersionUID = -8583087805162883811L;
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
        return "Course{" +
                "id='" + id + '\'' +
                ", noopsycheName='" + noopsycheName + '\'' +
                ", noopsycheHome='" + noopsycheHome + '\'' +
                ", noopsychePrice='" + noopsychePrice + '\'' +
                ", noopsycheImg='" + noopsycheImg + '\'' +
                '}';
    }
}

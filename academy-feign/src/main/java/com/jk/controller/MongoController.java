package com.jk.controller;

import com.jk.pojo.Course;
import com.jk.pojo.Mongo;
import com.jk.util.ExportExcel;
import com.jk.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @program: mavenmodule
 * @Date: 2019/4/24 10:38
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class MongoController {

    @Autowired
    public MongoTemplate mongoTemplate;

    @RequestMapping("mongoDbAdd")
    @ResponseBody
    public void mongoDbAdd(Mongo mongo){
        /*course.setNoopsycheName("人工智能开发工程师（机器学习+深度学习）");
        mongo.setNoopsycheHome("25");
        mongo.setNoopsycheImg("10245");
        mongo.setNoopsychePrice("http://houduan.oss-cn-beijing.aliyuncs.com/houduan/1553008184228.jpg");

        mongo.setNoopsycheName("人工智能开发进阶提升实训营");
        mongo.setNoopsycheHome("14");
        mongo.setNoopsycheImg("3235");
        mongo.setNoopsychePrice("http://houduan.oss-cn-beijing.aliyuncs.com/houduan/1553008184228.jpg");

        mongo.setNoopsycheName("推荐系统工程师");
        mongo.setNoopsycheHome("23");
        mongo.setNoopsycheImg("54236");
        mongo.setNoopsychePrice("http://houduan.oss-cn-beijing.aliyuncs.com/houduan/1553008184228.jpg");

        mongo.setNoopsycheName("推荐系统工程师");
        mongo.setNoopsycheHome("32");
        mongo.setNoopsycheImg("13345");
        mongo.setNoopsychePrice("http://houduan.oss-cn-beijing.aliyuncs.com/houduan/1553008184228.jpg");*/

        mongo.setNoopsycheName("人工智能开发进阶提升实训营");
        mongo.setNoopsycheHome("5");
        mongo.setNoopsycheImg("343245");
        mongo.setNoopsychePrice("http://houduan.oss-cn-beijing.aliyuncs.com/houduan/1553008184228.jpg");

        mongoTemplate.save(mongo);

    }

    @RequestMapping("mongoDbQuery")
    @ResponseBody
    public List<Mongo> mongoDbQuery(){
        Query query = new Query();
        List<Mongo> list = mongoTemplate.find(query, Mongo.class);
        return list;
    }

    //poi导出   成excel
    @ResponseBody
    @RequestMapping("save")
    public ResponseEntity<byte[]> save(Mongo mongo) throws Exception {
        Query query = new Query();
        String sheetName = "我的列表";
        String titleName = "列表";
        String[] headers = {"", "ID", "视频教程名称", "课时", "图片","价格"};
        List<Mongo> dataSet = mongoTemplate.find(query, Mongo.class);
        String replace = UUID.randomUUID().toString().replace("-", "");

        String fileDir = "E:\\poi\\";

        File file = new File(fileDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        String randomPath = fileDir + replace+".xls";

        String pattern = "yyyy-MM-dd";
        ExportExcel.exportExcel(sheetName, titleName, headers, dataSet, randomPath, pattern);

        return FileUtil.FileDownload(randomPath,"fileName.xls");

    }
}

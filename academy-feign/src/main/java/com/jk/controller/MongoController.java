package com.jk.controller;

import com.jk.pojo.Course;
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
    public void mongoDbAdd(Course course){
        /*course.setNoopsycheName("人工智能开发工程师（机器学习+深度学习）");
        course.setNoopsycheHome("25");
        course.setNoopsycheImg("10245");
        course.setNoopsychePrice("http://houduan.oss-cn-beijing.aliyuncs.com/houduan/1553008184228.jpg");

        course.setNoopsycheName("人工智能开发进阶提升实训营");
        course.setNoopsycheHome("14");
        course.setNoopsycheImg("3235");
        course.setNoopsychePrice("http://houduan.oss-cn-beijing.aliyuncs.com/houduan/1553008184228.jpg");

        course.setNoopsycheName("推荐系统工程师");
        course.setNoopsycheHome("23");
        course.setNoopsycheImg("54236");
        course.setNoopsychePrice("http://houduan.oss-cn-beijing.aliyuncs.com/houduan/1553008184228.jpg");

        course.setNoopsycheName("推荐系统工程师");
        course.setNoopsycheHome("32");
        course.setNoopsycheImg("13345");
        course.setNoopsychePrice("http://houduan.oss-cn-beijing.aliyuncs.com/houduan/1553008184228.jpg");*/

        course.setNoopsycheName("人工智能开发进阶提升实训营");
        course.setNoopsycheHome("5");
        course.setNoopsycheImg("343245");
        course.setNoopsychePrice("http://houduan.oss-cn-beijing.aliyuncs.com/houduan/1553008184228.jpg");

        mongoTemplate.save(course);

    }

    @RequestMapping("mongoDbQuery")
    @ResponseBody
    public List<Course> mongoDbQuery(){
        Query query = new Query();
        List<Course> list = mongoTemplate.find(query, Course.class);
        return list;
    }

    //poi导出   成excel
    @ResponseBody
    @RequestMapping("save")
    public ResponseEntity<byte[]> save(Course course) throws Exception {
        Query query = new Query();
        String sheetName = "我的列表";
        String titleName = "列表";
        String[] headers = {"", "ID", "视频教程名称", "课时", "图片","价格"};
        List<Course> dataSet = mongoTemplate.find(query, Course.class);
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

package com.jk.service;

import com.jk.pojo.Course;
import com.jk.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: mavenmodule
 * @Date: 2019/4/20 9:10
 * @Author: Mr.Deng
 * @Description:
 */
public interface ShiroService {

    /**
     * 视频课程查询
     * @return
     */
    @GetMapping("acaDemyQuery")
    List<Course> acaDemyQuery();
}

package com.jk.service;

import com.jk.pojo.Course;
import com.jk.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @GetMapping("userLogin")
    List<User> userLogin();

    @RequestMapping("findVideo")
    List<Course> findVideo();

}

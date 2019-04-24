package com.jk.controller;



import com.jk.mapper.UserMapper;
import com.jk.pojo.Course;
import com.jk.pojo.User;
import com.jk.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class UserServiceImpl implements ShiroService {

    @Autowired
    private UserMapper userMapper;


    @Override
    @ResponseBody
    public List<Course> acaDemyQuery() {

        return userMapper.acaDemyQuery();
    }

    @Override
    @ResponseBody
    public List<Course> findVideo() {
        return userMapper.findVideo();
    }
}

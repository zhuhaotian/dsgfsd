package com.jk.mapper;

import com.jk.pojo.Course;
import com.jk.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: mavenmodule
 * @Date: 2019/4/20 9:18
 * @Author: Mr.Deng
 * @Description:
 */
public interface UserMapper {

    List<Course> acaDemyQuery();

    @Select("select * from t_noopsyche")
    List<Course> findVideo();
}

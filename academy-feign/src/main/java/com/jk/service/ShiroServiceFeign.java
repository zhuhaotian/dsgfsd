package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @program: mavenmodule
 * @Date: 2019/4/20 9:08
 * @Author: Mr.Deng
 * @Description:
 */

@FeignClient("provi")
public interface ShiroServiceFeign extends ShiroService{


}

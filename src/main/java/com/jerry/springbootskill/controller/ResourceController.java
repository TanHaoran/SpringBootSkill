package com.jerry.springbootskill.controller;

import com.jerry.springbootskill.domain.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/26
 * Time: 10:18
 * Description:
 */
@RestController
public class ResourceController {

    @Autowired
    private Resource resource;

    @RequestMapping("/getResource")
    public Resource getResource() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return bean;
    }
}

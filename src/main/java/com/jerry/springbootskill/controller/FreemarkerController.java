package com.jerry.springbootskill.controller;

import com.jerry.springbootskill.domain.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/26
 * Time: 10:45
 * Description:
 */
@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("resource", resource);
        return "freemarker/index";
    }

    @RequestMapping("/center")
    public String center() {
        return "freemarker/center/center";
    }

}

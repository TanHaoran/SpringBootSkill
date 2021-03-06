package com.jerry.springbootskill.controller;

import com.jerry.springbootskill.util.ResultVOUtil;
import com.jerry.springbootskill.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/error")
    public String error() {

        int a = 1 / 0;

        return "thymeleaf/error";
    }

    @RequestMapping("/ajaxError")
    public String ajaxError() {

        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxError")
    @ResponseBody
    public ResultVO getAjaxError() {

        int a = 1 / 0;

        return ResultVOUtil.success();
    }
}
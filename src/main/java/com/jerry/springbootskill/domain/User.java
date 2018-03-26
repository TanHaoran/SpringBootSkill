package com.jerry.springbootskill.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/22
 * Time: 16:43
 * Description:
 */
@Data
public class User {

    private String name;

    @JsonIgnore
    private String password;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date birthday;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desc;

}

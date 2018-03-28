package com.jerry.springbootskill.controller;

import com.jerry.springbootskill.domain.SysUser;
import com.jerry.springbootskill.service.SysUserService;
import com.jerry.springbootskill.util.KeyUtil;
import com.jerry.springbootskill.util.ResultVOUtil;
import com.jerry.springbootskill.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/28
 * Time: 21:33
 * Description:
 */
@RestController
@RequestMapping("/mybatis")
public class MyBatisCRUDController {

    private static final String ID = "1522246712674555341";

    @Autowired
    private SysUserService userService;

    @GetMapping("/saveUser")
    public ResultVO saveUser() {
        SysUser sysUser = new SysUser();
        sysUser.setId(KeyUtil.genUniqueKey());
        sysUser.setUsername("username " + new Date());
        sysUser.setPassword("password " + new Date());
        sysUser.setIsDelete(0);
        sysUser.setRegisterTime(new Date());

        userService.saveUser(sysUser);

        return ResultVOUtil.success(sysUser);
    }

    @GetMapping("/updateUser")
    public ResultVO updateUser() {
        SysUser sysUser = new SysUser();
        sysUser.setId(ID);
        sysUser.setPassword("123");
        sysUser.setIsDelete(0);
        sysUser.setRegisterTime(new Date());

        userService.updateUser(sysUser);

        return ResultVOUtil.success(sysUser);
    }

    @GetMapping("/deleteUser")
    public ResultVO deleteUser(String id) {

        userService.deleteUser("1522248813304756291");

        return ResultVOUtil.success();
    }

    @RequestMapping("/queryUser")
    public ResultVO queryUser(String id) {


        return ResultVOUtil.success(userService.queryUserById(ID));
    }

    @RequestMapping("/queryUserList")
    public ResultVO queryUserList() {

        SysUser user = new SysUser();
        user.setUsername("username");
        user.setPassword("password");

        List<SysUser> userList = userService.queryUserList(user);

        return ResultVOUtil.success(userList);
    }
}

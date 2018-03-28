package com.jerry.springbootskill.service;

import com.jerry.springbootskill.domain.SysUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/28
 * Time: 21:19
 * Description:
 */
public interface SysUserService {

    void saveUser(SysUser sysUser);

    void updateUser(SysUser sysUser);

    void deleteUser(String id);

    SysUser queryUserById(String id);

    List<SysUser> queryUserList(SysUser sysUser);
}

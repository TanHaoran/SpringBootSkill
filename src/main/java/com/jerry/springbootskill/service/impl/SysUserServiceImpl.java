package com.jerry.springbootskill.service.impl;

import com.jerry.springbootskill.domain.SysUser;
import com.jerry.springbootskill.mapper.SysUserMapper;
import com.jerry.springbootskill.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/28
 * Time: 21:23
 * Description:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper mapper;

    @Override
    public void saveUser(SysUser sysUser) {
        mapper.insert(sysUser);
    }

    @Override
    public void updateUser(SysUser user) {
        // 使用updateByPrimaryKey会将没有值的属性设置为null
        // mapper.updateByPrimaryKey(user);
        // 使用updateByPrimaryKeySelective可以只替换不为null的属性
        mapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysUser queryUserById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysUser> queryUserList(SysUser user) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
            // 使用andEqualTo是精确查询
            // criteria.andEqualTo("username", user.getUsername());
            // 使用andLike是模糊查询
            criteria.andLike("username", "%" + user.getUsername() + "%");

        }

        if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
            criteria.andLike("password", "%" + user.getPassword() + "%");
        }

        List<SysUser> userList = mapper.selectByExample(example);

        return userList;
    }


}

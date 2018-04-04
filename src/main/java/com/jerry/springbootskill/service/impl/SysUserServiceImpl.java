package com.jerry.springbootskill.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jerry.springbootskill.domain.SysUser;
import com.jerry.springbootskill.mapper.SysUserMapper;
import com.jerry.springbootskill.mapper.SysUserMapperCustom;
import com.jerry.springbootskill.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
    private SysUserMapper userMapper;

    @Autowired
    private SysUserMapperCustom userMapperCustom;

    @Override
    public void saveUser(SysUser sysUser) {
        userMapper.insert(sysUser);
    }

    @Override
    public void updateUser(SysUser user) {
        // 使用updateByPrimaryKey会将没有值的属性设置为null
        // userMapper.updateByPrimaryKey(user);
        // 使用updateByPrimaryKeySelective可以只替换不为null的属性
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysUser queryUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
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

        List<SysUser> userList = userMapper.selectByExample(example);

        return userList;
    }

    @Override
    public PageInfo<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
        // 开始分页
        PageHelper.startPage(page, pageSize);

        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
            criteria.andLike("nickname", "%" + user.getNickname() + "%");
        }

        example.orderBy("registerTime").desc();

        return new PageInfo<>(userMapper.selectByExample(example));
    }

    @Override
    public SysUser queryUserByIdCustom(String id) {
        List<SysUser> userList = userMapperCustom.queryUserSimplyInfoById(id);

        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUserTransactional(SysUser user) {
        userMapper.insert(user);

        int a = 1 / 0;

        user.setIsDelete(1);

        userMapper.updateByPrimaryKeySelective(user);
    }

}

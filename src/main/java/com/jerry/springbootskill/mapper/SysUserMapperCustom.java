package com.jerry.springbootskill.mapper;

import com.jerry.springbootskill.domain.SysUser;
import com.jerry.springbootskill.util.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapperCustom extends MyMapper<SysUser> {

    List<SysUser> queryUserSimplyInfoById(String id);
}
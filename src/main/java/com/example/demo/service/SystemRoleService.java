package com.example.demo.service;

import com.example.demo.entity.SystemRole;
import com.example.demo.mapper.SystemRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemRoleService {

    @Autowired
    SystemRoleMapper systemRoleMapper;

    //1 remove System Role
    public boolean remove(SystemRole systemRole)
    {
        systemRoleMapper.remove(systemRole);
        return true;
    }

    //2 insert
    public boolean insert(SystemRole systemRole)
    {
        systemRoleMapper.insertSelective(systemRole);
        return true;
    }

}

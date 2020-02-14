package com.example.demo.service;

import com.example.demo.entity.UserSystemRole;
import com.example.demo.mapper.UserSystemRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSystemRoleService {
    @Autowired
    UserSystemRoleMapper userSystemRoleMapper;


    //1 insert: 能插入的前提是参数record中已赋值的成员覆盖了对应数据表中的所有“not null”字段
    public boolean insert(UserSystemRole record)
    {
        userSystemRoleMapper.insertSelective(record);
        return true;
    }

    //2 remove
    public boolean remove(UserSystemRole param)
    {
        userSystemRoleMapper.remove(param);
        return true;
    }

    //3 update
    public boolean update(Long user_id, Long role_id, long new_role_id)
    {
        userSystemRoleMapper.update(user_id, role_id, new_role_id);
        return true;
    }

    //4 get system role name by user id
    public List<UserSystemRole> getItems(Long user_id)
    {
        UserSystemRole param = new UserSystemRole();
        param.setUser_id(user_id);

        return userSystemRoleMapper.getItems(param);
    }

}

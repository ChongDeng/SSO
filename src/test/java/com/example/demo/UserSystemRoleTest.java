package com.example.demo;

import com.example.demo.entity.UserSystemRole;
import com.example.demo.service.UserSystemRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSystemRoleTest {

    @Autowired
    private UserSystemRoleService userSystemRoleService;

    @Test
    public void insert(){

        UserSystemRole record = new UserSystemRole();
        record.setUser_id(1L);
        record.setSystem_role_id(1L);

        userSystemRoleService.insert(record);
    }

    @Test
    public void remove(){

        UserSystemRole record = new UserSystemRole();
        record.setUser_id(2L);
        record.setSystem_role_id(3L);

        userSystemRoleService.remove(record);
    }

    @Test
    public void update(){

        UserSystemRole record = new UserSystemRole();
        record.setUser_id(1L);
        record.setSystem_role_id(3L);

        Long new_role_id = 9L;
        userSystemRoleService.update(record.getUser_id(), record.getSystem_role_id(), new_role_id);
    }

    @Test
    public void query(){
        Long user_id = 1L;
        List<UserSystemRole> res = userSystemRoleService.getItems(user_id);

        System.out.println("query result: " + res);
    }


}

package com.example.demo;

import com.example.demo.entity.SystemRole;
import com.example.demo.service.SystemRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemRoleTest {

    @Autowired
    private SystemRoleService systemRoleService;

    @Test
    public void insert(){
        SystemRole record = new SystemRole();
        record.setName("General 2");
        record.setCreated(new Date());
        record.setCreated_by("root");
        record.setModified(new Date());
        record.setModified_by("root");

        systemRoleService.insert(record);
    }

    @Test
    public void remove(){
        SystemRole record = new SystemRole();
        record.setName("General 2");

        systemRoleService.remove(record);
    }
}

package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService userService;


	//======================== 引入缓存 ===================================
	@Test
	public void getUserById_Cache(){
		Long Id = 1L;
		User result = userService.getUserById(Id);
		System.out.println("res: " + result);
	}

}
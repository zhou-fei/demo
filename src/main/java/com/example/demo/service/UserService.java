package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.domain.User;

/**
 * @author phil
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public void test() {
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user.getName());
	}

	public User getUser() {
		return userMapper.selectByPrimaryKey(1);
	}

	public int update(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

}

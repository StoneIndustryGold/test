package test1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test1.mapper.UserMapper;
import test1.model.UserModel;
import test1.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	@Override
	public void add(UserModel userModel) {
		userMapper.add(userModel);

	}

}

package cn.wzw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wzw.mapper.UserMapper;
import cn.wzw.pojo.User;
import cn.wzw.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public List<User> selectAllUser() {
		List<User> list = userMapper.selectUser();
		return list;
	}

	@Override
	public void updateUser(User user) {
		User oldUser = userMapper.findUserById(user.getId());
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		userMapper.deleteUser(id);
	}

	@Override
	public User selectUserById(Integer id) {
		return userMapper.findUserById(id);
	}

}

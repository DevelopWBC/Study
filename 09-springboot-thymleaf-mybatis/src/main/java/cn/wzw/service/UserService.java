package cn.wzw.service;

import java.util.List;

import cn.wzw.pojo.User;

public interface UserService {
	void addUser(User user);
	List<User> selectAllUser();
	void updateUser(User user);
	void deleteUser(int id);
	User selectUserById(Integer id);
}

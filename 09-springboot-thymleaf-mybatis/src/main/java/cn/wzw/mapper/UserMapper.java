package cn.wzw.mapper;

import java.util.List;

import cn.wzw.pojo.User;

public interface UserMapper {
	void insertUser(User user);
	List<User> selectUser();
	void updateUser(User user);
	void deleteUser(int id);
	User findUserById(int id);
}

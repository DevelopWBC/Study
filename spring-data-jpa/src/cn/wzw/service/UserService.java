package cn.wzw.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import cn.wzw.pojo.User;

public interface UserService {
	void addUser(User user);
	void deleteUser(User user);
	void updateUser(User user);
	void selectUser();
	List<User> findByUsername(String name);
	List<User> queryUserByName(String username);
	List<User> queryUserByNameSql(String name);
	void updateUsernameById(String username,Integer id);
	void deleteUserById(Integer id);
	//JpaSpecificationExecutor,完成多条件的查询
	List<User> searchUser(User user);
}

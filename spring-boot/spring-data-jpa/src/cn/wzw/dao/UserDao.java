package cn.wzw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.wzw.pojo.User;

/**
 * 继承JpaRepository接口，该接口有基本的CRUD方法并对返回值类型做了处理，不用转换类型了。是开发中最常用的一种 编写 数据层接口
 * 继承JpaSpecificationExecutor接口，可以完成多条件的查询和分页的处理
 * @author wangzhiwen
 *
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {
	// 根据命名规则编写查询方法
	List<User> findByUsername(String name);

	// 使用注解方式查询数据
	@Query(value = "from User where username like %:username%")
	List<User> queryUserByName(@Param("username") String username);
	 
	// 使用sql语句
	@Query(value = "select * from t_user t where t.user_name like %:username%", nativeQuery = true)
	List<User> queryUserByNameSql(@Param(value = "username") String name);
	
	//使用注解执行更新操作
	@Query(value = "update User set username = ?1 where id = ?2")
	@Modifying
	void updateUsernameById(String username,Integer id);
	
	//使用注解执行删除操作
	@Query(value = "delete from t_user t where t.id = ?1",nativeQuery = true)
	@Modifying
	void deleteUserById(Integer id);
}

package cn.wzw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.wzw.dao.RolesDao;
import cn.wzw.dao.UserDao;
import cn.wzw.pojo.Roles;
import cn.wzw.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToOne {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RolesDao rolesDao;
	
	/**
	 * 一对一关系，主表是user。roleId是外键，先添加角色再添加用户
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void addRolesAndUser() {
		//添加角色
		Roles roles = new Roles();
		roles.setRoleName("角色3");
		//添加用户
		User user = new User();
		user.setUsername("小志");
		user.setUserage(20);
		//设置角色
		user.setRoles(roles);
		//设置用户
		roles.setUser(user);
		//保存用户
		//rolesDao.save(roles);
		userDao.save(user);
	}
	
	/**
	 * 级联查询
	 */
	@Test
	public void queryUserAndRoles() {
		User user = userDao.findOne(7);
		Roles roles = user.getRoles();
		System.out.println(user);
		System.out.println(roles);
	}
}

package cn.wzw.test;

import java.util.List;

import org.aspectj.weaver.ast.Literal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.wzw.pojo.People;
import cn.wzw.pojo.Student;
import cn.wzw.pojo.User;
import cn.wzw.service.PeopleService;
import cn.wzw.service.StudentServiceImpl;
import cn.wzw.service.UserService;

/**
 *  注解：加载核心配置文件，sping测试类
 * @author wangzhiwen
 *
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpaTest {
	@Autowired
	private UserService userService;
	@Autowired
	private StudentServiceImpl studentService;
	@Autowired
	private PeopleService peopleService;
	
	//添加
	@Test
	@Transactional //事务注解，异常回滚
	@Rollback(value = false)
	public void addUserTest() {
		User user = new User();
		user.setUsername("小w");
		user.setSex("男");
		user.setAge(18);
		userService.addUser(user);
	}
	
	//删除
	@Test
	@Transactional
	@Rollback(value = false)
	public void deleteUser() {
		User user = new User();
		user.setId(1);
		userService.deleteUser(user);
	}
	
	//修改
	@Test
	@Transactional
	@Rollback(value = false)
	public void updateUser() {
		User user = new User();
		user.setId(2);
		user.setAge(89);
		user.setSex("修改");
		user.setUsername("修改名称");
		userService.updateUser(user);
	}
	
	//查询所有信息，无条件查询
	@Test
	@Transactional
	@Rollback
	public void selectUser() {
		userService.selectUser();
	}
	
	@Test
	public void findByUsername() {
		List<User> list = userService.findByUsername("小w");
		System.out.println(list.size());
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryUserByUsername() {
		List<User> list = userService.queryUserByName("小");
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryUserByUsernameSql() {
		List<User> list = userService.queryUserByNameSql("小");
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	@Transactional
	@Rollback(value = false)
	public void deleteUserById() {
		userService.deleteUserById(2);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void addPeople() {
		People people = new People();
		people.setName("4");
		people.setCountryName("4");
		people.setOcupation("4");
		people.setType("4");
		peopleService.addPeople(people);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void deletePeople() {
		People people = new People();
		people.setId(1);
		peopleService.deletePeople(people);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void updatePeople() {
		People people = new People();
		people.setId(2);
		people.setCountryName("修改");
		people.setOcupation("修改");
		people.setName("修改");
		people.setType("修改");
		peopleService.updatePeople(people);
	}
	
	@Test
	public void selectPeople() {
		People people = new People();
		people.setId(2);
		peopleService.selectPeopple(people);
	}
	
	//多条件查询及分页排序
	@Test
	public void searchUser() {
		User user = new User();
		//user.setId(2);
		List<User> list = userService.searchUser(user);
		for (User u : list) {
			System.out.println(u);
		}
	}
}

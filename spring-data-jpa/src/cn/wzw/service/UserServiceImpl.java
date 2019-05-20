package cn.wzw.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.wzw.dao.UserDao;
import cn.wzw.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	//添加记录
	public void addUser(User user) {
		User u = dao.save(user);
		System.out.println(u);
	}
	
	//删除记录
	public void deleteUser(User user) {
		dao.delete(user);
	}
	
	//更新
	public void updateUser(User user) {
		dao.save(user);
	}
	
	//查询
	public void selectUser() {
		List<User> list = dao.findAll();
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println(dao);
	}

	@Override
	public List<User> findByUsername(String name) {
		// TODO Auto-generated method stub
		return dao.findByUsername(name);
	}

	@Override
	public List<User> queryUserByName(String username) {
		// TODO Auto-generated method stub
		return dao.queryUserByName(username);
	}

	@Override
	public List<User> queryUserByNameSql(String name) {
		// TODO Auto-generated method stub
		return dao.queryUserByNameSql(name);
	}

	@Override
	public void updateUsernameById(String username, Integer id) {
		// TODO Auto-generated method stub
		dao.updateUsernameById(username, id);
	}

	@Override
	public void deleteUserById(Integer id) {
		dao.deleteUserById(id);
	}

	//多条件的查询
	@Override
	public List<User> searchUser(User user) {
		//使用内部类的方式，设置查询条件
		Specification<User> spec = new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				//predicate：定义查询条件
				//Root<User> root:泛型，root中封装了查询条件，即实体内属性 
				//CriteriaQuery<?> cq:定义一个基本查询，一般不使用
				//CriteriaBuilder cb：创建查询条件,,
				
				//多条件查询时，需要设置多个predicate对象来封装查询的条件。
				List<Predicate> predicates = new ArrayList<Predicate>(); //查询条件
				//利用if判断可以解决不定参数的查询问题
				if(user.getId() > 0)
					//添加一个查询条件，对象的属性等于某个值
					predicates.add(cb.equal(root.get("id"), user.getId()));
				if(user.getUsername() != null && !user.getUsername().trim().isEmpty())
					predicates.add(cb.equal(root.get("username"), user.getUsername()));
				if(user.getAge() != null && user.getAge() > 0)
					predicates.add(cb.equal(root.get("age"), user.getAge()));
				if(user.getSex() != null && !user.getSex().trim().isEmpty())
					predicates.add(cb.equal(root.get("sex"), user.getSex()));
				//因为设置多条件的查询关系时，需要传递一个可变参数。所以这里使用数组传递
				Predicate[] arr = new Predicate[predicates.size()];
				//多条件的查询方式为and
				Predicate res =  cb.and(predicates.toArray(arr));
				return res;
			}
		};
		//可以设置结果的排序方式
		Sort sort = new Sort(Direction.DESC,"id");
		//设置分页，分页接口由pageRequest类实现
		Pageable pageable = new PageRequest(0, 5, sort);
		//执行查询方法，findall传入查询条件
		Page<User> page = dao.findAll(spec, pageable);
		List<User> users = page.getContent();
		long total = page.getTotalElements();
		long Pages = page.getTotalPages();
		System.out.println("总页数："+Pages);
		System.out.println("总记录数："+total);
		return users;
	}

}

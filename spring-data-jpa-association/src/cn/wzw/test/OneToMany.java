package cn.wzw.test;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.wzw.dao.ADao;
import cn.wzw.dao.BDao;
import cn.wzw.pojo.A;
import cn.wzw.pojo.B;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OneToMany {
	@Autowired
	private ADao aDao;
	@Autowired
	private BDao bDao;
	
	/**
	 * 一对多级联添加，多个A对应一个B。在配置外键的实体类中配置级联属性
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void add() {
		//添加实体
		B b = new B();
		b.setBname("b1");
		
		A a = new A();
		a.setAname("a2");
		
		A a2 = new A();
		a2.setAname("a3");
		//设置实体包含关系
		A a3 = new A();
		a3.setAname("a4");
		A a4 = new A();
		a4.setAname("a5");
		
		b.getA().add(a);
		b.getA().add(a2);
		b.getA().add(a3);
		b.getA().add(a4);
		a.setB(b);
		a2.setB(b);
		a3.setB(b);
		a4.setB(b);
		
		//保存含有外键的实体，另一个会被级联保存
		aDao.save(a);
		aDao.save(a2);
		aDao.save(a3);
		aDao.save(a4);
	}
	
	/**
	 * 一对多级联查询
	 */
	@Test
	public void query() {
		A a = aDao.findOne(8);
	 	B b = a.getB();
		System.out.println(a);
		System.out.println(b);
		B b1 = bDao.findOne(4);
		//System.out.println(b1.getA().size());
	}
}

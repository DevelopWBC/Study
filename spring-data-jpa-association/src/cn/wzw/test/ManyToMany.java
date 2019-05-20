package cn.wzw.test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.wzw.dao.CDao;
import cn.wzw.dao.DDao;
import cn.wzw.pojo.C;
import cn.wzw.pojo.D;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ManyToMany {
	
	@Autowired
	private CDao cDao;
	@Autowired
	private DDao dao;
	
	/**
	 * 多对多关系的级联添加
	 */
	
	@Test
	@Transactional
	@Rollback(false)
	public void add() {
		C c1 = new C();
		c1.setCname("c1");
		
		C c2 = new C();
		c2.setCname("c2");
		
		D d1 = new D();
		d1.setDname("d1");
		D d2 = new D();
		d2.setDname("d2");
		
		c1.getD().add(d1);
		c1.getD().add(d2);
		c2.getD().add(d1);
		c2.getD().add(d2);
		
		d1.getC().add(c1);
		d1.getC().add(c2);
		d2.getC().add(c1);
		d2.getC().add(c2);
		
		cDao.save(c1);
		cDao.save(c2);
	}
	
	@Test
	public void query() {
		C c = cDao.findOne(3);
		System.out.println(c);
		Set<D> d = c.getD();
		for (D d2 : d) {
			System.out.println(d2);
		}
	}
}

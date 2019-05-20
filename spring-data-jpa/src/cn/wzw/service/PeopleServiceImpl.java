package cn.wzw.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wzw.dao.PeopleDao;
import cn.wzw.pojo.People;

@Service
public class PeopleServiceImpl implements PeopleService{

	@Autowired
	private PeopleDao dao;
	
	@Override
	public void addPeople(People people) {
		// TODO Auto-generated method stub
		People p = dao.save(people);
		System.out.println(p);
	}

	@Override
	public void deletePeople(People people) {
		// TODO Auto-generated method stub
		dao.delete(people);
	}

	@Override
	public void updatePeople(People people) {
		// TODO Auto-generated method stub
		dao.save(people);
	}

	@Override
	public List<People> selectPeopple(People people) {
		// TODO Auto-generated method stub
		People one = dao.findOne(people.getId());
		System.out.println("根据ID查询："+one);
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		List<People> peoples = (List<People>)dao.findAll();
		System.out.print("根据ID集合查询：");
		for (People people2 : peoples) {
			System.out.print(people2+"  ");
		}
		return (List<People>)dao.findAll();
	}

}

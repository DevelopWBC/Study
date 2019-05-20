package cn.wzw.service;

import java.util.List;

import cn.wzw.pojo.People;

public interface PeopleService {
	void addPeople(People people);
	void deletePeople(People people);
	void updatePeople(People people);
	List<People> selectPeopple(People people);
}

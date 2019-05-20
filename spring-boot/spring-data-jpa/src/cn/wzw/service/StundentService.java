package cn.wzw.service;

import java.util.List;

import cn.wzw.pojo.Student;

public interface StundentService {
	void addStudent(Student student);
	void deleteStudent(Student student);
	void updateStudent(Student student);
	Student findStudentById(Integer id);
	//根据命名规则查询
	//根据名字查询，肯能有多条
	List<Student> findByName(String name);
	//AND查询
	List<Student> findByNameAndSex(String name,String sex);
	//OR查询
	List<Student> findByNameOrSex(String name,String sex);
	//between查询
	List<Student> findByIdBetween(Integer start,Integer end);
	//like查询
	List<Student> findByNameLike(String name);
	//NotLike
	List<Student> findByNameNotLike(String name);
	//IN查询
	List<Student> findByBameIn(List<Integer> id);
	//大于
	List<Student> findByIdGreaterThan(Integer id);
	//大于等于
	List<Student> findByIdGreaterThanEqual(Integer id);
	//小于
	List<Student> findByIdLessThan(Integer id);
	//小于等于
	List<Student> findByIdLessThanEqual(Integer id);
	
	//根据注解查询
	Student selectStudent(Integer id);
	Student selectStudentBySql(Integer id);
}

package cn.wzw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wzw.dao.StudentDao;
import cn.wzw.pojo.Student;

@Service
public class StudentServiceImpl implements StundentService {

	@Autowired
	private StudentDao dao;

	@Override
	public void updateStudent(Student student) {
		//dao.updateNameById(student.getName(),student.getId());;
	}

	@Override
	public Student findStudentById(Integer id) {
		Student student = dao.findById(id);
		return student;
	}

	@Override
	public List<Student> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<Student> findByNameAndSex(String name, String sex) {
		return dao.findByNameAndSex(name, sex);
	}

	@Override
	public List<Student> findByNameOrSex(String name, String sex) {
		return dao.findByNameOrSex(name, sex);
	}



	@Override
	public List<Student> findByNameLike(String name) {
		return dao.findByNameLike(name);
	}

	@Override
	public List<Student> findByNameNotLike(String name) {
		return dao.findByNameNotLike(name);
	}

	@Override
	public List<Student> findByBameIn(List<Integer> id) {
		return null;
	}

	@Override
	public List<Student> findByIdGreaterThan(Integer id) {
		// TODO Auto-generated method stub
		return dao.findByIdGreaterThan(id);
	}

	@Override
	public List<Student> findByIdGreaterThanEqual(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByIdLessThan(Integer id) {
		// TODO Auto-generated method stub
		return dao.findByIdLessThan(id);
	}

	@Override
	public List<Student> findByIdLessThanEqual(Integer id) {
		// TODO Auto-generated method stub
		return dao.findByIdLessThanEqual(id);
	}

	@Override
	public Student selectStudent(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectStudent(id);
	}

	@Override
	public Student selectStudentBySql(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectStudentBySql(id);
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> findByIdBetween(Integer start, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

}

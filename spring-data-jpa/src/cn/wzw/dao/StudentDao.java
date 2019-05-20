package cn.wzw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import cn.wzw.pojo.Student;

/**
 * Repository : 顶层接口，方法需要自定义
 *   两种查询方式：1.根据特定的命名规则，实现查询。findBy+
 *   		 2.使用@Query 注解实现 jpql sql 的语句查询
 * @author wangzhiwen
 *
 */
public interface StudentDao extends Repository<Student, Integer> {
	//根据ID查询
	Student findById(Integer id);
	//根据名字查询，肯能有多条
	List<Student> findByName(String name);
	//AND查询
	List<Student> findByNameAndSex(String name,String sex);
	//OR查询
	List<Student> findByNameOrSex(String name,String sex);
	//between查询
	//List<Student> findByIdBetween(Integer start,Integer end);
	//like查询
	List<Student> findByNameLike(String name);
	//NotLike
	List<Student> findByNameNotLike(String name);
	//IN查询
	List<Student> findByNameIn(List<Integer> id);
	//大于
	List<Student> findByIdGreaterThan(Integer id);
	//大于等于
	List<Student> findByIdGreaterThanEqual(Integer id);
	//小于
	List<Student> findByIdLessThan(Integer id);
	//小于等于
	List<Student> findByIdLessThanEqual(Integer id);
	//true
	//List<Student> findBySexTrue(boolean sex);
	
	/**
	 * 注解查询方式
	 */
	//jpql
	@Query("from Student where id = ?")
	Student selectStudent(Integer id);
	//sql
	@Query(value = "select * from student where id = ?",nativeQuery = true)
	Student selectStudentBySql(Integer id);
	
	//使用注解完成更新
	/*
	 * @Query(value = "update Student set name = ? where id = ?")
	 * 
	 * @Modifying void updateNameById(String name,Integer id);
	 */
	/*
	 * //使用注解完成新增,不能新增数据
	 * 
	 * @Query(value = "insert into student values(?,?,?,?,?,?)",nativeQuery = true)
	 * 
	 * @Modifying void insertStudent(int id ,String address,Integer grend,String
	 * name,int num,String sex); 
	 * 
	 * //删除，不能删除数据
	 * @Query(value = "delete form student where id = ?",nativeQuery = true)
	 * 
	 * @Modifying void deleteStudent(Integer id);
	 */
}

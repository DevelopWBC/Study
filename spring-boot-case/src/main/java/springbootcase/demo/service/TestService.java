package springbootcase.demo.service;

import springbootcase.demo.pojo.data.test1.Student;
import springbootcase.demo.pojo.data.test2.User;
import springbootcase.demo.pojo.data.test3.Person;

import java.util.List;

/**
 * Service/DAO 层方法命名规约
 * 1） 获取单个对象的方法用 get 做前缀。
 * 2） 获取多个对象的方法用 list 做前缀，复数形式结尾如：listObjects。
 * 3） 获取统计值的方法用 count 做前缀。
 * 4） 插入的方法用 save/insert 做前缀。
 * 5） 删除的方法用 remove/delete 做前缀。
 * 6） 修改的方法用 update 做前缀
 */
public interface TestService {
    void service();
    void insertUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    User getUser(Integer id);
    List<User> listUsers();
    Integer countUser();

    void saveStudent(Student student);
    void removeStudent(Student student);
    void updateStudent(Student student);
    Student getStudent();
    List<Student> listStudents();
    Integer countStudent();

    void insertPerson(Person person);
    void deletePerson(Integer id);
    void updatePerson(Person person);
    Person getPerson(Integer id);
    List<Person> listPersons();
    Integer countPerson();
}

package springbootcase.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import springbootcase.demo.dao.test1.StudentRepository;
import springbootcase.demo.dao.test2.UserMapper;
import springbootcase.demo.dao.test3.PersonMapper;
import springbootcase.demo.pojo.data.test1.Student;
import springbootcase.demo.pojo.data.test2.User;
import springbootcase.demo.pojo.data.test3.Person;
import springbootcase.demo.service.TestService;

import java.util.List;

/**
 * @Author Wangzhiwen
 * @ClassName TestServiceImpl
 * @Description
 * @Date 2019/7/29 14:37
 * @Version 1.0
 */
@Service
public class TestServiceImpl implements TestService {

    private final StudentRepository studentRepository;
    private final UserMapper userMapper;
    private final PersonMapper personMapper;

    @Autowired
    public TestServiceImpl(StudentRepository studentRepository,UserMapper userMapper,PersonMapper personMapper){
        this.studentRepository = studentRepository;
        this.userMapper = userMapper;
        this.personMapper = personMapper;
    }

    @Override
    public void service() {
        System.out.println("quartz任务框架。。");
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userMapper.deleteUser(user.getId());
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    /**
     * 使用spring来管理线程池，注解的方式选择某个方法被新线程执行。此时用户不用等待此方法执行完成后才收到数据，立即返回。
     */
    @Async
    @Override
    public User getUser(Integer id) {
        try {
            System.out.println("新线程开始执行："+Thread.currentThread().getName());
            Thread.sleep(300000);
            System.out.println("新线程结束执行："+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> listUsers() {
        List<User> users = userMapper.listUser();
        if (users != null && !users.isEmpty()){
            return users;
        }
        return null;
    }

    @Override
    public Integer countUser() {
        Integer count = userMapper.countUser();
        return count;
    }

    @Override
    public void saveStudent(Student student) {

    }

    @Override
    public void removeStudent(Student student) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public Student getStudent() {
        return null;
    }

    @Override
    public List<Student> listStudents() {
        return null;
    }

    @Override
    public Integer countStudent() {
        return null;
    }

    @Override
    public void insertPerson(Person person) {

    }

    @Override
    public void deletePerson(Integer id) {

    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public Person getPerson(Integer id) {
        return null;
    }

    @Override
    public List<Person> listPersons() {
        List<Person> people = personMapper.listPerson();
        return people;
    }

    @Override
    public Integer countPerson() {
        return null;
    }
}

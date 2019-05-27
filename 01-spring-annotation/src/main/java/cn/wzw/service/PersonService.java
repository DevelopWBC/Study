package cn.wzw.service;

import cn.wzw.dao.PersonDao;
import cn.wzw.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Wangzhiwen
 * @ClassName Person
 * @Description
 * @Date 2019/5/23 11:04
 * @Version 1.0
 */
@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    @Transactional
    public void insertPerson(Person person){
        personDao.save(person);
        System.out.println("新增成功.....");
    }
}

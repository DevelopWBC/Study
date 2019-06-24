package cn.wzw.datasource.service;

import cn.wzw.datasource.repository.test.User;
import cn.wzw.datasource.repository.test2.Person;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Wangzhiwen
 * @ClassName TestService
 * @Description
 * @Date 2019/6/12 8:50
 * @Version 1.0
 */
public class TestService {
    @Autowired
    private User userDao;
    @Autowired
    private Person personDao;

    public void all(){

    }
}

package cn.wzw.datasource.repository.test;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface User extends JpaRepository<cn.wzw.datasource.pojo.test.User,Integer> {
    List<cn.wzw.datasource.pojo.test.User> findByIdIn(List<Integer> ids);
}

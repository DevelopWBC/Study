package cn.wzw.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.wzw.pojo.User;

public interface UserDao extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{

}

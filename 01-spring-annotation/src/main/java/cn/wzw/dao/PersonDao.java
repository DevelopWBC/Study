package cn.wzw.dao;

import cn.wzw.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Wangzhiwen
 * @ClassName PersonDao
 * @Description
 * @Date 2019/5/23 11:02
 * @Version 1.0
 */
public interface PersonDao extends JpaRepository<Person,Integer> {
}

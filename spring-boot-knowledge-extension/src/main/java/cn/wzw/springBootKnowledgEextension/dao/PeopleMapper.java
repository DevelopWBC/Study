package cn.wzw.springBootKnowledgEextension.dao;

import cn.wzw.springBootKnowledgEextension.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Wangzhiwen
 * @ClassName PeopleMapper
 * @Description：使用配置文件的方式
 * @Date 2019/6/3 13:16
 * @Version 1.0
 */
@Mapper
public interface PeopleMapper {
   void addPeople();
   void deletePeople(Integer id);
   void updatePeople(User people);
   List<User> findAll();
}

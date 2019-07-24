package cn.wzw.springBootKnowledgEextension.dao;

import cn.wzw.springBootKnowledgEextension.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
  *@author Wangzhiwen
  *@description：整合mybatis注解版
  *@date 2019/6/3 11:59
  *@param
  *@return
*/
//@Mapper //开启注解，表名这是一个mapper接口
public interface UserMapper {
    @Select("select * from t_person")
    List<User> findAll();
    @Insert("insert into t_person(age,name) values(#{age},#{name}) ")
    void addPerson(User person);
    @Update("update t_person set username=#{person.username} where id = #{person.id}")
    void updatePersonUsername(User person);
    @Delete("delete t_person where id = #{id}")
    void deletePerson(Integer id);
}

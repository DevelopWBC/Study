package springbootcase.demo.dao.test3;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import springbootcase.demo.pojo.data.test3.Person;

import java.util.List;

/**
  *@author Wangzhiwen
  *@description：整合mybatis注解版
  *@date 2019/6/3 11:59
  *@param
  *@return
*/
//@Mapper //开启注解，表名这是一个mapper接口
public interface PersonMapper {
    @Select("select * from person")
    List<Person> listPerson();
    @Insert("insert into person(age,name) values(#{age},#{name}) ")
    void insertPerson(Person person);
    @Update("update person set username=#{person.username} where id = #{person.id}")
    void updatePerson(Person person);
    @Delete("delete person where id = #{id}")
    void deletePerson(Integer id);
}

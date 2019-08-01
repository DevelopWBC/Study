package springbootcase.demo.dao.test2;

import springbootcase.demo.pojo.data.test2.User;

import java.util.List;

/**
 * @Author Wangzhiwen
 * @ClassName
 * @Description：使用配置文件的方式
 * @Date 2019/6/3 13:16
 * @Version 1.0
 */
//@Mapper
public interface UserMapper {
   void insertUser(User user);
   void deleteUser(Integer id);
   void updateUser(User user);
   User getUserById(Integer id);
   List<User> listUser();
   Integer countUser();
}

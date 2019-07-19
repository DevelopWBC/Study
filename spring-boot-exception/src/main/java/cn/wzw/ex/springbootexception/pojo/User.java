package cn.wzw.ex.springbootexception.pojo;

/**
 * @Author Wangzhiwen
 * @ClassName User
 * @Description
 * @Date 2019/7/1 13:54
 * @Version 1.0
 */
public class User {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
}

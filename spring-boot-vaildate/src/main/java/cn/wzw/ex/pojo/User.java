package cn.wzw.ex.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @Author Wangzhiwen
 * @ClassName User
 * @Description:参数的校验：在属性上注解的方式限定
 *    @NotBlank:不能为空，去掉前后空格
 * @Date 2019/5/5 17:25
 * @Version 1.0
 */
public class User {
    @NotBlank(message = "名称不能为空")
    private String name;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "年龄不能为空")
    @Min(message = "最小年龄不得低于3岁",value = 3)
    @Max(message = "最大年龄不得高于20岁",value = 20)
    private int age;
    @Email
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}

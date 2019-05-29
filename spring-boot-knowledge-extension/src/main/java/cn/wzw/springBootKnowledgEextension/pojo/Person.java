package cn.wzw.springBootKnowledgEextension.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author Wangzhiwen
 * @ClassName person
 * @Description
 * @Date 2019/5/29 17:05
 * @Version 1.0
 */
//@ConfigurationProperties注解可以将配置文件中定义的多个属性映射到实体类中，支持数据校验支持复杂类型的包装。
    //该注解默认是在全局配置文件中加载属性，配合@PropertySource()指定加载配置文件。取出结果
@Component
@ConfigurationProperties(prefix = "person")
//@ImportResource(locations = "classpath:/bean.xml") //指定加载xml配置文件
public class Person {
    private String name;
    private int age;
    private String sex;
    private String email;
    private List<String> arr;
    private List<String> arr2;
    private Map<String,Object> map1;
    private Map<String,Object> map2;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", arr=" + arr +
                ", arr2=" + arr2 +
                ", map1=" + map1 +
                ", map2=" + map2 +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getArr() {
        return arr;
    }

    public void setArr(List<String> arr) {
        this.arr = arr;
    }

    public List<String> getArr2() {
        return arr2;
    }

    public void setArr2(List<String> arr2) {
        this.arr2 = arr2;
    }

    public Map<String, Object> getMap1() {
        return map1;
    }

    public void setMap1(Map<String, Object> map1) {
        this.map1 = map1;
    }

    public Map<String, Object> getMap2() {
        return map2;
    }

    public void setMap2(Map<String, Object> map2) {
        this.map2 = map2;
    }
}

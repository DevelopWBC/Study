package demo;

import java.util.function.Predicate;

/**
 * @Author Wangzhiwen
 * @ClassName Person
 * @Description
 * @Date 2019/7/24 11:21
 * @Version 1.0
 */
public class Person{

    private String idCart;
    private String name;
    private int age;

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
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

    public boolean isStudent(){
        return this.idCart.equals("student");
    }

}

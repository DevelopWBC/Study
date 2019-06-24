package cn.wzw.datasource.pojo.test2;

import javax.persistence.*;

/**
 * @Author Wangzhiwen
 * @ClassName Person
 * @Description
 * @Date 2019/6/12 8:34
 * @Version 1.0
 */
@Entity
@Table(name = "t_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

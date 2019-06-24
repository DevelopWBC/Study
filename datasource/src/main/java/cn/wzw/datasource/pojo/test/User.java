package cn.wzw.datasource.pojo.test;

import javax.persistence.*;

/**
 * @Author Wangzhiwen
 * @ClassName User
 * @Description
 * @Date 2019/6/12 8:32
 * @Version 1.0
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
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

package springbootcase.demo.pojo.data.test2;

import java.io.Serializable;

/**
 * @Author Wangzhiwen
 * @ClassName User
 * @Description
 * @Date 2019/7/29 15:58
 * @Version 1.0
 */
public class User implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

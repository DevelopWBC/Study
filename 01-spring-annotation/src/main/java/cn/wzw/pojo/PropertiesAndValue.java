package cn.wzw.pojo;

/**
 * @Author Wangzhiwen
 * @ClassName PropertiesAndValue
 * @Description
 * @Date 2019/5/24 17:11
 * @Version 1.0
 */
public class PropertiesAndValue {
    private String name;
    private String sex;
    private String age;

    public PropertiesAndValue() {
    }

    public PropertiesAndValue(String name, String sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

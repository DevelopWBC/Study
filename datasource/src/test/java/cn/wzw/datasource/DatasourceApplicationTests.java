package cn.wzw.datasource;

import cn.wzw.datasource.repository.test.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourceApplicationTests {

    @Autowired
    private User user;

    @Test
    public void contextLoads() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        List<cn.wzw.datasource.pojo.test.User> byIdIn = user.findByIdIn(ids);
        System.out.println(byIdIn.size());
    }

}

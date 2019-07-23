package cn.wzw.springBootKnowledgEextension;

import cn.wzw.springBootKnowledgEextension.pojo.Person;
import cn.wzw.springBootKnowledgEextension.pojo.User;
import cn.wzw.springBootKnowledgEextension.service.PeopleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootKnowledgeExtensionApplicationTests {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private PeopleService peopleService;

    @Test
    public void contextLoads() {
        Person bean = context.getBean(Person.class);
        System.out.println(bean);
        List<User> all = peopleService.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        List<User> allP = peopleService.findAllP();
        for (User user : allP) {
            System.out.println(user);
        }
    }


}

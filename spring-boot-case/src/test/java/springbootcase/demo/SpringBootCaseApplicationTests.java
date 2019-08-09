package springbootcase.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springbootcase.demo.util.SendMailUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCaseApplicationTests {

    @Autowired
    private SendMailUtil sendMailUtil;

    @Test
    public void contextLoads() {
        String msg = sendMailUtil.snedFileMail();
        System.out.println(msg);
    }

}

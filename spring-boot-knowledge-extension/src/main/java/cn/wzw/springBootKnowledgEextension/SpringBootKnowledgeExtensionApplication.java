package cn.wzw.springBootKnowledgEextension;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
  *@author Wangzhiwen
  *@description：springboot启动类
  *@date 2019/5/29 16:54
  *@param
  *@return
*/

@SpringBootApplication
@MapperScan(basePackages = "cn.wzw.springBootKnowledgEextension.dao") //配置扫描的方式，接口中就不用写@Mapper注解
public class SpringBootKnowledgeExtensionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKnowledgeExtensionApplication.class, args);
    }

}

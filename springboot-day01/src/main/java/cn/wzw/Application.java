package cn.wzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 启动springboot的方法，编写一个类运行main方法。
 * 启动类是加载它在的包下的子包，启动类所在包不能与其他包同级
 * @author Wangzhiwen
 *
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

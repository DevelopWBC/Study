package cn.wzw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot整合持久层mybatis
 * @author Wangzhiwen
 *
 */
@SpringBootApplication
@MapperScan("cn.wzw.mapper") //扫描mapper，生成代理。
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

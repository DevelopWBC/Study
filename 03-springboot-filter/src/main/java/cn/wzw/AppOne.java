package cn.wzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AppOne {
	public static void main(String[] args) {
		SpringApplication.run(AppOne.class, args);
	}
}

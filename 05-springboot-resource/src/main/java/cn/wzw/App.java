package cn.wzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot下访问静态资源，有两种方式：1.放在clsspath目录下的static文件夹下。新建static目录，可以再往里面追加目录层次
 * 									 2.放在clsses目录下的webapp中。新建wenapp
 * @author Wangzhiwen
 *
 *设置上传文件的大小，在classpath下创建application.properties文件。只能放这
 *单个文件允许上传的最大容量
 *Spring.http.multipart.maxFileSize=100MB
  一个请求中允许上传的最大容量
  Spring.http.multipart.maxRequestSize=200MB
 *
 */
@SpringBootApplication
public class App {
public static void main(String[] args) {
	SpringApplication.run(App.class, args);
}
}

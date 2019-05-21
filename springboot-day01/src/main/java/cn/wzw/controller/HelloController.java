package cn.wzw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * springboot启动，无需配置文件
 * @author Wangzhiwen
 *
 */
@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String showHello(){
		String msg = "启动成功";
		return msg;
	}
}

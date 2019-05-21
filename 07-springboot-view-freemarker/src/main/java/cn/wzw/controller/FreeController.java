package cn.wzw.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wzw.pojo.User;

@Controller
public class FreeController {
	@RequestMapping("/indexFree")
	public String showInfo(Model model){
		List<User> list = new ArrayList<User>();
		list.add(new User(10, "小胡", "男"));
		list.add(new User(20, "小王", "女"));
		list.add(new User(30, "小李", "女"));
		list.add(new User(40, "小孙", "女"));
		model.addAttribute("list", list);
		model.addAttribute("date", new Date());
		return "index";
	}
}

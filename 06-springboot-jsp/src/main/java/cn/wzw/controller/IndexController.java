package cn.wzw.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wzw.pojo.User;

/**
 * 表现层
 * @author Wangzhiwen
 *
 */
@Controller
public class IndexController {
	@RequestMapping("/indexView")
	public String indexView(Model model){
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User(18,"小米","男"));
		list.add(new User(28,"小花","女"));
		list.add(new User(38,"小水","女"));
		list.add(new User(48,"小垃圾","男"));
		model.addAttribute("list", list);
		return "user";
	}
}

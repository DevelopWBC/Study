package cn.wzw.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wzw.pojo.User;
import cn.wzw.service.UserService;
import cn.wzw.util.Code;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//添加用户
	@RequestMapping("/adduser")
	public String addUser(User user,Model model){
		userService.addUser(user);
		model.addAttribute("msg", "用户添加成功");
		return "stats"; 
	}
	
	//查看用户
	@RequestMapping("/selectall")
	public String selectAll(Model model){
		List<User> list = userService.selectAllUser();
		model.addAttribute("list", list);
		return "alluser";
	}
	
	//根据id查看用户
	@RequestMapping("/findUserById")
	public String findUserById(Integer id,Model model){
		User user = userService.selectUserById(id);
		model.addAttribute("user", user);
		return "updateuser";
	}
	
	
	//修改用户信息
	@RequestMapping("/updateuserinfo")
	@ResponseBody
	public Code updateUser(User user,HttpServletResponse response){
		response.setContentType("application/json;charset=utf-8");
		userService.updateUser(user);
		Code code = new Code(200, "更新成功");
		return code;
	}
	
	//删除用户
	@RequestMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable(value="id") String id,Model model){
		userService.deleteUser(Integer.parseInt(id));
		model.addAttribute("msg", "用户已删除");
		return "stats";
	}
}

package com.feinno.controller;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feinno.entity.User;
import com.feinno.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("findUser.do")
	public String find(Model model){
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user/user_list";
	}
	
	//先跳转到添加页面
	@RequestMapping("toAddUser.do")
	public String toAdd(){
		return "user/add_user";
	}
	@RequestMapping("addUser.do")
	public String add(User user){
		userService.save(user);
		return "redirect:findUser.do";
	}
	
	//跳转到修改页面
	@RequestMapping("toUpdateUser.do")
	public String toUpdate(String id,Model model){
		//查询
		User user=userService.findByRowKey(id);
		//绑
		model.addAttribute("user", user);
		return "user/update_user";
	}
	
	//回到列表页面
	@RequestMapping("updateUser.do")
	public String update(User user){
		userService.update(user);
		return "redirect:findUser.do";
	}
	//删除
	@RequestMapping("deleteUser.do")
	public String delete(@RequestParam("id") String id){
		userService.delete(id);
		return "redirect:findUser.do";
	}
		
}
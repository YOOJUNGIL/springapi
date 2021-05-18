package com.fintech.springapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fintech.springapi.api.dao.dto.CustUser;
import com.fintech.springapi.api.dao.service.custuser.CustUserService;

@RestController
public class UserMgtController {
	
	@Autowired
	private CustUserService custUserService;
	
	// index
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("thymeleaf/index");
		return mv;
	}
	
	// 전체조회 : http://localhost:8082/api/user
	@GetMapping("/usermgt/user")
	public ModelAndView getUsers() {
		ModelAndView mv = new ModelAndView("thymeleaf/custuser/custUserList");
		List<CustUser> custUserList = custUserService.getCustUserList();
		mv.addObject(custUserList);
		return mv;
	}
	
	// 건별조회  : http://localhost:8082/api/user/YOO
	@GetMapping("/usermgt/user/{userId}")
	public ModelAndView getUser(@PathVariable String userId) {
		ModelAndView mv = new ModelAndView("thymeleaf/custuser/custUserDetail");
		CustUser cusUser = custUserService.getCustUser(userId);
		mv.addObject(cusUser);
		return mv;
	}
	
	// 등록화면
	@RequestMapping("/usermgt/user/addmove")
	public ModelAndView addmove() {
		ModelAndView mv = new ModelAndView("thymeleaf/custuser/custUserAdd");
		return mv;
	}
	
	// 등록 : http://localhost:8082/api/user
	@PostMapping("/usermgt/user")
	public String regUser(@RequestBody CustUser cusUser) {
		int regCount = custUserService.save(cusUser);
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("	\"result\" : " + (regCount > 0 ? "success" : "fail"));
		sb.append("}");
		return sb.toString();
	}
	
	// 수정화면
	@RequestMapping("/usermgt/user/modMove/{userId}")
	public ModelAndView modMove(@PathVariable String userId) {
		ModelAndView mv = new ModelAndView("thymeleaf/custuser/custUserUpd");
		CustUser cusUser = custUserService.getCustUser(userId);
		mv.addObject(cusUser);
		return mv;
	}
	
	// 수정 : http://localhost:8082/api/user/YOO
	@PutMapping("/usermgt/user/{userId}")
	public String modUser(@PathVariable String userId, @RequestBody CustUser custUser) {
		int modCount = custUserService.modify(custUser);
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("	\"result\" : " + (modCount > 0 ? "success" : "fail"));
		sb.append("}");
		return sb.toString();
	}
	
	// 삭제 : http://localhost:8082/api/user/YOO
	@DeleteMapping("/usermgt/user/{userId}")
	public String delUser(@PathVariable String userId) {
		int delCount = custUserService.delete(userId);
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("	\"result\" : " + (delCount > 0 ? "success" : "fail"));
		sb.append("}");
		return sb.toString();
	}
	
}

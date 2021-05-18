package com.fintech.springapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.springapi.api.cont.Cont;
import com.fintech.springapi.api.dao.dto.CommonDto;
import com.fintech.springapi.api.dao.dto.CustUser;
import com.fintech.springapi.api.dao.service.custuser.CustUserService;

@RestController
public class UserController {
	
	@Autowired
	private CustUserService custUserService;
	
	// 전체조회 : http://localhost:8082/api/user
	@GetMapping("/api/user")
	public CommonDto<List<CustUser>> getUsers() {
		List<CustUser> custUserList = custUserService.getCustUserList();
		//return custUserList;
		return new CommonDto<>(HttpStatus.OK.value(), Cont.SUCCESS_MESSAGE, custUserList);
	}
	
	// 건별조회  : http://localhost:8082/api/user/YOO
	@GetMapping("/api/user/{userId}")
	public CommonDto<CustUser> getUser(@PathVariable String userId) {
		CustUser cusUser = custUserService.getCustUser(userId);
		//return cusUser;
		return new CommonDto<>(HttpStatus.OK.value(), Cont.SUCCESS_MESSAGE, cusUser);
	}
	
	// 등록 : http://localhost:8082/api/user
	@PostMapping("/api/user")
	public CommonDto<String> regUser(@RequestBody CustUser cusUser) {
		//int regCount = custUserService.save(cusUser);
		//StringBuffer sb = new StringBuffer();
		//sb.append("{");
		//sb.append("	\"result\" : " + (regCount > 0 ? "success" : "fail"));
		//sb.append("}");
		//return sb.toString();
		custUserService.save(cusUser);
		return new CommonDto<>(HttpStatus.OK.value(), Cont.SUCCESS_MESSAGE, "ok");
	}
	
	// 수정 : http://localhost:8082/api/user/YOO
	@PutMapping("/api/user/{userId}")
	public CommonDto<String> modUser(@PathVariable String userId, @RequestBody CustUser custUser) {
		//int modCount = custUserService.modify(custUser);
		//StringBuffer sb = new StringBuffer();
		//sb.append("{");
		//sb.append("	\"result\" : " + (modCount > 0 ? "success" : "fail"));
		//sb.append("}");
		//return sb.toString();
		custUserService.modify(custUser);
		return new CommonDto<>(HttpStatus.OK.value(), Cont.SUCCESS_MESSAGE, "ok");
	}
	
	// 삭제 : http://localhost:8082/api/user/YOO
	@DeleteMapping("/api/user/{userId}")
	public CommonDto<String> delUser(@PathVariable String userId) {
		//int delCount = custUserService.delete(userId);
		//StringBuffer sb = new StringBuffer();
		//sb.append("{");
		//sb.append("	\"result\" : " + (delCount > 0 ? "success" : "fail"));
		//sb.append("}");
		//return sb.toString();
		custUserService.delete(userId);
		return new CommonDto<>(HttpStatus.OK.value(), Cont.SUCCESS_MESSAGE, "ok");
	}
	
}

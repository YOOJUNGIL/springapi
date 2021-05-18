package com.fintech.springapi.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.springapi.api.dao.dto.CustUser;

@RestController
public class HttpController {
	
	// 1.Get
	// QueryString이 없는 경우 			text/plain
	@RequestMapping("/http/get1")
	public String get1() {
		return "get : queryString 없음"; 
	}
	
	// QueryString를 변수로 받는 경우 		text/plain {form-data, x-www-form-urlencoded 가능}
	@RequestMapping("/http/get2")
	public String get2(@RequestParam String userId, @RequestParam String mobileNo, @RequestParam String addr) {
		return userId + " : " + mobileNo + " : " + addr;
	}
	
	// QueryString을 객체로 받는 경우		text/plain {form-data, x-www-form-urlencoded 가능}
	@RequestMapping("/http/get3")
	public String get3(CustUser custUser) {
		return custUser.getUserId() + " : " + custUser.getMobileNo() + " : " + custUser.getAddr();
	}
	
	// 2.Post
	// Body영역에 데이터를 실어 보낼 수 있음	text/plain
	@PostMapping("/http/post1")
	public String post1() {
		return "post 요청";
	}
	
	// Body영역에 데이터를 실어 보낼 수 있음 	text/plain {form-data, x-www-form-urlencoded 가능}
	@PostMapping("/http/post2")
	public String post2(@RequestParam String userId, @RequestParam String mobileNo, @RequestParam String addr) {
		return userId + " : " + mobileNo + " : " + addr;
	}
	
	// Body영역에 데이터를 실어 보낼 수 있음 	text/plain {form-data, x-www-form-urlencoded ▶ 객체}
	@PostMapping("/http/post3")
	public String post3(CustUser custUser) {
		return custUser.getUserId() + " : " + custUser.getMobileNo() + " : " + custUser.getAddr();
	}
	
	// Body영역에 데이터를 객체로 받음 		application/json {json ▶ 객체}
	@PostMapping("/http/post4")
	public String post5(@RequestBody CustUser custUser) {
		return custUser.getUserId() + " : " + custUser.getMobileNo() + " : " + custUser.getAddr();
	}
	
	// Body영역에 데이터를 text 받음 			text/plain
	@PostMapping("/http/post5")
	public String post4(@RequestBody String text) {
		return text;
	}
	
	// 3.Put
	// Body영역에 데이터를 실어 보낼 수 있음	text/plain
	@PutMapping("/http/put1")
	public String put1() {
		return "put 요청";
	}
	
	// Body영역에 데이터를 실어 보낼 수 있음	text/plain {form-data, x-www-form-urlencoded 가능}
	@PutMapping("/http/put2")
	public String put2(@RequestParam String userId, @RequestParam String mobileNo, @RequestParam String addr) {
		return userId + " : " + mobileNo + " : " + addr;
	}
	
	// Body영역에 데이터를 실어 보낼 수 있음	text/plain {form-data, x-www-form-urlencoded 가능}
	@PutMapping("/http/put3")
	public String put3(CustUser custUser) {
		return custUser.getUserId() + " : " + custUser.getMobileNo() + " : " + custUser.getAddr();
	}
	
	// Body영역에 데이터를 실어 보낼 수 있음	application/json {json ▶ 객체}
	@PutMapping("/http/put4")
	public String put4(@RequestBody CustUser custUser) {
		return custUser.getUserId() + " : " + custUser.getMobileNo() + " : " + custUser.getAddr();
	}
	
	// 4.Delete
	// Body영역에 데이터를 실어 보낼 수 있음	text/plain
	@DeleteMapping("/http/delete1")
	public String delete1() {
		return "delete 요청";
	}
	
	// Body영역에 데이터를 실어 보낼 수 있음	text/plain {form-data, x-www-form-urlencoded 가능}
	@DeleteMapping("/http/delete2")
	public String delete2(@RequestParam String userId, @RequestParam String mobileNo, @RequestParam String addr) {
		return userId + " : " + mobileNo + " : " + addr;
	}
	
	// Body영역에 데이터를 실어 보낼 수 있음	text/plain {form-data, x-www-form-urlencoded 가능}
	@DeleteMapping("/http/delete3")
	public String delete3(CustUser custUser) {
		return custUser.getUserId() + " : " + custUser.getMobileNo() + " : " + custUser.getAddr();
	}
	
	// Body영역에 데이터를 실어 보낼 수 있음	application/json {json ▶ 객체}
	@DeleteMapping("/http/delete4")
	public String delete4(@RequestBody CustUser custUser) {
		return custUser.getUserId() + " : " + custUser.getMobileNo() + " : " + custUser.getAddr();
	}
	
}

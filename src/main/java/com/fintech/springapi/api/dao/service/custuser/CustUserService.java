package com.fintech.springapi.api.dao.service.custuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.springapi.api.dao.dto.CustUser;
import com.fintech.springapi.api.dao.mybatis.mariadb.custuser.CustUserMapper;

@Service
public class CustUserService {

	@Autowired
	private CustUserMapper mapper;
	
	public List<CustUser> getCustUserList() {
		List<CustUser> custUserList = null;
		
		try {
			custUserList = mapper.getCustUserList();
		} catch(Exception e) {
			throw new IllegalArgumentException("Database가 정상적이지 않습니다.");
		}
		
		if(custUserList.size() == 0) {
			throw new IllegalArgumentException("조회할 사용자목록이 없습니다.");
		}
		
		return custUserList;
	}
	
	public CustUser getCustUser(String userId) {
		CustUser custUser = null;
		
		try {
			custUser = mapper.getCustUser(userId);
		} catch(Exception e) {
			throw new IllegalArgumentException("Database가 정상적이지 않습니다.");
		}
		
		if(custUser == null) {
			throw new IllegalArgumentException("조회할 UserId가 없습니다.");
		}
		
		return custUser;
	}

	public int save(CustUser custUser) {
		int regCount = 0;
		
		try {
			regCount = mapper.save(custUser);
		} catch(Exception e) {
			throw new IllegalArgumentException("입력시 오류가 발생했습니다.");
		}
		
		return regCount;
	}

	public int modify(CustUser custUser) {
		int modCount = 0;
		
		try {
			modCount = mapper.modify(custUser);
		} catch(Exception e) {
			throw new IllegalArgumentException("Database가 정상적이지 않습니다.");
		}
		
		if(modCount == 0) {
			throw new IllegalArgumentException("수정할 UserId가 없습니다.");
		}
		
		return modCount;
	}

	public int delete(String userId) {
		int delCount = 0;
		
		try {
			delCount = mapper.delete(userId);
		} catch(Exception e) {
			throw new IllegalArgumentException("Database가 정상적이지 않습니다.");
		}
		
		if(delCount == 0) {
			throw new IllegalArgumentException("삭제할 UserId가 없습니다.");
		}
		
		return mapper.delete(userId);
	}

}

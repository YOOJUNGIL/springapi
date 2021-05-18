package com.fintech.springapi.api.dao.mybatis.mariadb.custuser;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fintech.springapi.api.dao.dto.CustUser;

@Mapper
public interface CustUserMapper {

	public List<CustUser> getCustUserList();
	public CustUser getCustUser(String userId);
	public int save(CustUser custUser);
	public int modify(CustUser custUser);
	public int delete(String userId);
}

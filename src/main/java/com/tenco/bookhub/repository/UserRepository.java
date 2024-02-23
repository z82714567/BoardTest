package com.tenco.bookhub.repository;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.bookhub.entity.User;

@Mapper
public interface UserRepository {

	// insert, update, delete는 무조건 리턴 타입이 int
	// 왜 int? 각 쿼리문이 성공한 횟수를 int로 리턴해줌
	public int signup(User user); // 회원 가입
	
	public User getUser(String username); // 회원 정보 가져오기 
}

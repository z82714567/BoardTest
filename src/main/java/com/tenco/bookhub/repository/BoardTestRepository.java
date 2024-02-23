package com.tenco.bookhub.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.bookhub.entity.BoardTest;

@Mapper
public interface BoardTestRepository {

	// 게시글 작성
	public  int insert(BoardTest boardTest); 
		
	// 게시글 전체 리스트
	public List<BoardTest> selectAll();

	// 게시글 상세 보기
	public BoardTest detailview(int id);

	// 게시글 수정 하기
	public int updateBoard(BoardTest boardTest);

	// 게시글 삭제 하기
	public int deleteBoard(int id); 
	
	
		
	
}


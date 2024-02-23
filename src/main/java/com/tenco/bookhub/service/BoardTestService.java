package com.tenco.bookhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.bookhub.entity.BoardTest;
import com.tenco.bookhub.repository.BoardTestRepository;
import com.tenco.bookhub.web.dto.BoardTestDto;

@Service
public class BoardTestService {

	@Autowired
	BoardTestRepository boardTestRepository;

	// 게시글 작성
	public boolean insert(BoardTestDto dto) {

		BoardTest boardTest = new BoardTest();
		boardTest.setTitle(dto.getTitle());
		boardTest.setContent(dto.getContent());

		///////////////////////////////////////

		BoardTest boardTest2 = BoardTest.builder().title(dto.getTitle()).content(dto.getContent()).build();

		int result = boardTestRepository.insert(boardTest2);

		if (result == 1) {
			return true;
		}

		return false;
	}

	// 게시글 목록 조회
	public List<BoardTest> selectAll() {

		List<BoardTest> list = boardTestRepository.selectAll();

		System.out.println("디비에서 가져옴 " + list.toString());

		return list;

		// return boardTestRepository.selectAll(); 같은거
	}

	// 게시글 상세보기
	public BoardTest detailview(int id) {

		return boardTestRepository.detailview(id);
	}

	// 게시글 수정하기
	public boolean updateBoard(int id, BoardTestDto dto) {

		System.out.println("여기는 서비스 " + dto.toString());
		
		BoardTest boardTest = BoardTest.builder()
				.title(dto.getTitle())
				.content(dto.getContent())
				.id(id)
				.build();

		int result = boardTestRepository.updateBoard(boardTest);

		System.out.println("여기는 서비스 " + boardTest.toString());
		
		System.out.println(result);
		
		if (result == 1) {
			return true;
		}

		return false;
	}

	// 게시글 삭제하기
	public boolean deleteBoard(int id) {
		
		int result = boardTestRepository.deleteBoard(id);
		
		if (result == 1) {
			return true;
		}

		return false;
	}


}

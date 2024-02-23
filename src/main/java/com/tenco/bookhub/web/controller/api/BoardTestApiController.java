package com.tenco.bookhub.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tenco.bookhub.entity.BoardTest;
import com.tenco.bookhub.service.BoardTestService;
import com.tenco.bookhub.web.dto.BoardTestDto;

@Controller
@RequestMapping("/board/test")
public class BoardTestApiController {

	@Autowired
	BoardTestService boardTestService;

	// 게시글 작성 (요청만)
	@PostMapping("/insert")
	public String insert(BoardTestDto dto) {
		boolean result = boardTestService.insert(dto);

		if (result == true) {
			return "/home";
		}

		return "/error";
	}

	
	// 게시판 글 전부 들고 오기(json) (요청, 응답)
	@GetMapping("/select-all")
	@ResponseBody //응답 --> 안쓸거면 @RestController로 변경해주면 됨
	public List<BoardTest> selectAll() {

		// 여러개를 select해서 들고 올 때는 리턴 타입이 무조건 List<>() 이다.
		List<BoardTest> list = boardTestService.selectAll();

		return list;
	}

	/*
	 * // 게시판 상세보기
	 * 
	 * @GetMapping("/detailview/{id}")
	 * 
	 * @ResponseBody 
	 * public String selectBoard(@PathVariable int id) {
	 * 
	 * System.out.println("주소에서 가져옴 : " + id);
	 * 
	 * return ""; }
	 */
	
	// 주석처리와 차이점 : 
	// 게시판 상세보기 (요청, 응답)
	@PostMapping("/detailview")
	@ResponseBody //응답 --> 안쓸거면 @RestController로 변경해주면 됨
	public BoardTest selectBoard(int id) {

		BoardTest boardTest = boardTestService.detailview(id);

		return boardTest;
	}
	
	// 게시글 수정하기 (요청, 응답)
	@PostMapping("/update/{id}") //{id} 경로 변수, @PathVariable 사용해서 매개변수로 사용
	@ResponseBody //응답 --> 안쓸거면 @RestController로 변경해주면 됨
	public boolean updateBoard(@PathVariable int id, BoardTestDto dto) {
		
		System.out.println("아이디번호" + id);
		System.out.println("데이터" + dto);
		
		// insert, update, delete 요청 시 --> 서비스에게서 리턴 받는 타입은 무조건 boolean이다.
		boolean result = boardTestService.updateBoard(id, dto);

		return result;  
	}
	
	//Unknown return value type: java.lang.Boolean 에러
	//@ResponseBody를 추가 -> 해결
	
	// 게시글 삭제하기 (요청, 응답)
	@PostMapping("/delete/{id}")
	@ResponseBody //응답 --> 안쓸거면 @RestController로 변경해주면 됨
	public boolean deleteBoard(@PathVariable int id) {
		
		System.out.println("아이디번호" + id);

		boolean result = boardTestService.deleteBoard(id);
		
		return result; 
	}

}

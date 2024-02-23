package com.tenco.bookhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.bookhub.entity.User;
import com.tenco.bookhub.repository.UserRepository;
import com.tenco.bookhub.web.dto.UserRequestDto;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HttpSession httpSession;
	
	public boolean signup(UserRequestDto dto) {
		
		User user = new User();
		
		user.setUsername(dto.getUsername());
		user.setName(dto.getName());
		user.setPassword(dto.getPassword());
		user.setPhone(dto.getPhone());
		
		User userEntity = User.builder()
				.username(dto.getUsername())
				.name(dto.getName())
				.password(dto.getPassword())
				.phone(dto.getPhone())
				.build();
		
		int result = userRepository.signup(userEntity); // userDto, userEntity 선택해서 사용 하면 됨
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
	// insert, update, delete 요청 시 --> 레파지토리에게서 리턴 받는 타입은 무조건 int이다.
	// 예 ) int result = userRepository.signup(userEntity);
	// 서비스 -> 레파지토리 요청시에는 무조건 dto -> entity이다.
	
	public boolean signin(UserRequestDto dto) {
	
		// 로그인 시 회원정보를 가져와서(엔티티에서 가져 옴)(select)  
		User userEntity = userRepository.getUser(dto.getUsername());
		
		// dto.password와 entity.password 가 일치하는지 확인.
		// 문자열 비교 .equals메서드 사용 --> 무조건 true(일치) /false(불일치)를 리턴해준다.
		if(dto.getPassword().equals(userEntity.getPassword()) ) { // 결과가 true이면
			// 패스워드가 일치하면 세션이 유저 정보를 저장해야 한다.
			// 세션을 쓰려면 HttpSession객체를 DI 해야 한다.
			
			userEntity.setPassword(null); // password까지 넘겨주면 안되니까 null로 해주기
			
			httpSession.setAttribute("user", userEntity);
			return true;
			
		}
		
		return false;
	}
	
}

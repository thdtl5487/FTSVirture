package com.springboot.react.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.react.security.model.User;
import com.springboot.react.security.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder BCryptPasswordEncoder;
	
	
	@GetMapping("/user")
	public @ResponseBody String user() {
		return "user";
	}
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "admin";
	}
	
	@GetMapping("/joinout")
	public String Logout() {
		return "/Logout";
	}
	
	// Spring Security에서 우선적으로 인터셉트 실행됨.
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	
	@PostMapping("/join")
	public String join(User user) {
		System.out.println(user);  // Console 창에 출력된 user 내용 확인 바랍니다.
		user.setRole("ROLE_USER");
		String rawPassword = user.getUserpw();
		String encPassword = BCryptPasswordEncoder.encode(rawPassword);
		user.setUserpw(encPassword);
		userRepository.save(user);
		return "redirect:/loginForm";
	}

	@PreAuthorize("hasRole('ROLE_MEMBER')or hasRole('ROLE_ADMIN')") // @PreAuthorize :  : 컨트롤러에 어노테이션 직접 설정할 수 있으며, 여러개 시큐리티 적용할 때 유용한 어노테이션임.
	@GetMapping("/commuity/*")
	public String commuity() {
		return "index";
	}	

	@Secured("ROLE_ADMIN")  // @Secured : 컨트롤러에 어노테이션 직접 설정할 수 있으며, 특정 메소드 한개에 시큐리티 적용할때 유용한 어노테이션임.
	@GetMapping("/notice/*")
	public @ResponseBody String info() {
		return "관리자 정보";
	}
	
}

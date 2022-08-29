//package com.springboot.react.security.auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.springboot.react.security.model.User;
//import com.springboot.react.security.repository.UserRepository;
//
//
//// 시큐리티 설정에서 loginProcessiongUrl("/login");
//// /login 요청이 오면 자동으로 UserDetatilsService 타입으로IoC 되어 있는 loadUserByUsername 함수가 실행
//@Service
//public class PrincipalDetailsService implements UserDetailsService{
//
//	@Autowired
//	private UserRepository userRepository;
//	
//	// 시큐리티 session(내부 Authentication(내부 UserDetails))
//	@Override
//	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
//		User userEntity = userRepository.findByuserid(userid);  // findByUsername : Jpa Query methods
//		if(userEntity != null) {
//			return new PrincipalDetails(userEntity);
//		}	
//		return null;
//	}
//}
package com.springboot.react.security.auth;

import java.util.ArrayList;	
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.react.security.model.User;

import lombok.Data;

//시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
//로그인을 진행이 완료가 되면 시큐리티 session을 만들어줍니다. (Security ContextHolder)
//Authentication 객체에 저장할 수 있는 유일한 타입
//오브젝트 => Authentication 타입 객체
//Authentication 안에 User 정보가 있어야 됨.
//User 오브젝트 타입 => UserDetails 타입 객체
//Security Session => Authentication => UserDetails  


@Data
public class PrincipalDetails implements UserDetails {
	
	private User user;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<GrantedAuthority>();
		collect.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});
		return collect;
		
	}

	@Override
	public String getPassword() {
		return user.getUserpw();
	}

	@Override
	public String getUsername() {
		return user.getUserid();
	}
	
	public String getUseremail() {
		return user.getUseremail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

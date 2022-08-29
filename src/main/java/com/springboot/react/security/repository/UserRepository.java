//package com.springboot.react.security.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.springboot.react.security.model.User;
//
////JpaRepository 를 상속하면 자동 컴포넌트 스캔됨.
////CRUD 함수를 JpaRepository가 들고 있음.
////@Repository라는 어노테이션이 없어도 IoC 됩니다. 이유는 JpaRepository를 상속했기 때문입니다.
//public interface UserRepository extends JpaRepository<User, Integer>{
//	
//	public User findByuserid(String userid);
//	
//}

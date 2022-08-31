package com.springboot.react.cboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



public interface CBoardRepositoryInterface extends JpaRepository<CBoardVO, Long>, CrudRepository<CBoardVO, Long>{
   
	CBoardVO save(CBoardVO vo);
	
	void delete(CBoardVO vo);
	

	
	
	

	
}
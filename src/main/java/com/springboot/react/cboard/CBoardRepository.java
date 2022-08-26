package com.springboot.react.cboard;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.springboot.react.cboard.CBoardVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CBoardRepository {
	
	// @PersistenceContext : JPA의 ORM을 처리해주는 EntityManager을 불러올 때 쓰는 애노테이션 입니다.
	@PersistenceContext	
	private final EntityManager em;
	

	public void insert(CBoardVO vo) {
		// em.persist : JPA를 통해 값을 입력할 때 활용합니다.
		em.persist(vo);								
	}
	
	public CBoardVO selectById(CBoardVO vo) {
		
		CBoardVO result = null;
		try {
			result = em.createQuery("select a from CBoardVO a where a.BNum = (select max(a.BNum) from CBoardVO a)",CBoardVO.class).getSingleResult();
													// em.createQuery : JPA를 통해 쿼리문을 직접 입력할 때
													// getSingleResult() : 값이 단 하나일 경우를 처리하는 메소드 (0개나 2개 이상일 경우를 예외처리 해줘야함) 
		}
		catch (NoResultException e) {				// 1. 값이 0개일 경우 예외처리
			System.out.println("No Result");
		}
		catch (NonUniqueResultException e) {		// 2. 값이 2개 이상일 경우 예외처리
			System.out.println("No Unique Result");
		}
		
		return result;
	}
	
	public void delete(CBoardVO vo) {
		em.remove(vo);								// em.remove : JPA를 통해 값을 제거할 때
	}
	
	public List<CBoardVO> getList(CBoardVO vo){
	      
	      List<CBoardVO> getList = em.createQuery("select b from CBoardVO b").getResultList();
	      System.out.println(getList.get(1).getBtitle());
	      System.out.println(getList.get(2).getBtitle());
	      System.out.println(getList.get(3).getBtitle());
	      System.out.println(getList.get(4).getBtitle());
	      
	      return getList;
	   }
	   
	   
	
}
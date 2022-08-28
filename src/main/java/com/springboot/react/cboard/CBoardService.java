package com.springboot.react.cboard;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.springboot.react.cboard.CBoardVO;

import com.springboot.react.cboard.CBoardRepository;

import lombok.RequiredArgsConstructor;

@Service("cboardService")
@RequiredArgsConstructor
public class CBoardService {
	
	// @RequiredArgsConstructor : private final이 붙은 필드의 생성자를 자동으로 추가해주고, @Autowired를 통해 주입도 자동으로 해주는 롬복 애노테이션
	private final CBoardRepository cboardDAO;

	
	public CBoardVO selectById(CBoardVO vo) {
		return cboardDAO.selectById(vo);
	}

	// select 쿼리처럼 조회하는 것이 아닌 insert, update, delete의 경우 @Transactional 애노테이션을 붙여 트랜잭션 처리를 해줘야함
	// (commit, rollback 등이 필요한 쿼리문...)
	@Transactional
	public void insert(CBoardVO vo) {
		cboardDAO.insert(vo);
	}
	
	@Transactional
	public void update(CBoardVO vo, String Btitle, String Btext,String bwriter) {
		CBoardVO selected = cboardDAO.selectById(vo);
		selected.setBtitle(Btitle);
		selected.setBtext(Btext);
		selected.setBwriter(bwriter);
	}
	
	@Transactional
	public void delete(CBoardVO vo) {
		CBoardVO selected = cboardDAO.selectById(vo);
		cboardDAO.delete(selected);
	}
	
	
   public List<CBoardVO> getList(CBoardVO vo){
	      return cboardDAO.getList(vo);
	   }

	
	
}
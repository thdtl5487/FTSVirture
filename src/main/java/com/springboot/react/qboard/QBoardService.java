package com.springboot.react.qboard;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.react.cboard.CBoardRepository;
import com.springboot.react.cboard.CBoardVO;

import lombok.RequiredArgsConstructor;

@Service("qboardService")
@RequiredArgsConstructor
public class QBoardService {
	
	
	private final CBoardRepository cboardDAO;


	

	@Transactional
	public void insert(CBoardVO vo) {
		cboardDAO.insert(vo);
	}
	
	
 
   public ResponseEntity<Map> getPagingBoard(Integer pageNum){
	   return cboardDAO.getPagingBoard(pageNum);
   }
   
   public ResponseEntity<Map> getBoard(Long bnum){
	   return cboardDAO.getBoard(bnum);
   }
	
	
}
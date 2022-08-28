package com.springboot.react.cboard;

import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.react.cboard.CBoardService;
import com.springboot.react.cboard.CBoardVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Cboard")
public class CBoardController {

	// @RequiredArgsConstructor : private final이 붙은 필드의 생성자를 자동으로 추가해주고, @Autowired를 통해 주입도 자동으로 해주는 롬복 애노테이션
	private final CBoardService cboardService;
	
	@GetMapping("/getList.do")
	public ResponseEntity<Map> viewCBoardList(@RequestParam(value = "pageNum", required = false)Integer pageNum){
		System.out.println("@@@viewCBoardList 실행@@@@");
		if(pageNum == null || pageNum <= 0) {
			pageNum = 1;
		}
		return cboardService.getPagingBoard(pageNum);
	}
	
	
	
	
	
	// 아래 모든 메소드에 request.setAttribute("article", articleService.selectById(vo))를 해주는것과 같은 역할
//	@ModelAttribute("cboard")
//	public CBoardVO getArticle(CBoardVO vo) {
//		return cboardService.selectById(vo);
//	}
//	
//	@ModelAttribute("cboardList")
//	public List<CBoardVO> getListForm(CBoardVO vo){
//		return cboardService.getList(vo);
//	}
//	
//	// 홈 화면
//	@RequestMapping("/")
//	public String home() {
//		return "index";
//	}
//	
//	// 게시글 등록 폼
//	@GetMapping("/community/write.do")
//	public String insertForm() {
//		return "views/insertForm";
//	}
//	
//	// 게시글 등록
//	@PostMapping("/community/write.do")
//	public String insert(CBoardVO vo) {
//		cboardService.insert(vo);
//		return "views/insertSuccess";
//	}
//	
//	// 게시글 조회
//	@RequestMapping("/community/read.do")
//	public String selectById(CBoardVO cboard) {
//		return "views/readArticle";
//	}
//	
//	// 게시글 수정 폼
//	@GetMapping("/community/modify.do")
//	public String updateForm() {
//		return "views/updateForm";
//	}
//	
//	// 게시글 수정
//	@PostMapping("/community/modify.do")
//	public String update(CBoardVO vo, String btitle, String btext, String bwriter) {
//		cboardService.update(vo, btitle, btext,bwriter);
//		return "views/updateSuccess";
//	}
//	
//	// 게시글 삭제 폼
//	@GetMapping("/community/delete.do")
//	public String deleteForm() {
//		return "views/deleteForm";
//	}
//	
//	// 게시글 삭제
//	@PostMapping("/community/delete.do")
//	public String delete(CBoardVO vo) {
//		cboardService.delete(vo);
//		return "views/deleteSuccess";
//	}
//	
//
//   
//   @GetMapping("/community/getList.do")
//   public String getList(CBoardVO vo) {
//      cboardService.getList(vo);
//	  return "views/getListForm";
//   }

}
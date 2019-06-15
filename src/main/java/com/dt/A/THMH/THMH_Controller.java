package com.dt.A.THMH;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dt.N.TI.Team;


/**
 * Handles requests for the application home page.
 */
@Controller
public class THMH_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(THMH_Controller.class);
		
	@Autowired
	private ThmhSv thmhSv;
	
	
	@RequestMapping(value = "/my_homeform", method = RequestMethod.GET)
	public ModelAndView mh_form(@ModelAttribute Board board) {
		ModelAndView mav = thmhSv.my_home(board);
		return mav;
	}//개인 홈으로 이동(오늘의 일정, 해쉬코드 검색 결과 값이 나오는 페이지)
	
	@RequestMapping(value = "/m_todayCalInsertform", method = RequestMethod.GET)
	public ModelAndView m_todayCalInsertform() {
		return new ModelAndView("home");
	}//개인 홈에서의 일정 등록 페이지로 이동
	
	@RequestMapping(value = "/findHashform", method = RequestMethod.GET)
	public ModelAndView findHashform(@ModelAttribute Board board) {		
		ModelAndView mav = thmhSv.excute(1, board);
		return mav;
	}//해귀코드 검색창
	
	@RequestMapping(value = "/findHashDetailform", method = RequestMethod.POST)
	public ModelAndView findHashDetailform(@ModelAttribute Board board) {	
		//System.out.println(board.getHs_Title());
		ModelAndView mav = thmhSv.excute(2, board);
		return mav;
	}//해귀코드를 더많은 결과값 페이지로 이동 
	
	@RequestMapping(value = "/hashBoardDetail", method = RequestMethod.POST)
	public ModelAndView hashBoardDetail(@ModelAttribute Board board) {	
		//System.out.println(board.getHs_Title());
		ModelAndView mav = thmhSv.excute(3, board);
		return mav;
	}//해귀코드를 더많은 결과값 페이지로 이동 
	
	@RequestMapping(value = "/team_homeform", method = RequestMethod.GET)
	public ModelAndView th_form(@ModelAttribute Team team) {		
		ModelAndView mav = thmhSv.team_Home(team);
		return mav;
	}//팀 홈으로 이동(오늘의 일정, 공지사항, 관리할 일, 최근 업데이트)
	
	@RequestMapping(value = "/t_todayCalInsertform", method = RequestMethod.GET)
	public ModelAndView t_todayCalInsertform() {		
		return new ModelAndView("home");
	}//팀 홈에서의 일정 등록 페이지로 이동
	
	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public ModelAndView comment() {		
		return new ModelAndView("templte/board");
	}//팀 홈에서의 일정 등록 페이지로 이동
	
//	@RequestMapping(value = "/boardInsertform", method = RequestMethod.GET)
//	public ModelAndView boardInsertform() {		
//		return new ModelAndView("home");
//	}//공지사항 등록을 위한 게시판등록 페이지로 이동 
//	
//	@RequestMapping(value = "/bworkInsertform", method = RequestMethod.GET)
//	public ModelAndView bworkInsertform() {		
//		return new ModelAndView("home");
//	}//업무 등록 페이지로 이동
	

}


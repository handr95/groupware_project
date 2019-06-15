package com.dt.B.PJ;

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


/**
 * Handles requests for the application home page.
 */
@Controller
public class Project_Controller {
	
	@Autowired
	private ProjectSv projectSv;
	
	@Autowired
	private PJCRSv pjcrSv;
	private static boolean token=false; 
	private static final Logger logger = LoggerFactory.getLogger(Project_Controller.class);
		
	@RequestMapping(value = "/sessionset", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView session(@ModelAttribute Project project) {		
		ModelAndView mav = projectSv.excute(0,project);
		return mav;
	}//프로젝트 목록 페이지로 이동
	
	@RequestMapping(value = "/projectform", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView projectform(@ModelAttribute Project project) {		
		if(token == true){
			token = false;
		}ModelAndView mav = projectSv.excute(1, project);	
		return mav;
	}//프로젝트 목록 페이지로 이동
	
	@RequestMapping(value = "/projectDetailform", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView projectDetailform(@ModelAttribute Project project) {
		if(token == true){
			token = false;
		}ModelAndView mav = projectSv.excute(2, project);	
		return mav;
	}//프로젝트 상세정보 페이지로 이동
	
	@RequestMapping(value = "/projectInsertform", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView projectInsertform(@ModelAttribute Project project) {	
		if(token == true){
			token = false;
		}ModelAndView mav = projectSv.excute(3, project);	
		return mav;
	}//프로젝트 등록 페이지로 이동
	
	@RequestMapping(value = "/projectInsert", method = RequestMethod.POST)
	public ModelAndView projectInsert(@ModelAttribute Project project) {		
		ModelAndView mav=null;
		if(token == false){
			mav = projectSv.excute(4, project);
			token = true;
		}else{
			mav = projectSv.excute(1, project);	
		}
		return mav;
	}//프로젝트 등록
	
	
	@RequestMapping(value = "/projectUpdateform", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView projectUpdateform(@ModelAttribute Project project) {		
		if(token == true){
			token = false;
		}ModelAndView mav = projectSv.excute(5, project);	
		return mav;
	}//프로젝트 수정 페이지로 이동
	
	@RequestMapping(value = "/projectUpdate", method = RequestMethod.POST)
	public ModelAndView projectUpdate(@ModelAttribute Project project) {
		ModelAndView mav=null;	
		if(token == false){
			mav = projectSv.excute(6, project);
			token = true;
		}else{
			mav = projectSv.excute(5, project);
		
		}
		return mav;
	}//프로젝트 수정
	
	@RequestMapping(value = "/projectDelete", method = RequestMethod.GET)
	public ModelAndView projectDelete(@ModelAttribute Project project) {		
		ModelAndView mav;
		if(token == false){
			mav = projectSv.excute(7, project);
			token = true;
		}else{
			mav = projectSv.excute(2, project);
		}
		return mav;
	}//프로젝트 삭제
		
	
	

	@RequestMapping(value = "/pjbworkConnect", method = RequestMethod.GET)
	public ModelAndView bworkConnect(@ModelAttribute BWork bwork) {		
		ModelAndView mav =null;
		if(token == false){
			mav = projectSv.excute(2, bwork);
			token = true;
		}else{
			mav = projectSv.excute(1, bwork);
		}
			
		return mav;
	}//업무 연결
	
	@RequestMapping(value = "/pjbworkUnconnect", method = RequestMethod.GET)
	public ModelAndView bworkUnconnectform(@ModelAttribute BWork bwork) {		
		ModelAndView mav = projectSv.excute(3, bwork);	
		return mav;
	}//업무 해제
	
	@RequestMapping(value = "/pjbworkInsertform", method = RequestMethod.GET)
	public ModelAndView bworkInsertform(@ModelAttribute BWork bwork) {		
		return new ModelAndView("/service/myInfo");
	}//업무 등록 페이지로 이동
	
	@RequestMapping(value = "/pjbworkInsert", method = RequestMethod.GET)
	public ModelAndView bworkInsert(@ModelAttribute BWork bwork) {		
		ModelAndView mav = projectSv.excute(4, bwork);	
		return mav;
	}//업무 등록
	

	@RequestMapping(value = "/projectTcommectList", method = RequestMethod.GET)
	public ModelAndView projectTcommectList(Comment comment) {		
		ModelAndView mav = pjcrSv.excute(1, comment);
		return mav;
	}//프로젝트 댓글 등록
	
	@RequestMapping(value = "/projectTcommectInsert", method = RequestMethod.GET)
	public ModelAndView projectTcommectInsert(@ModelAttribute Comment comment) {		
		ModelAndView mav = pjcrSv.excute(1, comment);
		return mav;
	}//프로젝트 댓글 등록
	
	@RequestMapping(value = "/projectTcommectUpdate", method = RequestMethod.GET)
	public ModelAndView projectTcommectUpdate(@ModelAttribute Comment comment) {		
		ModelAndView mav = pjcrSv.excute(2, comment);
		return mav;
	}//프로젝트 댓글 수정 
	
	@RequestMapping(value = "/projectTcommectDelete", method = RequestMethod.GET)
	public ModelAndView projectTcommectDelete(@ModelAttribute Comment comment) {		
		ModelAndView mav = pjcrSv.excute(3, comment);
		return mav;
	}//프로젝트 댓글 삭제
	@RequestMapping(value = "/pjCommentUpdateForm", method = RequestMethod.GET)
	public ModelAndView pjCommentUpdateForm(@ModelAttribute Comment comment) {		
		ModelAndView mav = pjcrSv.excute(4, comment);
		return mav;
	}//프로젝트 댓글 수정폼
	@RequestMapping(value = "/pjCommentSel", method = RequestMethod.GET)
	public ModelAndView pjCommentSel(@ModelAttribute Comment comment) {		
		ModelAndView mav = pjcrSv.excute(5, comment);
		return mav;
	}//프로젝트 댓글 수정폼
	/*
	@RequestMapping(value = "/projectTreplyInsert", method = RequestMethod.GET)
	public ModelAndView projectTreplyInsert(Reply reply) {		
		ModelAndView mav = pjcrSv.excute(1, reply);
		return mav;
	}//프로젝트 답글 등록
	
	@RequestMapping(value = "/projectTreplyUpdate", method = RequestMethod.GET)
	public ModelAndView projectTreplyUpdate(Reply reply) {		
		ModelAndView mav = pjcrSv.excute(2, reply);
		return mav;
	}//프로젝트 답글 수정
	
	@RequestMapping(value = "/projectTreplyDelete", method = RequestMethod.GET)
	public ModelAndView projectTreplyDelete(Reply reply) {		
		ModelAndView mav = pjcrSv.excute(3, reply);
		return mav;
	}//프로젝트 답글 삭제
	*/
}


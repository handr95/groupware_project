 package com.dt.E.BO;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@Controller
public class Board_Controller {
	
	@Autowired
	BoardSv boardSv;
	@Autowired
	private BOCRSv bocrSv;
	private ModelAndView mav;

	private static final Logger logger = LoggerFactory.getLogger(Board_Controller.class);
		
	
	@RequestMapping(value = "/boardForm", method= RequestMethod.GET)
	public ModelAndView  boardForm(@ModelAttribute Board board) {	
		ModelAndView mav = boardSv.excute(1, board);	
		return mav;
	}
	
	@RequestMapping(value = "/boardListForm", method= RequestMethod.GET)
	public ModelAndView  boardListForm(@ModelAttribute Board board) {
		ModelAndView mav = boardSv.excute(2, board);	
		return mav;
	}	
	
	@RequestMapping(value = "/boardDetailForm", method= RequestMethod.GET)
	public ModelAndView boardselForm(@ModelAttribute BoardDetail boardDetail) {		
		ModelAndView mav = boardSv.excute(1,boardDetail);	
		return mav;
	}
	@RequestMapping(value = "/boardPanForm") 
	public ModelAndView boardPanForm() {		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/boardInsertForm")
	public ModelAndView boardInsertForm(@ModelAttribute Board boardbean) {	
		ModelAndView mav = boardSv.excute(3, boardbean);	
		return mav;
	}
	@RequestMapping(value = "/boardInsert")
	public ModelAndView boardInsert(@ModelAttribute Board boardbean) {		
		ModelAndView mav = boardSv.excute(4, boardbean);	
		return mav;
	}
	
	@RequestMapping(value = "/boardUpdateForm")
	public ModelAndView boardUpdateform(@ModelAttribute BoardDetail boardDetail) {		
		ModelAndView mav = boardSv.excute(2, boardDetail);	
		return mav;
	}
	@RequestMapping(value = "/boardUpdate")
	public ModelAndView boardUpdate(@ModelAttribute Board boardbean){		
		ModelAndView mav = boardSv.excute(5, boardbean);	
		return mav;
	}
	@RequestMapping(value = "/boardDelete")
	public ModelAndView boardDelete(@ModelAttribute Board boardbean) {		
		ModelAndView mav = boardSv.excute(8, boardbean);	
		return mav;
	}
	
	@RequestMapping(value = "/co")
	public ModelAndView comment() {			
		return new ModelAndView("/templte/board");
	}

//	@RequestMapping(value = "/findHash")
//	public ModelAndView findHash(@ModelAttribute Hash hashcodebean) {		
//		ModelAndView mav = boardSv.excute(1, hashcodebean);	
//		return mav;
//	}
//	@RequestMapping(value = "/hashDetail")
//	public ModelAndView hashDetail(@ModelAttribute Hash hashcodebean) {		
//		ModelAndView mav = boardSv.excute(2, hashcodebean);	
//		return mav;
//	}
	
	@RequestMapping(value = "/boCommentInsert" , method= RequestMethod.POST)
	public ModelAndView boCommentInsert(@ModelAttribute Comment comment) {			
		System.out.println(comment.getCm_Comment());
		mav = bocrSv.excute(1, comment);
		return mav;
	}
	@RequestMapping(value = "/boCommentSel", method= RequestMethod.POST)
	public ModelAndView boCommentSel(@ModelAttribute Comment comment) {			
		mav = bocrSv.excute(4, comment);
		return mav;
	}
	@RequestMapping(value = "boCommentDelete", method= RequestMethod.POST)
	public ModelAndView boCommentDelete(@ModelAttribute Comment comment) {			
		mav = bocrSv.excute(3, comment);
		return mav;
	}
	@RequestMapping(value = "boCommentUpdateForm", method= RequestMethod.POST)
	public ModelAndView boCommentUpdateForm(@ModelAttribute Comment comment) {			
		mav = bocrSv.excute(5, comment);
		return mav;
	}
	@RequestMapping(value = "boCommentUpdate", method= RequestMethod.POST)
	public ModelAndView boCommentUpdate(@ModelAttribute Comment comment) {			
		mav = bocrSv.excute(2, comment);
		return mav;
	}

}


package com.dt.N.TI;

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
public class TI_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(TI_Controller.class);
	private static boolean token=false; 	
	@Autowired
	private TeamMemberListSv teamMemberListSv;
	
	@Autowired
	private BoardPanSv boardPanSv;
	
	@Autowired
	private MemoHamSv memoHamSv;
	private ModelAndView mav;
	
	@RequestMapping(value = "/teamCreditform", method = RequestMethod.GET)
	public ModelAndView teamCreditform(@ModelAttribute Member member) {		
		if(token == true){
			token = false;
		}mav = teamMemberListSv.excute(1, member);
		return mav;
		
	}
	
	
	@RequestMapping(value = "/teamCredit", method = RequestMethod.POST)
	public ModelAndView teamCredit(@ModelAttribute Team team) {		
		if(token == false){
			mav = teamMemberListSv.excute(1, team);
			token = true;
		}		
		return mav;
		
	}
	
	@RequestMapping(value = "/teamListPage", method = RequestMethod.GET)
	public ModelAndView teamListPage(@ModelAttribute Team team) {		
		mav = teamMemberListSv.excute(2, team);
		return mav;
	}	
	
	@RequestMapping(value = "/teamMemberListPage", method = RequestMethod.GET)
	public ModelAndView teamMemberListPage(@ModelAttribute Team team) {		
		mav = teamMemberListSv.excute(3, team);
		return mav;
	}	
	
	@RequestMapping(value = "/teamInfoPage", method = RequestMethod.GET)
	public ModelAndView teamInfoPage(@ModelAttribute Team team) {		
		mav = teamMemberListSv.excute(4, team);
		return mav;
	}	
	
	@RequestMapping(value = "/teamInfoUpdate", method = RequestMethod.POST)
	public ModelAndView teamInfoUpdate(@ModelAttribute Team team) {		
		mav = teamMemberListSv.excute(5, team);
		return mav;
	}
	//팀멤버창 추가
	@RequestMapping(value = "/teamMemberAdd", method = RequestMethod.POST)
	public ModelAndView teamMemberAdd(@ModelAttribute Team team) {		
		mav = teamMemberListSv.excute(6, team);
		return mav;
	}
	//팀명 체크
	@RequestMapping(value = "/isteamNeme", method = RequestMethod.POST)
	public ModelAndView isTeamName(@ModelAttribute Team team) {		
		mav = teamMemberListSv.excute(7, team);
		return mav;
	}
	
	//회원 검색
	@RequestMapping(value = "/searchaddmember", method = RequestMethod.POST)
	public ModelAndView searchaddmember(@ModelAttribute Team team) {		
		mav = teamMemberListSv.excute(8, team);
		return mav;
	}
	
	//팀멤버 추가
	@RequestMapping(value = "/teamAddMembers", method = RequestMethod.POST)
	public ModelAndView teamAddMembers(@ModelAttribute Team team) {		
		mav = teamMemberListSv.excute(9, team);
		return mav;
	}
	//팀멤버 삭제
	@RequestMapping(value = "/teamDropMembers", method = RequestMethod.POST)
	public ModelAndView teamDropMembers(@ModelAttribute Team team) {		
		mav = teamMemberListSv.excute(10, team);
		return mav;
	}
	
	@RequestMapping(value = "/boardPostListform", method = RequestMethod.GET)
	public ModelAndView boardListform(@ModelAttribute BoardPost boardpost) {		
		mav = boardPanSv.excute(1, boardpost);
		return mav;
	}
	
	@RequestMapping(value = "/boardInsertform", method = RequestMethod.GET)
	public ModelAndView boardInsertform(@ModelAttribute BoardPost boardpost) {		
		mav = boardPanSv.excute(2, boardpost);
		return mav;
	}	
	
	@RequestMapping(value = "/boardPanInsert", method = RequestMethod.POST)
	public ModelAndView boardInsert(@ModelAttribute BoardPost boardpost) {		
		mav = boardPanSv.excute(3, boardpost);
		return mav;
	}	

	@RequestMapping(value = "/boardLineInsert", method = RequestMethod.GET)
	public ModelAndView boardLineInsert(@ModelAttribute BoardPost boardpost) {		
		mav = boardPanSv.excute(7, boardpost);
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/boardUpdateform", method = RequestMethod.GET)
	public ModelAndView boardUpdateform(@ModelAttribute BoardPost boardpost) {		
		mav = boardPanSv.excute(4, boardpost);
		return mav;
	}
	@RequestMapping(value = "/boardpostUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(@ModelAttribute BoardPost boardpost) {		
		mav = boardPanSv.excute(5, boardpost);
		return mav;
	}
	@RequestMapping(value = "/boardpostDelete", method = RequestMethod.POST)
	public ModelAndView boardpostDelete(@ModelAttribute BoardPost boardpost) {		
		mav = boardPanSv.excute(6, boardpost);
		return mav;
	}
	
	
	
	
	///소유권 변경
	@RequestMapping(value = "/teamboardpostownerchangeView", method = RequestMethod.POST)
	public ModelAndView teamboardpostownerchangeView(@ModelAttribute BoardPost boardpost) {		
		mav = boardPanSv.excute(8, boardpost);
		return mav;
	}	
	
	@RequestMapping(value = "/teamboardpostownerchange", method = RequestMethod.POST)
	public ModelAndView teamboardpostownerchange(@ModelAttribute BoardPost boardpost) {		
		mav = boardPanSv.excute(9, boardpost);
		return mav;
	}
	
	@RequestMapping(value = "/teammemohamownerchangeView", method = RequestMethod.POST)
	public ModelAndView teammemohamownerchangeView(@ModelAttribute MemoHam memoham) {	
		System.out.println(memoham.getTmh_CODE());
		mav = memoHamSv.excute(6, memoham);
		return mav;
	}	
	
	@RequestMapping(value = "/teammemohamtownerchange", method = RequestMethod.POST)
	public ModelAndView teammemohamtownerchange(@ModelAttribute MemoHam memoham) {		
		mav = memoHamSv.excute(7, memoham);
		return mav;
	}
	
	
	
	
	
	
	@RequestMapping(value = "/TeamMemoHamList", method = RequestMethod.GET)
	public ModelAndView TeamMemoHamList(@ModelAttribute MemoHam memoham) {		
		mav = memoHamSv.excute(1, memoham);
		return mav;
	}
	@RequestMapping(value = "/MemoHamInsertform", method = RequestMethod.GET)
	public ModelAndView MemoHamInsertform(@ModelAttribute MemoHam memoham) {		
		mav = memoHamSv.excute(2, memoham);
		return mav;
	}
	@RequestMapping(value = "/MemoHamInsert", method = RequestMethod.POST)
	public ModelAndView MemoHamInsert(@ModelAttribute MemoHam memoham) {		
		mav = memoHamSv.excute(3, memoham);
		return mav;
	}						
	@RequestMapping(value = "/memohamUpdateform", method = RequestMethod.GET)
	public ModelAndView MemoHamUpdateform(@ModelAttribute MemoHam memoham) {		
		mav = memoHamSv.excute(4, memoham);
		return mav;
	}
	@RequestMapping(value = "/memohamUpdate", method = RequestMethod.POST)
	public ModelAndView MemoHamUpdate(@ModelAttribute MemoHam memoham) {		
		mav = memoHamSv.excute(5, memoham);
		return mav;
	}
	
	
}


package com.dt.F.ME;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class MemoSv {
	@Autowired
	private MemoDAO meDao;
	@Autowired
	private HttpServletRequest request;
	private ModelAndView mav;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;

	public ModelAndView excute(int type, MemoBean memobean) {
		sessionmid = (String)request.getSession().getAttribute("sessionmid");
		grade1 = (String)request.getSession().getAttribute("grade1");
		sessionteam= (String)request.getSession().getAttribute("sessionteam");
		grade2= (String)request.getSession().getAttribute("grade2");
		sessionnickname = (String)request.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");
		if(sessionteam==null)
			return new ModelAndView("/main/main");		
		mav = new ModelAndView();
		switch (type) {
		
		case 1:
			memoform(memobean);
			break;
		case 2:
			memoHamChoice(memobean);
			break;
		case 3:
			memoInesrt(memobean);
			break;
		case 4:
			memoUpdate(memobean);
			break;
		case 5:
			memoDelete(memobean);
			break;
		case 6:
			memoUpdateForm(memobean);
			break;
		default:

		}

		return mav;
	}

	private void memoform(MemoBean memobean) {		
		memobean.setTmh_TCODE(sessionteam);
		if (sessionteam.indexOf("@") != -1) {// 개인
			List<MemoBean> memolist = meDao.getMemoList(memobean);
			mav.addObject("MemoList", makeMemoListHtml(memolist));
			mav.setViewName("my/myMemo");
		} else {// 팀
			List<MemoBean> memolist = meDao.getTeamMemoList(memobean);
			mav.addObject("MemoList", makeMemoListHtml(memolist));
			mav.setViewName("team/Memo");
		}
	}

	private void memoHamChoice(MemoBean memobean) {		
		// sessionteam="T20150122151932";
		String code = memobean.getTmh_CODE();
		int cnt = code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		memobean.setTmh_CODE(code);
		memobean.setTmm_MEMAIL(sessionmid);
		if (sessionteam.indexOf("@") != -1) {// 개인
			List<MemoBean> memolist = meDao.getMemoHamList(memobean);			
			mav.addObject("memoInsert", makeMemoInsertHtml(memolist,memobean.getTmh_CODE()));
			mav.setViewName("my/myMemoInsert");
		} else {// 팀
			List<MemoBean> memolist = meDao.getTeamMemoHamList(memobean);
			
			mav.addObject("memoInsert", makeMemoInsertHtml(memolist,memobean.getTmh_CODE()));
			mav.setViewName("team/teamMemoInsert");
		}
		/* 메모함내에 존재하는 메모 */

	}
	private void memoSel(MemoBean memobean){
		// sessionteam="T20150122151932";		
		String code = memobean.getTmh_CODE();
		int cnt =  code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		memobean.setTmm_CODE(code);
		if (sessionteam.indexOf("@") != -1) {// 개인
			List<MemoBean> memolist = meDao.getMemoHamList(memobean);
			mav.addObject("memolist", makeMemoInsertHtml(memolist,memobean.getTmh_CODE()));
		} else {// 팀
			List<MemoBean> memolist = meDao.getTeamMemoHamList(memobean);					
			mav.addObject("memolist", makeMemoInsertHtml(memolist,memobean.getTmh_CODE()));
		}
		mav.setViewName("/my/myboComment");
	}
	private void memoInesrt(MemoBean memobean) {		
		// sessionteam="T20150122151932";
		//sessionteam = sessionmid;
		String code = memobean.getTmh_CODE();
		int cnt =  code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		memobean.setTmm_CODE(code);
		memobean.setTmm_MEMAIL(sessionmid);
		if (sessionteam.indexOf("@") != -1) {// 개인
			if(meDao.memoInsert(memobean)){
				memoSel(memobean);
			}			
		} else {// 팀
			System.out.println("1");
			if(meDao.memoTeamInsert(memobean)){
				System.out.println("2");
				memoSel(memobean);
			}		
			System.out.println("3");
		}	
	}
	
	
	private void memoUpdateForm(MemoBean memobean) {
		
		memobean.setTmm_MEMAIL(sessionmid);
		String code = memobean.getTmm_CODE();
		int cnt =  code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		memobean.setTmm_CODE(code);
		System.out.println(code);
		if (sessionteam.indexOf("@") != -1) {// 개인
			mav.addObject("memoupdate", MemoUpdate_HTML(meDao.getMemo(memobean)));		
		} else {// 팀
			mav.addObject("memoupdate", MemoUpdate_HTML(meDao.getTeamMemo(memobean)));		
		}
		mav.setViewName("my/myboCommentUpdate");
	}
	private String MemoUpdate_HTML(MemoBean memobean) {
		StringBuffer sb = new StringBuffer();			
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td><textarea rows='8' cols='20' id='newmemo'>"+memobean.getTmm_CONTENT()+"</textarea>");
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("<a href='#' onclick=\"memoupdate('"+memobean.getTmm_CODE()+"')\">수정</a>");		
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</table>");
		return sb.toString();
	}
	private void memoUpdate(MemoBean memobean) {		
		memobean.setTmm_MEMAIL(sessionmid);
		String code = memobean.getTmm_CODE();
		int cnt =  code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		memobean.setTmm_CODE(code);
		if (sessionteam.indexOf("@") != -1) {// 개인
			if(meDao.memoUpdate(memobean)){
				memoSel(memobean);
			}
		} else {// 팀
			if(meDao.memoTeamUpdate(memobean)){
				memoSel(memobean);
			}		
		}
	}

	private void memoDelete(MemoBean memobean) {
		System.out.println("sss");
		memobean.setTmm_MEMAIL(sessionmid);
		String code = memobean.getTmm_CODE();
		int cnt =  code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		memobean.setTmm_CODE(code);
		if (sessionteam.indexOf("@") != -1) {// 개인
			if(meDao.memoDelete(memobean)){
				memoSel(memobean);
			}
		} else {// 팀
			if(meDao.memoTeamDelete(memobean)){
				memoSel(memobean);
			}		
		}
	 
	}
	

	private String makeMemoListHtml(List<MemoBean> memobeanlist) {	
		StringBuffer buf = new StringBuffer();
		buf.append("<div class='table-responsive'>");
		buf.append("<table class='table'>");
		for (MemoBean memobean : memobeanlist) {
			
			
			buf.append("<tr>");
			buf.append("<td>" + "<a href='memoHamChoice?tmh_CODE="
					+ memobean.getTmh_CODE() + "'>" + memobean.getTmh_TITLE()
					+ "</a>" + "</td>");
			buf.append("<td>"+ memobean.getTmm_CONTENT() + "</td>");
			buf.append("<td>" + memobean.getTmh_MEMAIL() + "</td>");
			buf.append("<td>" + memobean.getTmm_SINCE() + "</td>");
			buf.append("</tr>");
			
			
		}
		buf.append("</table>");
		buf.append("</div>");
		return buf.toString();

	}
	
	private String makeMemoInsertHtml(List<MemoBean> memobeanlist, String tmh_CODE) {		
		StringBuffer buf = new StringBuffer();		
		buf.append("<input type='hidden' id='tmh_CODE' value='"+tmh_CODE+"'>");
		int i=1;
		System.out.println("test");
		if(memobeanlist.size()!=0){
			if(memobeanlist.get(0).getTmm_MEMAIL()!=null){
				for (MemoBean memobean : memobeanlist) {					
					buf.append("<div class='table-responsive'>");
					buf.append("<table class='table'>");
					buf.append("<tr>");
					buf.append("<td>" + memobean.getTmm_CONTENT() + memobean.getTmm_MEMAIL() + memobean.getTmm_SINCE() ); 
					if(memobean.getTmm_MEMAIL().equals(sessionmid)){
						buf.append("<input type='button' value='수정' onclick=\"memoupdateform('"+memobean.getTmm_CODE()+"')\"><input type='button' value='삭제' onclick=\"memoDelete('"+memobean.getTmm_CODE()+"')\">");
					}
					buf.append("</td>");
					buf.append("</tr>");
					buf.append("</table>");
					buf.append("</div>");	
					i++;
				}
			}
		}
		return buf.toString();
	}
	
}

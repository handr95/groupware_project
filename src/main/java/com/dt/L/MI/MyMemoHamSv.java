package com.dt.L.MI;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


@Service
public class MyMemoHamSv {

	private ModelAndView mav;
	@Autowired
	private MyPageDao mypageDao;
	@Autowired
	private HttpServletRequest session;	
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;

	
	public ModelAndView excute(int type, MyMemoHam memoham) {
		sessionmid = (String)session.getSession().getAttribute("sessionmid");
		grade1 = (String)session.getSession().getAttribute("grade1");
		sessionteam= (String)session.getSession().getAttribute("sessionteam");
		grade2= (String)session.getSession().getAttribute("grade2");
		sessionnickname = (String)session.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");
		mav = new ModelAndView();
		switch (type) {
		
		case 1:
			MyMemoHamList(memoham);
			break;
		case 2:
			MyMemoHamInsertform(memoham);
			break;
		case 3:
			MyMemoHamInsert(memoham);
			break;
		case 4:
			MyMemoHamUpdateform(memoham);
			break;
		case 5:
		    MyMemoHamUpdate(memoham);
			break;
		default:
			break;
		}

		return mav;
	}

	


	private void MyMemoHamList(MyMemoHam memoham) {
		//mav = new ModelAndView();
		mav.setViewName("service/myMemoHamManage");		
		memoham.setBp_Email(sessionmid);
		List<MyMemoHam> memoHamList = mypageDao.myMemoHamList(memoham);
		mav.addObject("mymemohamlist", MyMemoHamList_HTML(memoHamList));
	}

	private String MyMemoHamList_HTML(List<MyMemoHam> memoHamList) {
		StringBuffer sb = new StringBuffer();
		sb.append("<div class='table-responsive'> ");
		sb.append("<table class='table'><tr><td>선택</td><td>제목</td><td>관리자</td><td>공유유무</td><td>생성일</td></tr>");
		for (MyMemoHam memoham : memoHamList) {
			sb.append("<tr><td><input type='radio' value='"+memoham.getTmh_CODE() + "'></td>");
			sb.append("<td><a href='/MymemohamUpdateform?tmh_CODE="+memoham.getTmh_CODE()+"'>" + memoham.getTmh_TITLE() + "</a></td>");
			sb.append("<td>" + memoham.getBp_Email() + "</td>");
			sb.append("<td>" + MyMemoHamShare_HTML(memoham) + " </td>");
			sb.append("<td>" + memoham.getTmh_SINCE() + "</td>");
			sb.append("</tr>");
		}
		sb.append("</table></div>");
		sb.append("<input type='button' value='소유권 변경'/>");
		sb.append("<input type='button' value='삭제'/>");
		sb.append("<a href='/MyMemoHamInsertForm'><input type='button' value='추가'/></a>");
		return sb.toString();
	}

	private String MyMemoHamShare_HTML(MyMemoHam memoham) {
		StringBuffer sb = new StringBuffer();
		List<MyMemoHam> memoHamList = mypageDao.myMemohamShare(memoham);
		
		
		for (MyMemoHam memohamShare : memoHamList) {
			sb.append(memohamShare.getTmh_Cltype());
		}

		return sb.toString();
	}
	

	private void MyMemoHamInsertform(MyMemoHam memoham){
		mav.setViewName("service/myMemoHamInsert");
		mav.addObject("mymemohamInsertForm", MyMemoHamInsertform_HTML());

	}
	
	
	private String MyMemoHamInsertform_HTML(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("<form action='/MyMemoHamInsert' method='post'>");
		sb.append("메모함 제목 : <input type='text' name='tmh_TITLE'></br>");
		sb.append("메모함 내용 : <input type='text' name='tmh_CONTENT'></br>");
		sb.append("공유 설정 : <input type='radio' name = 'tmh_Cltype' value='SP' checked> 공개");
		sb.append("<input type='radio' name = 'tmh_Cltype' value='NP'> 비공개");
		sb.append("<input type='radio' name = 'tmh_Cltype' value='FP'> 이웃공개</br>");
		sb.append("<input type='submit' value='메모함 등록'>");
		sb.append("</form>");
		
		return sb.toString();
	}

	
	private void MyMemoHamInsert(MyMemoHam memoham){
		//mav = new ModelAndView();
		memoham.setBp_Email(sessionmid);
		mypageDao.myMemoHamInsert(memoham);
		MyMemoHamList(memoham);
	}
	

	private void MyMemoHamUpdateform(MyMemoHam memoham){
		//mav = new ModelAndView();
		mav.setViewName("service/myPostBoardUpdate");
		List<MyMemoHam> memohamList = mypageDao.myMemoHamListDetail(memoham);
		mav.addObject("myboardpostUpdateForm", MyMemoHamUpdateform_HTML(memohamList));

	}
	
	private String MyMemoHamUpdateform_HTML(List<MyMemoHam> memoham){
		StringBuffer sb = new StringBuffer();
		sb.append("<form action='/MymemohamUpdate?tmh_CODE="+memoham.get(0).getTmh_CODE()+"' method='post'>");
		sb.append("게시판 제목 : <input type='text' name='tmh_TITLE' value='"+memoham.get(0).getTmh_TITLE()+"'></br>");
		sb.append("게시판 내용 : <input type='text' name='tmh_CONTENT' value='"+memoham.get(0).getTmh_CONTENT()+"'></br>");
		sb.append("공유 설정 : <input type='radio' name = 'tmh_Cltype' value='SP' checked> 공개");
		sb.append("<input type='radio' name = 'tmh_Cltype' value='NP'> 비공개");
		sb.append("<input type='radio' name = 'tmh_Cltype' value='FP'> 이웃공개");
		sb.append("<input type='submit' value='게시판 수정'></form>");
		
		return sb.toString();
	}
	
	private void MyMemoHamUpdate(MyMemoHam memoham){
		//mav = new ModelAndView();
		memoham.setBp_Email(sessionmid);
		mypageDao.myMemoHamUpdate(memoham);
		MyMemoHamList(memoham);
	}

}

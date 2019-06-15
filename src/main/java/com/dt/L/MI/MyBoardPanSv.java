package com.dt.L.MI;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


@Service
public class MyBoardPanSv {
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

	public ModelAndView excute(int type, BoardPost boardpost) {
		sessionmid = (String) session.getSession().getAttribute("sessionmid");
		grade1 = (String) session.getSession().getAttribute("grade1");
		sessionteam = (String) session.getSession().getAttribute("sessionteam");
		grade2 = (String) session.getSession().getAttribute("grade2");
		sessionnickname = (String) session.getSession().getAttribute(
				"sessionnickname");
		if (sessionmid == null)
			return new ModelAndView("/main/main");
		mav = new ModelAndView();
		switch (type) {
		case 1:
			MyBoardPostList(boardpost);
			break;
		case 2:
			MyBoardPostInsertform();
			break;
		case 3:
			MyBoardPostInsert(boardpost);
			break;
		case 4:
			MyBoardPostUpdateform(boardpost);
			break;
		case 5:
			MyBoardPostUpdate(boardpost);
			break;
		default:
			break;
		}
		return mav;
	}

	private void MyBoardPostList(BoardPost boardpost) {
		// mav = new ModelAndView();
		mav.setViewName("service/myPostBoardManage");
		List<BoardPost> boardpostList = mypageDao.myBoardPostList(boardpost);
		mav.addObject("myPostBoardManage", MyBoardPostList_HTML(boardpostList));
	}

	private String MyBoardPostList_HTML(List<BoardPost> boardpostList) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("<table class='table'><tr><td>선택</td><td>제목</td><td>관리자</td><td>생성일</td><td>공개 유무</td></tr>");
		for (BoardPost boardpost : boardpostList) {
			sb.append("<tr><td><input type='radio' name ='bp_Code' value="
					+ boardpost.getBp_Code() + "></td>");
			sb.append("<td><a href='/myPostUpdateform?bp_Code="
					+ boardpost.getBp_Code() + "'>" + boardpost.getBp_Title()
					+ "</a></td>");
			sb.append("<td>" + boardpost.getBp_Email() + "</td>");
			sb.append("<td>" + boardpost.getBp_Since() + "</td>");
			sb.append("<td>" + boardpost.getBp_Cltype() + "</td>");
			sb.append("</tr>");
		}
		sb.append("</table></div>");
		sb.append("<input type='button' value='소유권 변경' class='sgwline3'  style='right:155px'/>");
		sb.append("<input type='button' value='삭제' class='sgwline3'  style='right:110px' onclick='boardPostDelte()'/>");
		sb.append("<a href='/myPostInsertForm'><input type='button' value='추가'  class='sgwline3'  style='right:243px'/></a>");
		return sb.toString();
	}

	private void MyBoardPostInsertform() {
		// mav = new ModelAndView();
		mav.setViewName("service/myPostBoardInsert");
		mav.addObject("myboardpostInsertForm", MyBoardPostInsertform_HTML());

	}

	private String MyBoardPostInsertform_HTML() {
		StringBuffer sb = new StringBuffer();

		sb.append("<form action='/myPostInsert' method='post' onsubmit='return noticecheck(this)'>");
		sb.append("<table  style='margin:auto; width:800px;'>");
		sb.append("<tr>");
		sb.append("<td  colspan='2'>게시판 제목 : <input type='text' name='bp_Title'/></td></br>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>게시판 설명 :</td><td></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td colspan='2'><textarea rows='8' cols='100' name='pb_Content'/></textarea></td></br>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td  colspan='2'>공유 설정 : <input type='radio' name='bp_Share' value='SP'/>공개");
		sb.append("<input type='radio' name='bp_Share' value='NP'/>비공개");
		sb.append("<input type='radio' name='bp_Share' value='FP'/>이웃공개</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td></td><td><input type='submit' value='게시판 등록'  class='sgwline3' style='right:345px;'/><td>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("</form>");
		/*
		 * 
		 * sb.append("<form action='/myPostInsert' method='post'>");
		 * sb.append("게시판 제목 : <input type='text' name='bp_Title'></br>");
		 * sb.append("게시판 내용 : <input type='text' name='bp_Content'></br>");
		 * sb.append
		 * ("공유 설정 : <input type='radio' name = 'bp_Share' value='SP' checked> 공개"
		 * );
		 * sb.append("<input type='radio' name = 'bp_Share' value='NP'> 비공개");
		 * sb.append("<input type='radio' name = 'bp_Share' value='FP'> 이웃공개");
		 * sb.append("<input type='submit' value='게시판 등록'></form>");
		 */
		return sb.toString();
	}

	private void MyBoardPostInsert(BoardPost boardpost) {
		// mav = new ModelAndView();
		boardpost.setBp_Email("ljs@naver.com");
		mypageDao.myBoardPostInsert(boardpost);
		MyBoardPostList(boardpost);
	}

	private void MyBoardPostUpdateform(BoardPost boardpost) {
		// mav = new ModelAndView();
		mav.setViewName("service/myPostBoardUpdate");
		List<BoardPost> boardpostList = mypageDao
				.myBoardPostListDetail(boardpost);
		mav.addObject("myboardpostUpdateForm",
				MyBoardPostUpdateform_HTML(boardpostList));

	}

	private String MyBoardPostUpdateform_HTML(List<BoardPost> boardpostUpdate) {
		StringBuffer sb = new StringBuffer();

		for (BoardPost boardPost : boardpostUpdate) {

			sb.append("<form action='/myPostUpdate?bp_Code="
					+ boardPost.getBp_Code() + "' method='post'>");
			sb.append("<table  style='margin:auto; width:800px; margin-top: 20px'>");
			sb.append("<tr>");
			sb.append("<td  colspan='2'>게시판 제목 : <input type='text' name='bp_Title' value='"
					+ boardPost.getBp_Title() + "'/></td></br>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td>게시판 설명 : </td><td></td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td colspan='2'><textarea rows='8' cols='100' name='nt_content'/>"
					+ boardPost.getBp_Content() + "</textarea></td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td  colspan='2'>공유 설정 : <input type='radio' name = 'bp_Share' value='SP' checked> 공개");
			sb.append("<input type='radio' name = 'bp_Share' value='NP'> 비공개");
			sb.append("<input type='radio' name = 'bp_Share' value='FP'> 이웃공개</td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<input type='hidden' name='nt_Code' value='"
					+ boardPost.getBp_Code() + "'/>");

		}
		sb.append("<td></td><td><input type='submit' value='게시판 수정'  class='sgwline3' style='right:350px'/><td>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("</form>");

		return sb.toString();
	}

	private void MyBoardPostUpdate(BoardPost boardpost) {
		// mav = new ModelAndView();
		boardpost.setBp_Email("ljs@n/aver.com");
		//mypageDao.myBoardPostUpdate(boardpost);
		//MyBoardPostList(boardpost);
	}

}

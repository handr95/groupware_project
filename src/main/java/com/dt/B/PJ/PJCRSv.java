package com.dt.B.PJ;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class PJCRSv {
	@Autowired
	private PJCRDao PJCRDao;
	@Autowired
	private HttpServletRequest request;
	


	private ModelAndView mav;
	private String sessionmid;
	private String sessionnickname;	
	private String grade1;
	private String sessionteam;
	private String grade2;
	
	public ModelAndView excute(int type, Comment comment){
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
			pjCommentInsert(comment);
			break;

		case 2:
			pjCommentUpdate(comment);
			break;	
			
		case 3:
			pjCommentDelete(comment);
			break;	
		case 4:
			pjCommentUpdateForm(comment);
			break;	
		case 5:
			CommentSel(comment);
			break;	
			
		default:
			
			break;
		}
		
		return mav;
	}
	/*
	public ModelAndView excute(int type, Reply reply){
		switch (type) {
		case 1:
			dataCommReplyInsert(reply);
			break;

		case 2:
			dataCommReplyUpdate(reply);
			break;	
			
		case 3:
			dataCommReplyDelete(reply);
			break;	
			
		default:
			
			break;
		}
		
		return mav;
	}
	*/
	private void pjCommentInsert(Comment comment){
		//sessionmid="ljs@naver.com";
		System.out.println(comment.getCm_Comment());
		comment.setCm_Witter(sessionmid);
		if(comment.getCm_Share()=="")
			comment.setCm_Share("SN  ");
		int cnt = comment.getM_Menu().length();
		String code = comment.getM_Menu(); 
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		comment.setM_Menu(code);
		if(PJCRDao.commentInsert(comment)){
			CommentSel(comment);
		}		
	}//댓글 등록
	private void pjCommentUpdate(Comment comment){
		//sessionmid="ljs@naver.com";
		System.out.println(comment.getCm_Comment());
		comment.setCm_Witter(sessionmid);		
		if(comment.getCm_Share()=="")
			comment.setCm_Share("SN  ");
		System.out.println(comment.getCm_Share());
		int cnt = comment.getCm_Code().length();
		String code = comment.getCm_Code(); 
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		comment.setCm_Code(code);
		System.out.println("업데이트인데 여기로 와라");
		if(PJCRDao.commentUpdate(comment)){
			CommentSel(comment);
		}
		
	}//댓글 수정
	private void pjCommentDelete(Comment comment){
		//sessionmid="ljs@naver.com";
		comment.setCm_Witter(sessionmid);		
		int cnt = comment.getCm_Code().length();
		String code = comment.getCm_Code(); 
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		comment.setCm_Code(code);
		if(PJCRDao.commentDelete(comment)){
			CommentSel(comment);
		}
	}//댓글 삭제
	/*
	private void dataCommReplyInsert(Reply reply){
		PJCRDao.replyInsert(reply);
	}//답글 등록
	private void dataCommReplyUpdate(Reply reply){
		PJCRDao.replyUpdate(reply);
	}//답글 수정
	private void dataCommReplyDelete(Reply reply){
		PJCRDao.replyDelete(reply);
	}//답글 삭제
	*/
	private void CommentSel(Comment comment){
		//sessionmid="ljs@naver.com";	
		mav.addObject("pjcoment", pjComment_HTML(PJCRDao.commentSelect(comment)));		
	
		mav.setViewName("/my/myboComment");
		/* 게시글에 코멘트를 등록 */
		
	}
	
	private String pjComment_HTML(List<Comment> commentlist){
		StringBuffer sb = new StringBuffer();		
		int i=1;
		for(Comment comm:commentlist){
			if(comm.getCm_Witter().equals(sessionmid)){
				if(comm.getCm_Witter().equals(sessionmid))
				sb.append("<table class='table table-striped'");
				sb.append("<tr><td>코드:"+comm.getCm_Code()+"</tr></td><tr><td>작성자:"+comm.getCm_Witter()+"</tr></td><tr><td>시간:"+comm.getCm_Since()+"</tr></td><tr><td>내용:"+comm.getCm_Comment()+"</tr></td>");
				sb.append("<a href='#' onclick=\"pjcommentupdateform('"+comm.getCm_Code()+"')\">수정</a>&nbsp;");
				sb.append("<a href='#' onclick=\"pjcommentDel('"+comm.getCm_Code()+"')\">삭제</a><br>");
				
			}else{
				if(!comm.getCm_Share().equals("NN  ")){
					sb.append("코드:"+comm.getCm_Code()+"<br>작성자:"+comm.getCm_Witter()+"<br>시간:"+comm.getCm_Since()+"<br>내용:"+comm.getCm_Comment()+"<br>");
				}
			}
			sb.append("</table>");
		}	
		return sb.toString();
	}	

	
	
	private void pjCommentUpdateForm(Comment comment) {		
		//sessionmid="ljs@naver.com";
		comment.setCm_Witter(sessionmid);
		int cnt = comment.getCm_Code().length();
		String code = comment.getCm_Code(); 
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		comment.setCm_Code(code);
		mav.addObject("pjcomentupdate", CommentUpdate_HTML(PJCRDao.pjComment(comment)));
		mav.setViewName("/my/myboCommentUpdate");
	}

	private String CommentUpdate_HTML(Comment Comment) {
		System.out.println("코멘트코드:"+Comment.getCm_Code());
		StringBuffer sb = new StringBuffer();		
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td><textarea rows='8' cols='20' id='cm_Comment'>"+Comment.getCm_Comment()+"</textarea>");
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>");
		if(Comment.getCm_Share().equals("NN  ")){	
			sb.append("<input type='checkbox' value='NN  ' name='cm_Share' id='cm_Share2' checked='checked'>비공개");
			sb.append("<a href='#' onclick=\"pjcommentupdate('"+Comment.getCm_Code()+"')\">수정</a>");
		}else{
			sb.append("<input type='checkbox' value='NN  ' name='cm_Share' id='cm_Share2'>비공개");
			sb.append("<a href='#' onclick=\"pjcommentupdate('"+Comment.getCm_Code()+"')\">수정</a>");
		}			
		
		sb.append("</tr></td>");
		sb.append("</table>");
		return sb.toString();
	}	

}


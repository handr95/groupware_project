package com.dt.C.WK;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;



@Service
public class WKCRSv {
	
	@Autowired
	private WKCRDao WKCRDao;
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
			bwCommentInsert(comment);
			break;

		case 2:
			bwCommentUpdate(comment);
			break;	
			
		case 3:
			bwCommentDelete(comment);
			break;	
		case 4:
			bwCommentUpdateForm(comment);
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
	private void bwCommentInsert(Comment comment){
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
		if(WKCRDao.commentInsert(comment)){
			CommentSel(comment);
		}		
	}//댓글 등록
	private void bwCommentUpdate(Comment comment){
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
		if(WKCRDao.commentUpdate(comment)){
			CommentSel(comment);
		}
		
	}//댓글 수정
	private void bwCommentDelete(Comment comment){
		//sessionmid="ljs@naver.com";
		comment.setCm_Witter(sessionmid);		
		int cnt = comment.getCm_Code().length();
		String code = comment.getCm_Code(); 
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		comment.setCm_Code(code);
		if(WKCRDao.commentDelete(comment)){
			CommentSel(comment);
		}
	}//댓글 삭제
	
	private void CommentSel(Comment comment){
		//sessionmid="ljs@naver.com";	
		mav.addObject("bwcoment", bwComment_HTML(WKCRDao.commentSelect(comment)));		
	
		mav.setViewName("/my/myboComment");
		/* 게시글에 코멘트를 등록 */
		
	}
	
	private String bwComment_HTML(List<Comment> commentlist){
		StringBuffer sb = new StringBuffer();		
		int i=1;
		for(Comment comm:commentlist){
			if(comm.getCm_Witter().equals(sessionmid)){
				if(comm.getCm_Witter().equals(sessionmid))
				sb.append("코드:"+comm.getCm_Code()+"<br>작성자:"+comm.getCm_Witter()+"<br>시간:"+comm.getCm_Since()+"<br>내용:"+comm.getCm_Comment()+"<br>");
				sb.append("<a href='#' onclick=\"bwcommentupdateform('"+comm.getCm_Code()+"')\">수정</a>&nbsp;");
				sb.append("<a href='#' onclick=\"bwcommentDel('"+comm.getCm_Code()+"')\">삭제</a><br>");
			}else{
				if(!comm.getCm_Share().equals("NN  ")){
					sb.append("코드:"+comm.getCm_Code()+"<br>작성자:"+comm.getCm_Witter()+"<br>시간:"+comm.getCm_Since()+"<br>내용:"+comm.getCm_Comment()+"<br>");
				}
			}
			
		}	
		return sb.toString();
	}	

	
	
	private void bwCommentUpdateForm(Comment comment) {		
		//sessionmid="ljs@naver.com";
		comment.setCm_Witter(sessionmid);
		int cnt = comment.getCm_Code().length();
		String code = comment.getCm_Code(); 
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		comment.setCm_Code(code);
		mav.addObject("bwcomentupdate", CommentUpdate_HTML(WKCRDao.bwComment(comment)));
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
			sb.append("<a href='#' onclick=\"bwcommentupdate('"+Comment.getCm_Code()+"')\">수정</a>");
		}else{
			sb.append("<input type='checkbox' value='NN  ' name='cm_Share' id='cm_Share2'>비공개");
			sb.append("<a href='#' onclick=\"bwcommentupdate('"+Comment.getCm_Code()+"')\">수정</a>");
		}			
		
		sb.append("</td>");
		sb.append("</table>");
		return sb.toString();
	}	
}

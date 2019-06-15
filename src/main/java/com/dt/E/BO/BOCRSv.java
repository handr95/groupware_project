package com.dt.E.BO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


@Service
public class BOCRSv {
	@Autowired
	private BoardDao bDao;
	@Autowired
	private HttpServletRequest request;
	private ModelAndView mav;
	private String sessionmid;
	private String sessionnickname;	
	private String grade1;
	private String sessionteam;
	private String grade2;
	

	public ModelAndView excute(int type, Comment comment) {
		sessionmid = (String)request.getSession().getAttribute("sessionmid");
		grade1 = (String)request.getSession().getAttribute("grade1");
		sessionteam= (String)request.getSession().getAttribute("sessionteam");
		grade2= (String)request.getSession().getAttribute("grade2");
		sessionnickname = (String)request.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");
		if(sessionteam==null)
			return new ModelAndView("/main/main");
		mav=new ModelAndView();
		switch (type) {
		case 1:
			CommentInsert(comment);
			break;
		case 2:
			CommentUpdate(comment);
			break;
		case 3:
			CommentDelete(comment);
			break;
		case 4:
			CommentSel(comment);
			break;
		case 5:
			boCommentUpdateForm(comment);
			break;	
			
		default:

		}

		return mav;
	}
	


	private void CommentSel(Comment comment){
		
		if(sessionteam.indexOf("@")==-1){//팀
			System.out.println();
			mav.addObject("boardcoment", teamComment_HTML(bDao.TeamCommentList(comment)));
		}else{//개인
			mav.addObject("boardcoment", myComment_HTML(bDao.MyCommentList(comment)));		
		}		
		mav.setViewName("/my/myboComment");
		/* 게시글에 코멘트를 등록 */
		
	}
	
	private String myComment_HTML(List<Comment> commentlist){
		StringBuffer sb = new StringBuffer();
		//sessionmid="ljs@naver.com";		
		//int i=1;
		for(Comment comm:commentlist){
			if(comm.getCm_Witter().equals(sessionmid)){
				if(comm.getCm_Witter().equals(sessionmid))
				sb.append("코드:"+comm.getCm_Code()+"<br>작성자:"+comm.getCm_Witter()+"<br>시간:"+comm.getCm_Since()+"<br>내용:"+comm.getCm_Comment()+"<br>");
				sb.append("<a href='#' onclick=\"bocommentupdateform('"+comm.getCm_Code()+"')\">수정</a>&nbsp;");
				sb.append("<a href='#' onclick=\"bocommentDel('"+comm.getCm_Code()+"')\">삭제</a><br>");
			}else{
				if(!comm.getCm_Share().equals("NN  ")){
					sb.append("코드:"+comm.getCm_Code()+"<br>작성자:"+comm.getCm_Witter()+"<br>시간:"+comm.getCm_Since()+"<br>내용:"+comm.getCm_Comment()+"<br>");
				}
			}
		}	
		return sb.toString();
	}
	
	private String teamComment_HTML(List<Comment> commentlist){
		StringBuffer sb = new StringBuffer();
		//sessionmid="ljs@naver.com";		
		//int i=1;
		for(Comment comm:commentlist){
			// && 
			if(comm.getCm_Witter().equals(sessionmid)){
				if(comm.getCm_Witter().equals(sessionmid))
				sb.append("코드:"+comm.getCm_Code()+"<br>작성자:"+comm.getCm_Witter()+"<br>시간:"+comm.getCm_Since()+"<br>내용:"+comm.getCm_Comment()+"<br>");
				sb.append("<a href='#' onclick=\"bocommentupdateform('"+comm.getCm_Code()+"')\">수정</a>&nbsp;");
				sb.append("<a href='#' onclick=\"bocommentDel('"+comm.getCm_Code()+"')\">삭제</a><br>");
			}else{
				if(!comm.getCm_Share().equals("NN  ")){
					sb.append("코드:"+comm.getCm_Code()+"<br>작성자:"+comm.getCm_Witter()+"<br>시간:"+comm.getCm_Since()+"<br>내용:"+comm.getCm_Comment()+"<br>");
				}
			}	
		}	
		return sb.toString();
	}
	
	
	private void CommentInsert(Comment comment){
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
		//int a = 1;
		if(sessionteam.indexOf("@")==-1){//팀
			if(bDao.teamCommentInsert(comment)){
				CommentSel(comment);
			}
		}else{//개인
			if(bDao.myCommentInsert(comment)){
				CommentSel(comment);
			}
		}
	}

	private void CommentUpdate(Comment comment){
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
		//int a = 1;
		if(sessionteam.indexOf("@")==-1){//팀
			if(bDao.teamCommentUpdate(comment)){
				CommentSel(comment);
			}
		}else{//개인
			if(bDao.myCommentUpdate(comment)){
				CommentSel(comment);
			}
		}
		
	}
	
	private void boCommentUpdateForm(Comment comment) {		
		//sessionmid="ljs@naver.com";
		comment.setCm_Witter(sessionmid);
		int cnt = comment.getCm_Code().length();
		String code = comment.getCm_Code(); 
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		comment.setCm_Code(code);
		//int a = 1;
		if(sessionteam.indexOf("@")==-1){//팀
			System.out.println();
			mav.addObject("memoupdate", CommentUpdate_HTML(bDao.TeamComment(comment)));
		}else{//개인
			mav.addObject("memoupdate", CommentUpdate_HTML(bDao.MyComment(comment)));		
		}	
		mav.setViewName("/my/myboCommentUpdate");
	}

	private String CommentUpdate_HTML(Comment Comment) {
		StringBuffer sb = new StringBuffer();
		sessionmid="ljs@naver.com";		
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td><textarea rows='8' cols='20' id='cm_Comment'>"+Comment.getCm_Comment()+"</textarea>");
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>");
		if(Comment.getCm_Share().equals("NN  ")){	
			sb.append("<input type='checkbox' value='NN  ' name='cm_Share' id='cm_Share2' checked='checked'>비공개");
			sb.append("<a href='#' onclick=\"bocommentupdate('"+Comment.getCm_Code()+"')\">수정</a>");
		}else{
			sb.append("<input type='checkbox' value='NN  ' name='cm_Share' id='cm_Share2'>비공개");
			sb.append("<a href='#' onclick=\"bocommentupdate('"+Comment.getCm_Code()+"')\">수정</a>");
		}					
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</table>");
		return sb.toString();
	}
	

	private void CommentDelete(Comment comment){
		//sessionmid="ljs@naver.com";
		comment.setCm_Witter(sessionmid);		
		int cnt = comment.getCm_Code().length();
		String code = comment.getCm_Code(); 
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		comment.setCm_Code(code);
		//int a = 1;
		if(sessionteam.indexOf("@")==-1){//팀
			if(bDao.teamCommentDelete(comment)){
				CommentSel(comment);
			}
		}else{//개인
			if(bDao.myCommentDelete(comment)){
				CommentSel(comment);
			}
		}
		
		
	}
}

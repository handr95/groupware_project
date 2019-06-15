package com.dt.D.DC;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class DCCRSv {
	@Autowired
	private DCCRDao DCCRDao;

	@Autowired
	private HttpServletRequest request;	
	private String sessionmid;
	private String sessionnickname;	
	private String grade1;
	private String sessionteam;
	private String grade2;
	private ModelAndView mav;
	
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
		switch (type) {
		case 1:
			dataCommCommentInsert(comment);
			break;

		case 2:
			dataCommCommentUpdate(comment);
			break;	
			
		default:
			dataCommCommentDelete(comment);
			break;
		}
		
		return mav;
	}
	
	public ModelAndView excute(int type, Reply reply){
		switch (type) {
		case 1:
			dataCommReplyInsert(reply);
			break;

		case 2:
			dataCommReplyUpdate(reply);
			break;	
			
		default:
			dataCommReplyDelete(reply);
			break;
		}
		
		return mav;
	}
	
	private void dataCommCommentInsert(Comment comment){
		DCCRDao.commentInsert(comment);
	}//댓글 등록
	private void dataCommCommentUpdate(Comment comment){
		DCCRDao.commentUpdate(comment);
	}//댓글 수정
	private void dataCommCommentDelete(Comment comment){
		DCCRDao.commentDelete(comment);
	}//댓글 삭제

	private void dataCommReplyInsert(Reply reply){
		DCCRDao.replyInsert(reply);
	}//답글 등록
	private void dataCommReplyUpdate(Reply reply){
		DCCRDao.replyUpdate(reply);
	}//답글 수정
	private void dataCommReplyDelete(Reply reply){
		DCCRDao.replyDelete(reply);
	}//답글 삭제

}

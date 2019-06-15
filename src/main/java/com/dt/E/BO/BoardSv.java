package com.dt.E.BO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class BoardSv {
	
	@Autowired
	private BoardDao BDao;
	@Autowired
	private HttpServletRequest request;
	
	private ModelAndView mav;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;

	

	public ModelAndView excute(int type, Board board) {
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
		switch(type){
		case 1:
			boardList(board);
			break;
		case 2:
			boardSel(board);
			break;
		case 3:
			boardInsertForm(board);
			break;
		case 4:
			boardInsert(board);
			break;
		case 5:
			boardUpdate(board);
			break;
//		case 8:
//			boardDelete(boardbean);
//			break;
		default :	
			break;
			
	}
	
		return mav;
	}
	
	public ModelAndView excute(int type, BoardDetail detail) {
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
		switch(type){
		case 1:
			boardDetailform(detail);
			break;
		case 2:
			boardUpdateform(detail);
			break;
		default :	
			
	}
	
		return mav;
	}
	

	private void boardSel(Board board){		
		BoardPost boardPost = new BoardPost();
		if(sessionteam.indexOf("@")==-1){
			List<Board> boardList = BDao.teamboardList(board); 
			mav.addObject("teamboardlist", boardList_HTML(boardList));
			boardPost.setT_Code(sessionteam);
			List<BoardPost> boardpanList = BDao.teamboardpostList(boardPost); 
			mav.addObject("teamboardPanlist", boardPanList_HTML(boardpanList));
			mav.setViewName("team/Board");
		}else{
			List<Board> boardList = BDao.myboardList(board); 
			mav.addObject("myboardlist", boardList_HTML(boardList));
			boardPost.setBp_Email(sessionteam);
			List<BoardPost> boardpanList = BDao.myboardpostList(boardPost); 
			mav.addObject("myboardPanlist", boardPanList_HTML(boardpanList));
			mav.setViewName("my/myPostBoard");
		}
	}
	
	
	
	
	
	private void boardList(Board board){

		mav=new ModelAndView();
		BoardPost boardPost = new BoardPost();
		if(sessionteam.indexOf("@")==-1){
			//맵퍼 최대한 수정 안하기위해 이메일에 팀코드 넣음
			board.setBd_Email(sessionteam);
			boardPost.setT_Code(sessionteam);			
			List<Board> boardList = BDao.teamboardListall(board); 
			mav.addObject("teamboardlist", boardList_HTML(boardList));
			List<BoardPost> boardpanList = BDao.teamboardpostList(boardPost); 
			mav.addObject("teamboardPanlist", boardPanList_HTML(boardpanList));
			mav.setViewName("team/Board");
			//System.out.println("sss"+board.getBd_Title());

		}else{
			board.setBd_Email(sessionteam);
			boardPost.setBp_Email(sessionteam);
			List<Board> boardList = BDao.myboardListall(board); 
			mav.addObject("myboardlist", boardList_HTML(boardList));
			List<BoardPost> boardpanList = BDao.myboardpostList(boardPost); 
			mav.addObject("myboardPanlist", boardPanList_HTML(boardpanList));
			mav.setViewName("my/myPostBoard");
		}
		/* 보드페이지를 봤을때 나오는 정보를 출력 */
	}

	private String boardPanList_HTML(List<BoardPost> bdPan){
		StringBuffer sb = new StringBuffer();
		
		sb.append("<select onChange='gourl(this.options[this.selectedIndex].value)' name='bp_Code' id='bp_Code'>");
		sb.append("<option>게시판 선택</option>");
		sb.append("<option value='전체'>전체</option>");
		for (BoardPost boardPost : bdPan){
		sb.append("<option value='"+boardPost.getBp_Code()+"'>"+boardPost.getBp_Title()+"</option>");
			}
		sb.append("</select>");
		sb.append("<a href='#'>게시판 관리</a>");
		
		return sb.toString();

	}
	
	
	private String boardList_HTML(List<Board> boardlist){
		StringBuffer sb = new StringBuffer();
		sb.append("<div class='table-responsive'>");
		sb.append("<table class='table'>");
		sb.append("<tr><td>게시글명</td><td>등록일</td><td>글쓴이</td></tr>");
		for (Board board : boardlist){
			sb.append("<td><a href='/boardDetailForm?mp_Code="
			+board.getBd_Code()+"'>"
			+board.getBd_Title()+"</a></td>");
			sb.append("<td>"+board.getBd_Since()+"</td>");
			sb.append("<td>"+board.getBd_Email()+"</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
		sb.append("</div>");
		sb.append("<a href='/boardInsertForm'><input type='button' value='게시글 등록'></a>");
		return sb.toString();
	}
	
	
	
	
	
	public void boardDetailform(BoardDetail boardDetail){		
		if(sessionteam.indexOf("@")==-1){
			mav.setViewName("team/BoardDetail");	
			List<BoardDetail> boardDetailList = BDao.teamboardDetail_View(boardDetail);
			mav.addObject("boardDetail", teamboardDetail_HTML(boardDetailList));
			mav.addObject("boardcoment", teamComment_HTML(boardDetail));
		}else{
			mav.setViewName("my/myPostDetail");	
			System.out.println(boardDetail.getMp_Code());
			List<BoardDetail> boardDetailList = BDao.myboardDetail_View(boardDetail);
			mav.addObject("boardDetail", myboardDetail_HTML(boardDetailList));			
			mav.addObject("boardcoment", myComment_HTML(boardDetail));
		}
	}
	
	private String teamboardDetail_HTML(List<BoardDetail> boardDetail){
		StringBuffer sb = new StringBuffer();
		if(boardDetail.size()!=0){
		sb.append("<input type='hidden' id='m_Menu' value='"+boardDetail.get(0).getMp_Code()+"'>");
		sb.append("<a href='/boardUpdateForm?mp_Code="
			+boardDetail.get(0).getMp_Code()+"'><input type='button' value='게시글 수정'></a><br/>");		
			sb.append("게시판 제목 : "+boardDetail.get(0).getMpb_Title()+"<br/>");
			sb.append("게시글 제목 : "+boardDetail.get(0).getMp_Title()+"<br/>");
			sb.append("게시글 등록자 : "+boardDetail.get(0).getMp_Writter()+"<br/>");
			sb.append("게시글 등록일 : "+boardDetail.get(0).getMp_Since()+"<br/>");
			sb.append("게시글 내용 : "+boardDetail.get(0).getMp_Connent()+"<br/>");
		}
		return sb.toString();
	}
	

	private String myboardDetail_HTML(List<BoardDetail> boardDetail){
		StringBuffer sb = new StringBuffer();
		if(boardDetail.size()!=0){
			sb.append("<input type='hidden' id='m_Menu' value='"+boardDetail.get(0).getMp_Code()+"'>");
			sb.append("<a href='/boardUpdateForm?mp_Code="
				+boardDetail.get(0).getMp_Code()+"'><input type='button' value='게시글 수정'></a><br/>");		
				sb.append("게시판 제목 : "+boardDetail.get(0).getMpb_Title()+"<br/>");
				sb.append("게시글 제목 : "+boardDetail.get(0).getMp_Title()+"<br/>");
				sb.append("게시글 등록자 : "+boardDetail.get(0).getMp_Writter()+"<br/>");
				sb.append("게시글 등록일 : "+boardDetail.get(0).getMp_Since()+"<br/>");
				sb.append("게시글 내용 : "+boardDetail.get(0).getMp_Connent()+"<br/>");
				sb.append("게시글 해쉬태그 :");
			for (BoardDetail board : boardDetail){
				if(board.getHd_Title()==null){
					sb.append("   ");
				}else{
					sb.append("<a href='/findHashDetailform?hs_Title="+board.getHd_Title()+"'>"+board.getHd_Title()+"</a>&nbsp");
				}
			}
		}
		return sb.toString();
	}
	
	

	
	private void boardInsertForm(Board boardbean){
		
		if(sessionteam.indexOf("@")==-1){
			mav.setViewName("team/BoardInsert");	
			mav.addObject("boardInsert", teamboardInsert_HTML());
		}else{
			mav.setViewName("my/myPostInsert");	
			mav.addObject("boardInsert2", myboardInsert_HTML());
		}
	}
	
	
	private String teamboardInsert_HTML(){
		BoardPost boardPost1 = new BoardPost();
		boardPost1.setT_Code(sessionteam);
		List<BoardPost> boardpanList = BDao.teamboardpostList(boardPost1); 
		StringBuffer sb = new StringBuffer();
		sb.append("<form action='/boardInsert' method='post'>");
		sb.append("게시판 제목 : ");
		sb.append("<select name='bp_Code' id='bp_Code'>");
		sb.append("<option>게시판 선택</option>");
		for (BoardPost boardPost : boardpanList){
			sb.append("<option value='"+boardPost.getBp_Code()+"'>"+boardPost.getBp_Title()+"</option>");
		}
		sb.append("</select></br>");
		sb.append("게시글 제목 : <input type='text' name='bd_Title'/></br>");
		sb.append("내용 : </br><textarea rows='8' cols='100' name='bd_Content'/></textarea></br>");
		sb.append("공지유무 : <input type='radio' name='bd_Share' value='SN'/> 공지"
				+ "<input type='radio' name='bd_Share' value='NN'/> 비공지 </br>");
		sb.append("<input type='submit' value='게시글 등록'/></form>");
		
		return sb.toString();
	}
	
	private String myboardInsert_HTML(){
		//System.out.println("여기");
		BoardPost boardPost1 = new BoardPost();
		boardPost1.setBp_Email(sessionteam);
		List<BoardPost> boardpanList = BDao.myboardpostList(boardPost1); 
		StringBuffer sb = new StringBuffer();
		Hash hash = new Hash();
		sb.append("<form action='/boardInsert' method='post'>");
		sb.append("게시판 제목 : ");
		sb.append("<select name='bp_Code' id='bp_Code'>");
		sb.append("<option>게시판 선택</option>");
		for (BoardPost boardPost : boardpanList){
			sb.append("<option value='"+boardPost.getBp_Code()+"'>"+boardPost.getBp_Title()+"</option>");
		}
		sb.append("</select></br>");
		sb.append("게시글 제목 : <input type='text' name='bd_Title'/></br>");
		sb.append("내용 : </br> <textarea rows='8' cols='100' name='bd_Content'></textarea></br>");
		sb.append("해쉬태그 : <input type='text' name='ms_Content'/>");
		sb.append("<input type='text' name='ms_Content'/>");
		sb.append("<input type='text' name='ms_Content'/>");
		sb.append("</br>공유 설정 : <input type='radio' name = 'bd_Share' value='SP' checked> 공개");
		sb.append("<input type='radio' name = 'bd_Share' value='NP'> 비공개");
		sb.append("<input type='radio' name = 'bd_Share' value='FP'> 이웃공개");
		sb.append("</br><input type='submit' value='게시글 등록'/></form>");
		
		return sb.toString();
	}
	

	private void boardInsert(Board board){
		
		board.setBd_Email(sessionmid);
		if(sessionteam.indexOf("@")==-1){
			BDao.teamboardInsert(board);
			boardList(board);
		}else{
			//System.out.println("개인 서비스");
			
			if(BDao.myboardInsert(board)){
				//System.out.println(boardpost.getBp_Email());
				String[] getContent= board.getMs_Content();	
				
				//System.out.println(boardpost.getBp_Code());
				board.setBd_Code(BDao.myboardCode(board));
				
				for(int i=0;i<getContent.length;i++){
					//System.out.println(boardpost.getBp_Code());
					board.setMs_Content2(getContent[i]);
					if(!getContent[i].equals("")){
						System.out.println(getContent[i]);
						BDao.hashInsert(board);
							 
					}
				}
					
			}
			boardList(board);
		}
		
	}
	private void boardUpdateform(BoardDetail boardDetail){		
		
		if(sessionteam.indexOf("@")==-1){
			mav.setViewName("team/BoardDetail");	
			List<BoardDetail> boardDetailList = BDao.teamboardDetail_View(boardDetail);
			mav.addObject("boardDetail", teamboardUpdate_HTML(boardDetailList));
		}else{
			mav.setViewName("my/myPostDetail");	
			System.out.println(boardDetail.getMp_Code());
			List<BoardDetail> boardDetailList = BDao.myboardDetail_View(boardDetail);
			mav.addObject("boardDetail", myboardUpdate_HTML(boardDetailList));
		}
		
	}
	
	private String teamboardUpdate_HTML(List<BoardDetail> boardDetailList){
		StringBuffer sb = new StringBuffer();
		
		BoardPost boardPost1 = new BoardPost();
		boardPost1.setT_Code(sessionteam);
		List<BoardPost> boardpanList = BDao.teamboardpostList(boardPost1); 
		
		sb.append("<form action='/boardUpdate?bd_Code="+boardDetailList.get(0).getMp_Code()+"' method='post'>");

		sb.append("게시판 제목 : ");
		sb.append("<select name='bp_Code' id='bp_Code'>");
		sb.append("<option>게시판 선택</option>");
		for (BoardPost boardPost : boardpanList){
			sb.append("<option value='"+boardPost.getBp_Code()+"'>"+boardPost.getBp_Title()+"</option>");
		}
		sb.append("</select></br>");
		
		sb.append("게시글 제목 : <input type='text' name = 'bd_Title' value='"+boardDetailList.get(0).getMp_Title()+"'/></br>");
		sb.append("내용 : <textarea rows='8' cols='100' name='bd_Content' value='"+boardDetailList.get(0).getMp_Connent()+"'>"+boardDetailList.get(0).getMp_Connent()+"</textarea></br>");
		sb.append("공지유무 : <input type='radio' name='bd_Share' value='SN  '/> 공지"
				+ "<input type='radio' name='bd_Share' value='NN   '/> 비공지</br>");
		sb.append("<input type='submit' value='게시글 수정'/></form>");
		
		return sb.toString();
	}
	
	
	////////////////////////////////////
	private String myboardUpdate_HTML(List<BoardDetail> boardDetailList){
		StringBuffer sb = new StringBuffer();
		
		BoardPost boardPost1 = new BoardPost();
		List<BoardPost> boardpanList = BDao.myboardpostList(boardPost1); 
				
		sb.append("<form action='/boardUpdate?bd_Code="+boardDetailList.get(0).getMp_Code()+"' method='post'>");

		sb.append("게시판 제목 : ");		
		sb.append("<select name='bp_Code' id='bp_Code'>");
		
		sb.append("<option>게시판 선택</option>");
		for(BoardPost boardPost : boardpanList){
			
			sb.append("<option value='"+boardPost.getBp_Code()+"'>"+boardPost.getBp_Title()+"</option>");
		}
		sb.append("</select></br>");

		sb.append("게시글 제목 : <input type='text' name = 'bd_Title' value='"+boardDetailList.get(0).getMp_Title()+"'/></br>");
		sb.append("게시글 내용 : <textarea rows='8' cols='100' name='bd_Content' value='"+boardDetailList.get(0).getMp_Connent()+"'>"+boardDetailList.get(0).getMp_Connent()+"</textarea></br>");
		
		sb.append("게시글 해쉬태그 :");
		
		for (int i = 0; i < boardDetailList.size(); i++){
			sb.append("<input type='text' name = 'ms_Content' value='"+boardDetailList.get(i).getHd_Title()+"'/>");
		}
		for (int i = 0; i< 3 - boardDetailList.size(); i++){
			sb.append("<input type='text' name = 'ms_Content'/>");
		}
		sb.append("</br>공유 설정 : <input type='radio' name = 'bd_Share' value='SP' checked> 공개");
		sb.append("<input type='radio' name = 'bd_Share' value='NP  '> 비공개");
		sb.append("<input type='radio' name = 'bd_Share' value='FP  '> 이웃공개");
		sb.append("</br><input type='submit' value='게시글 수정'/></form>");
		return sb.toString();
	}
	
	
	
	
	private void boardUpdate(Board board){			
		String code = board.getBd_Code();
		int cnt = code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		board.setBd_Code(code);
		if(sessionteam.indexOf("@")==-1){
			BDao.teamboardUpdate(board);
			//System.out.println(board.getBd_Code());
			//System.out.println(board.getBd_Title());
			//System.out.println(board.getBd_Code());
			//System.out.println(board.getBd_Share());
			//System.out.println(board.getBp_Code());
			boardList(board);
		}else{
			if(BDao.myboardUpdate(board)){
				//System.out.println(boardpost.getBp_Email());
				BDao.hashDelete(board);
				String[] getContent= board.getMs_Content();	
				
				//System.out.println(boardpost.getBp_Code());
				//board.setBd_Code(BDao.myboardCode(board));
				System.out.println(board.getBd_Code());
				for(int i=0;i<getContent.length;i++){
					//System.out.println(boardpost.getBp_Code());
					board.setMs_Content2(getContent[i]);
					if(!getContent[i].equals("")){
						//System.out.println(getContent[i]);
						BDao.hashInsert(board);
					}
				}					
			}
			//boardDetailform
			boardList(board);
		}
		/* 게시글 수정 */		
	}

	private String myComment_HTML(BoardDetail boardDetail){
		StringBuffer sb = new StringBuffer();
		Comment comment = new Comment();
		String code = boardDetail.getMp_Code(); 
		int cnt = code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		comment.setM_Menu(code);
		List<Comment> commentlist = new ArrayList<Comment>();
		commentlist = BDao.MyCommentList(comment);
	
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
	
	private String teamComment_HTML(BoardDetail boardDetail){
		StringBuffer sb = new StringBuffer();
		Comment comment = new Comment();
		String code = boardDetail.getMp_Code(); 
		int cnt = code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		comment.setM_Menu(code);
		System.out.println("dd"+code);
		List<Comment> commentlist = new ArrayList<Comment>();		
		commentlist = BDao.TeamCommentList(comment);		
				
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
}

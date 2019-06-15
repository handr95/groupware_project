package com.dt.N.TI;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


@Service
public class BoardPanSv {
	private ModelAndView mav;
	@Autowired
	private TeamInfoDao TeamInfoDao;
	@Autowired
	private HttpServletRequest session;	
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;
	
	public ModelAndView excute(int type, BoardPost boardpost){
		sessionmid = (String)session.getSession().getAttribute("sessionmid");
		grade1 = (String)session.getSession().getAttribute("grade1");
		sessionteam= (String)session.getSession().getAttribute("sessionteam");
		grade2= (String)session.getSession().getAttribute("grade2");
		sessionnickname = (String)session.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");
		if(sessionteam==null)
			return new ModelAndView("/main/main");
		switch(type){
			case 1:
				TeamBoardPostList(boardpost);
				break;
			case 2:
				BoardPostInsertform();
				break;
			case 3:
				BoardPostInsert(boardpost);
				break;
			case 4:
				BoardPostUpdateform(boardpost);
				break;	
			case 5:
				BoardPostUpdate(boardpost);
				break;	
			case 6:
				boardpostDelete(boardpost);
				break;	
			case 7:
				BoardLineInsert(boardpost);
				break;
			case 8:
				BoardPostChangeView(boardpost);
				break;	
			case 9:
				BoardPostChange(boardpost);
				break;	
			default :
				break;
		}
		return mav;
	}

	
	
	private void BoardLineInsert(BoardPost boardpost){
		mav = new ModelAndView();
		mav.setViewName("service/postBoardManage");
		boardpost.setT_Code("T20150122151932");
		TeamInfoDao.teamBoardLineInsert(boardpost);
	}
	
	
	private void TeamBoardPostList(BoardPost boardpost){
		mav = new ModelAndView();
		mav.setViewName("service/postBoardManage");
		boardpost.setT_Code(sessionteam);
		List<BoardPost> boardpostList = TeamInfoDao.teamBoardPostList(boardpost); 
		mav.addObject("teamboardpostlist", BoardPostList_HTML(boardpostList));
	}
	
	private String BoardPostList_HTML(List<BoardPost> boardpostList){
		StringBuffer sb = new StringBuffer();
		sb.append("<div class='table-responsive'> ");
		sb.append("<table><tr><td>선택</td><td>제목</td><td>관리자</td><td>열람자</td><td>생성일</td></tr>");
		for (BoardPost boardpost : boardpostList){
			sb.append("<tr><td><input type='radio' name ='bp_Code' value="+boardpost.getBp_Code()+"></td>");
			sb.append("<td><a href='/boardUpdateform?bp_Code="+boardpost.getBp_Code()+"'>"+boardpost.getBp_Title()+"</a></td>");
			sb.append("<td>"+boardpost.getBp_Email()+"</td>");
			sb.append("<td>:"+BoardPostShare_HTML(boardpost)+" :</td>");
			sb.append("<td>"+boardpost.getBp_Since()+"</td>");
			sb.append("<input type='hidden' id='bp_Code' value='"+boardpost.getBp_Code()+"'>");
			
			sb.append("</tr>");
		}
		sb.append("</table></div>");
		sb.append("<input type='button' value='소유권 변경' onclick='ownerchange()'/>");
		sb.append("<input type='button' value='삭제' onclick='boardPostDelte()'/>");
		sb.append("<a href='/boardInsertform'><input type='button' value='추가'/></a>");
		return sb.toString();
	}
	
	private String BoardPostShare_HTML(BoardPost boardpost){
		StringBuffer sb = new StringBuffer();
		//System.out.println(boardpost.getBp_Code());
		List<BoardPost> boardpostList = TeamInfoDao.boardpostShare(boardpost);
		
		for (BoardPost boardShare : boardpostList){
			if(boardShare.getBp_Share()==null)
				sb.append("비공개");
			else
				sb.append(boardShare.getBp_Share());
		}
		
		
		return sb.toString();
	}
	
	
	
	private void BoardPostInsertform(){
		mav = new ModelAndView();
		mav.setViewName("service/postBoardInsert");
		mav.addObject("teamboardpostInsertForm", BoardPostInsertform_HTML());

	}
	
	private String BoardPostInsertform_HTML(){
		StringBuffer sb = new StringBuffer();
		Team team = new Team();
		
		sb.append("<form action='/boardPanInsert' method='post'>");
		sb.append("게시판 제목 : <input type='text' name='bp_Title'></br>");
		sb.append("게시판 내용 : <input type='text' name='bp_Content'></br>");
		sb.append("게시판 열람자 : "+BoardPostShareSel_HTML(team)+"</br>");
		sb.append("<input type='submit' value='게시판 등록'></form>");
		
		return sb.toString();
	}
	
	private String BoardPostShareSel_HTML(Team team){
		StringBuffer sb = new StringBuffer();
		
		
		
		team.setT_code(sessionteam);
		List<Team> teammemberList = TeamInfoDao.boardpostmember(team);
		
		sb.append("<input type='checkbox' name='allCheck' class='check-all'/> 전체");
		
		for( Team team2 : teammemberList){
			sb.append("<input type='checkbox' name='tm_memail2' class='ab' value="+team2.getTm_memail()+">");
			sb.append(team2.getTm_mnickname());
		}
		
		sb.append("<input type='checkbox' name='test' class='ab2' value='1'>");
		return sb.toString();
	}
	
	
	private void BoardPostInsert(BoardPost boardpost){
		mav = new ModelAndView();
		Team team= new Team();		
		boardpost.setT_Code(sessionteam);
		boardpost.setBp_Email(sessionmid);
		if(TeamInfoDao.boardInsert(boardpost)){
			//System.out.println(boardpost.getBp_Email());
			String[] getmemail= boardpost.getTm_memail2();	
			
			//System.out.println(boardpost.getBp_Code());
			boardpost.setBp_Code(TeamInfoDao.teamboardpostcode(boardpost));
			if(getmemail.length!=0){
				for(int i=0;i<getmemail.length;i++){
					//System.out.println(boardpost.getBp_Code());
					boardpost.setBp_Email((getmemail[i]));
					if(!getmemail[i].equals("")){
						TeamInfoDao.boardmemberInsert(boardpost);
						 
					}
				}
			}
			
		}
		
		TeamBoardPostList(boardpost);
	}
	
	private void BoardPostUpdateform(BoardPost boardpost){
		mav = new ModelAndView();
		String code = boardpost.getBp_Code();
		int cnt = code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		boardpost.setBp_Code(code);
		mav.setViewName("service/postBoardUpdate");
		List<BoardPost> boardpostList = TeamInfoDao.boardpostUpdateform(boardpost);
		mav.addObject("teamboardpostUpdateForm", BoardPostUpdateform_HTML(boardpostList));

	}
	
	private String BoardPostUpdateform_HTML(List<BoardPost> boardpost){
		StringBuffer sb = new StringBuffer();
		Team team = new Team();
		//System.out.println("html"+boardpost.get(0).getBp_Title());
		for(BoardPost bp : boardpost){
			System.out.println(boardpost.size());
			sb.append("<form action='/boardpostUpdate?bp_Code="+bp.getBp_Code()+"' method='post'>");
			sb.append("게시판 제목 : <input type='text' name='bp_Title' value='"+bp.getBp_Title()+"'></br>");
			sb.append("게시판 내용 : <input type='text' name='bp_Content' value='"+bp.getBp_Content()+"'></br>");
			sb.append("게시판 열람자 : "+BoardPostShareSel_HTML(team)+"</br>");
			sb.append("<input type='submit' value='게시판 수정'></form>");
		}
		return sb.toString();
	}
	
	
	private void BoardPostUpdate(BoardPost boardpost){
		mav = new ModelAndView();
		Team team= new Team();
		
		boardpost.setT_Code(sessionteam);
		boardpost.setBp_Email(sessionmid);
		if(TeamInfoDao.boardUpdate(boardpost)){
			if(boardpost.getTm_memail2()!=null){
				String[] getmemail= boardpost.getTm_memail2();	
				System.out.println("길이"+getmemail.length);
				//System.out.println(boardpost.getBp_Code());
				boardpost.setBp_Code(TeamInfoDao.teamboardpostcode(boardpost));
	
				TeamInfoDao.boardmemberDelete(boardpost);
				
				for(int i=0;i<getmemail.length;i++){
					//System.out.println(boardpost.getBp_Code());
					boardpost.setBp_Email((getmemail[i]));
					if(!getmemail[i].equals("")){
						TeamInfoDao.boardmemberInsert(boardpost);
					}
				}
			}else{
				TeamInfoDao.boardmemberDelete(boardpost);
			}
			
		}
		
		TeamBoardPostList(boardpost);
	}
	
	private void BoardPostChangeView(BoardPost boardpost){
		
		mav = new ModelAndView();
		
		//boardpost.setT_Code(sessionteam);
		System.out.println("boardpost:"+boardpost.getBp_Code());
		//////////////////////////////////
		
		//List<BoardPost> myTeampost = TeamInfoDao.boardPostChange(boardpost);
		mav.setViewName("/service/allOwner");
		mav.addObject("ownerChange", BoardPostChangeView_HTML(boardpost));
	}
	
	
	private String BoardPostChangeView_HTML(BoardPost bp){
		StringBuffer sb = new StringBuffer();
		
		Team t = new Team();
		t.setT_code(sessionteam);
		
		List<Team> myTeam = TeamInfoDao.boardPostChangeMember(t);
		System.out.println("bp:"+bp.getBp_Code());
		System.out.println(myTeam.get(0).getT_code());
		
		
		sb.append("<form action='/teamboardpostownerchange' method='post'>");
		for(int i=0;i<myTeam.size();i++){
			System.out.println(myTeam.get(i).getTm_memail());
			sb.append("<input type='radio' name='bp_Email' value='"+myTeam.get(i).getTm_memail()+"'>"+myTeam.get(i).getTm_memail()+"</br>");
			
		}
		sb.append("<input type='hidden' name='bp_Code' value='"+bp.getBp_Code()+"'>");
		sb.append("<input type='submit' value='소유권변경'>");
		return sb.toString();
	}
	
	
	
	
	private void BoardPostChange(BoardPost boardpost){
		System.out.println(boardpost.getBp_Email());
		System.out.println("ss"+boardpost.getBp_Code());
		TeamInfoDao.boardPostChangeUpdate(boardpost);	
		TeamBoardPostList(boardpost);	
	}
	
	
	
	private void boardpostDelete(BoardPost boardpost) {
	//	if(TeamInfoDao.boardpostDelete(boardpost)){
				
	//	}
		///boardpostDelete
		//게시판 삭제중..
		
	}
	
	

}

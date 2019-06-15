package com.dt.N.TI;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class MemoHamSv {

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

	public ModelAndView excute(int type, MemoHam memoham) {
		
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
			TeamMemoHamList(memoham);
			break;
		case 2:
			MemoHamInsertform(memoham);
			break;
		case 3:
			MemoHamInsert(memoham);
			break;
		case 4:
			MemoHamUpdateform(memoham);
			break;
		case 5:
			MemoHamUpdate(memoham);
			break;
		case 6:
			MemoHamChangeView(memoham);
			break;	
		case 7:
			MemoHamChange(memoham);
			break;
		default:
			break;
		}

		return mav;
	}

	

	private void TeamMemoHamList(MemoHam memoham) {
		mav = new ModelAndView();
		mav.setViewName("service/memoHamManage");
		memoham.setTmh_TCODE(sessionteam);		
		List<MemoHam> memoHamList = TeamInfoDao.teamMemoHamList(memoham);
		mav.addObject("teammemohamlist", MemoHamList_HTML(memoHamList));
	}

	private String MemoHamList_HTML(List<MemoHam> memoHamList) {
		StringBuffer sb = new StringBuffer();
		sb.append("<div class='table-responsive'> ");
		sb.append("<table><tr><td>선택</td><td>제목</td><td>관리자</td><td>열람자</td><td>생성일</td></tr>");
		for (MemoHam memoham : memoHamList) {
			sb.append("<tr><td><input type='radio' name='tmh_CODE' value='"+memoham.getTmh_CODE() + "'></td>");
			sb.append("<td><a href='/memohamUpdateform?tmh_CODE="+memoham.getTmh_CODE()+"'>" + memoham.getTmh_TITLE() + "</a></td>");
			sb.append("<td>" + memoham.getBp_Email() + "</td>");
			sb.append("<td>:" + MemoHamShare_HTML(memoham) + " :</td>");
			sb.append("<td>" + memoham.getTmh_SINCE() + "</td>");
			sb.append("<input type='hidden' id='tmh_CODE' value='"+memoham.getTmh_CODE()+"'>");
			
			sb.append("</tr>");
		}
		sb.append("</table></div>");
		sb.append("<input type='button' value='소유권 변경' onclick=\"ownerchange()\"/>");
		sb.append("<input type='button' value='삭제'/>");
		sb.append("<a href='/MemoHamInsertform'><input type='button' value='추가'/></a>");
		return sb.toString();
	}

	private String MemoHamShare_HTML(MemoHam memoham) {
		StringBuffer sb = new StringBuffer();
		List<MemoHam> memoHamList = TeamInfoDao.memohamShare(memoham);

		for (MemoHam memohamShare : memoHamList) {
			sb.append(memohamShare.getTa_SHARE());
		}

		return sb.toString();
	}

	private void MemoHamInsertform(MemoHam memoham){
		mav.setViewName("service/memoHaminsert");
		mav.addObject("teammemohamInsertForm", MemoHamInsertform_HTML());

	}
	
	private String MemoHamInsertform_HTML(){
		StringBuffer sb = new StringBuffer();
		Team team = new Team();
		
		sb.append("<form action='/MemoHamInsert' method='post'>");
		sb.append("메모함 제목 : <input type='text' name='tmh_TITLE'></br>");
		sb.append("메모함 내용 : <input type='text' name='tmh_CONTENT'></br>");
		sb.append("메모함 열람자 : "+MemoHamShareSel_HTML(team)+"</br>");
		sb.append("<input type='submit' value='메모함 등록'>");
		sb.append("</form>");
		return sb.toString();
	}
	
	private String MemoHamShareSel_HTML(Team team){
		StringBuffer sb = new StringBuffer();
				
		team.setT_code(sessionteam);
		
		List<Team> teammemberList = TeamInfoDao.teammemohammember(team);
		//System.out.println(team.getT_memail());
		sb.append("<input type='checkbox' id='allCheck' name='allCheck'/> 전체");
		for(Team team2 : teammemberList){
			sb.append("<input type='checkbox' name='tm_memail2' value="+team2.getTm_memail()+">");
			sb.append(team2.getTm_mnickname());
		}
		return sb.toString();
	}
	
	
	private void MemoHamInsert(MemoHam memoham){
		mav = new ModelAndView();
		Team team= new Team();
		memoham.setTmh_TCODE(sessionteam);
		memoham.setTmh_MANAGER(sessionmid);
		if(TeamInfoDao.teammemohamInsert(memoham)) {
			//System.out.println(memoham.getTmh_MANAGER());
			String[] getmemail = memoham.getTm_memail2();
			memoham.setTmh_CODE(TeamInfoDao.teammemohamtcode(memoham));
			for(int i=0; i<getmemail.length; i++) {
				memoham.setTmh_MANAGER((getmemail[i]));
				if(!getmemail[i].equals("")) {
					TeamInfoDao.teammemohammemberinsert(memoham);
				}
			}
		}
		
		TeamMemoHamList(memoham);
		
	}

	private void MemoHamUpdate(MemoHam memoham) {
		Team team= new Team();
		
		memoham.setTmh_TCODE(sessionteam);
		memoham.setTmh_MANAGER(sessionmid);
		if(TeamInfoDao.memoUpdate(memoham)){
			//System.out.println("inupdate"+memoham.getBp_Email());
			String[] getmemail = memoham.getTm_memail2();	
			
			//System.out.println(boardpost.getBp_Code());
			memoham.setTmh_CODE(TeamInfoDao.teammemohamtcode(memoham));

			TeamInfoDao.memohammemberDelete(memoham);
			for(int i=0;i<getmemail.length;i++){
				System.out.println(memoham.getTmh_CODE());
				memoham.setTmh_MANAGER(getmemail[i]);
				if(!getmemail[i].equals("")){
					TeamInfoDao.teammemohammemberinsert(memoham);
					 
				}
			}
			
		}
		
		TeamMemoHamList(memoham);
	}

	private void MemoHamUpdateform(MemoHam memoham) {
		mav.setViewName("service/memoHamUpdate");
		List<MemoHam> memohamList = TeamInfoDao.memohamShare2(memoham);
		mav.addObject("MemoHamUpdateform", MemoHamUpdateform_HTML(memohamList));
	}
	private String MemoHamUpdateform_HTML(List<MemoHam> memoham){
		StringBuffer sb = new StringBuffer();
		Team team = new Team();
		//System.out.println("html"+memoham.size());
		for(MemoHam mh : memoham){
			//System.out.println(memoham.size());
			sb.append("<form action='/memohamUpdate?tmh_CODE="+mh.getTmh_CODE()+"' method='post'>");
			sb.append("메모함 제목 : <input type='text' name='tmh_TITLE' value='"+mh.getTmh_TITLE()+"'></br>");
			//System.out.println(mh.getTmh_TITLE());
			sb.append("메모함 내용 : <input type='text' name='tmh_CONTENT' value='"+mh.getTmh_CONTENT()+"'></br>");	
			//System.out.println(mh.getTmh_CONTENT());
			sb.append("메모함 열람자 : "+MemoHamShareSel_HTML(team)+"</br>");
			sb.append("<input type='submit' value='메모함 수정'>");
		}
		return sb.toString();
	}


	
	
	
	
	private void MemoHamChangeView(MemoHam memoham){
		
		mav = new ModelAndView();
		
		//boardpost.setT_Code(sessionteam);
		System.out.println("boardpost:"+memoham.getTmh_CODE());
		//////////////////////////////////
		
		//List<BoardPost> myTeampost = TeamInfoDao.boardPostChange(boardpost);
		mav.setViewName("/service/allOwner");
		mav.addObject("ownerChange", MemoHamChangeView_HTML(memoham));
	}
	
	
	private String MemoHamChangeView_HTML(MemoHam memoham){
		StringBuffer sb = new StringBuffer();
		
		Team t = new Team();
		t.setT_code(sessionteam);
		
		List<Team> myTeam = TeamInfoDao.boardPostChangeMember(t);
		System.out.println("bp:"+memoham.getTmh_CODE());
		//System.out.println(myTeam.get(0).getT_code());
		
		
		sb.append("<form action='/teammemohamtownerchange' method='post'>");
		for(int i=0;i<myTeam.size();i++){
			//System.out.println(myTeam.get(i).getTm_memail());
			sb.append("<input type='radio' name='tmh_MANAGER' value='"+myTeam.get(i).getTm_memail()+"'>"+myTeam.get(i).getTm_memail()+"</br>");
			
		}
		sb.append("<input type='hidden' name='tmh_CODE' value='"+memoham.getTmh_CODE()+"'>");
		sb.append("<input type='submit' value='소유권변경'>");
		return sb.toString();
	}
	
	
	
	
	private void MemoHamChange(MemoHam memoham){
		//System.out.println(memoham.getTmh_MANAGER());
		//System.out.println("ss"+memoham.getTmh_CODE());
		TeamInfoDao.memohamChangeUpdate(memoham);	
		TeamMemoHamList(memoham);	
	}
	
	
	
	
	
	private void memoHamDelete() {

	}

	private void memoHamChoice() {

	}

}

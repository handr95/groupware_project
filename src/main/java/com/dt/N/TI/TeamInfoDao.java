package com.dt.N.TI;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeamInfoDao {

	@Autowired
	private SqlSession session;
	
	public boolean intConvert(int value) {

		return (value != 0) ? true : false;
	}
	//개인 정보
	public Member memberInfo(Member member){
		 return session.selectOne("Myservice.myInfo", member);		 
	}
	//팀 만들기
	public boolean teamInsert(Team team){
		 return intConvert(session.insert("Myservice.teamInsert", team));		 
	}
	//팀코드 반환
	public String getTeamCode(Team team) {		
		return session.selectOne("Myservice.getTeamCode", team);
	}
	//팀원 추가
	public boolean teamMemberInsert(Team team){
		 return intConvert(session.insert("Myservice.teamMemberInsert", team));		 
	}
	//팀원삭제
	public boolean dropteammember(Team team) {
		return intConvert(session.delete("TeamService.dropteammember", team));
	}	
	
	public List<Team> teamList(Team team){
		return session.selectList("TeamService.teamList", team);
	}
	
	public int teamListCount(Team team){
		return session.selectOne("TeamService.teammemberCount", team);
	}
	
	public List<Team> teammemberList(Team team){
		return session.selectList("TeamService.teammember", team);
	}
	
	public List<Team> teamDetail(Team team){
		return session.selectList("TeamService.teamDetail", team);
	}
	
	public List<Team> teamInfoUpdate(Team team){
		return session.selectList("TeamService.teamInfoUpdate", team);
	}
	
	public List<BoardPost> myBoardPostList(BoardPost boardpost){
		return session.selectList("Boards.teamInfoUpdate", boardpost);
	}
	
	public List<BoardPost> teamBoardPostList(BoardPost boardpost){
		return session.selectList("TeamService.teamboardpostlist", boardpost);
	}

	public List<BoardPost> boardpostShare(BoardPost boardpost){
		return session.selectList("TeamService.teamboardpostshare2", boardpost);
	}
	
	public List<BoardPost> boardpostUpdateform(BoardPost boardpost){
		return session.selectList("TeamService.boardpostUpdateform", boardpost);
	}
			
	public List<Team> boardPostChangeMember(Team team){
		return session.selectList("TeamService.boardPostChangeMember", team);
	}
	
	public List<BoardPost> boardPostChange(BoardPost boardpost){
		return session.selectList("TeamService.boardPostChangeView", boardpost);
	}
	
	
	public boolean boardPostChangeUpdate(BoardPost boardpost){
		return intConvert(session.update("TeamService.boardPostChange", boardpost));
	}
	
	public boolean memohamChangeUpdate(MemoHam memoham){
		return intConvert(session.update("TeamService.memohamChange", memoham));
	}
	
	
	
	
	public List<BoardPost> boardpostShare2(BoardPost boardpost){
		//System.out.println("dao"+boardpost.getBp_Title());
		return session.selectList("TeamService.teamboardpostshare2", boardpost);
	}
	
	public List<Team> boardpostmember(Team team){
		return session.selectList("TeamService.teamboardpostmember", team);
	}
	
	public boolean boardInsert(BoardPost boardpost){
		return intConvert(session.insert("TeamService.teamboardpostInsert", boardpost));
	}
	public List<MemoHam> teamMemoHamList(MemoHam memoham) {
		return session.selectList("TeamService.teammemohamlist", memoham);
	}
	public List<MemoHam> memohamShare(MemoHam memoham) {
		return session.selectList("TeamService.teammemohamshare", memoham);
	}
	public boolean teammemohamInsert(MemoHam memoham){
		 return intConvert(session.insert("TeamService.teammemohamInsert", memoham));		 
	}
	public List<Team> teammemohammember(Team team) {
		return session.selectList("TeamService.teammemohammember",team);
	}
	
	public boolean teammemohammemberinsert(MemoHam memoham) {
		 return intConvert(session.insert("TeamService.teammemohammemberinsert", memoham));
	}
	public String teammemohamtcode(MemoHam memoham){
	      return session.selectOne("TeamService.teammemohamtcode", memoham);
	}
	public List<MemoHam> memohamShare2(MemoHam memoham) {
		return session.selectList("TeamService.memohamShare2", memoham);
	}
	
	public boolean memoUpdate(MemoHam memoham) {
		return intConvert(session.update("TeamService.memoUpdate", memoham));
	}
	public boolean memohammemberDelete(MemoHam memoham) {
		 return intConvert(session.delete("TeamService.memohammemberDelete", memoham));
	}
	
	public boolean boardmemberInsert(BoardPost boardpost){
		return intConvert(session.insert("TeamService.teamboardpostmemberinsert", boardpost));
	}
	
	public String teamboardpostcode(BoardPost boardpost){
		return session.selectOne("TeamService.teamboardpostcode", boardpost);
	}
	
	public boolean boardUpdate(BoardPost boardpost){
		return intConvert(session.update("TeamService.teamboardpostUpdate", boardpost));
	}
	
	public boolean boardmemberUpdate(BoardPost boardpost){
		return intConvert(session.update("TeamService.teamboardpostmemberUpdate", boardpost));
	}
	
	public boolean boardmemberDelete(BoardPost boardpost){
		return intConvert(session.delete("TeamService.teamboardpostmemberDelete", boardpost));
	}

	public boolean teamBoardLineInsert(BoardPost boardpost){
		return intConvert(session.insert("TeamService.teamBoardLineInsert", boardpost));
	}
	

	
	
	
	

	public boolean isTeamName(Team team){
		return intConvert((Integer)session.selectOne("TeamService.isTeamName", team));
	}
	public List<Member> searchaddmember(Team team) {
		return session.selectList("TeamService.getmemberlist",team);
	}
	public boolean boardpostDelete(BoardPost boardpost) {
		return intConvert(session.delete("TeamService.boardpostDelete", boardpost));		
	}
		

}

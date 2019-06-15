package com.dt.L.MI;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MyPageDao {

	@Autowired
	private SqlSession session;

	public boolean intConvert(int value) {

		return (value != 0) ? true : false;
	}

	public boolean isId(Member member) {
		return intConvert((Integer) session.selectOne("MyPage.isId", member));

	}

	public boolean isName(Member member) {
		return intConvert((Integer) session.selectOne("MyPage.isName", member));
	}

	public boolean updateNick(Member member) {
		return intConvert(session.update("MyPage.updateNick", member));
	}

	public boolean isPWD(Member member) {
		return intConvert((Integer) session.selectOne("MyPage.isPWD", member));

	}												 
	public boolean UpdatePwd(Member member) {
		return intConvert(session.update("MyPage.UpdatePwd", member));
	}

	public List<Member> MyInfo(Member member) {
		return session.selectList("MyPage.myInfo", member);
	}
	public boolean memberDrop(Member member) {
		return intConvert(session.delete("MyPage.memberDrop", member));
	}
	
	
	

	public List<BoardPost> myBoardPostList(BoardPost boardpost){
		return session.selectList("TeamService.myboardpostlist", boardpost);
	}
	
	public boolean myBoardPostInsert(BoardPost boardpost){
		return intConvert(session.insert("TeamService.myboardpostInsert", boardpost));
	}
	
	public boolean myBoardPostUpdate(BoardPost boardpost){
		System.out.println("dao"+boardpost.getBp_Code());
		return intConvert(session.update("TeamService.myboardpostUpdate", boardpost));
	}
	
	public List<BoardPost> myBoardPostListDetail(BoardPost boardpost){
		return session.selectList("TeamService.myboardpostlistDetail", boardpost);
	}
	
	public List<MyMemoHam> myMemoHamList(MyMemoHam memoham){
		return session.selectList("TeamService.myMemoHamList", memoham);
	}

	public List<MyMemoHam> myMemohamShare(MyMemoHam memoham){
		return session.selectList("TeamService.myMemohamShare", memoham);
	}
	
	public boolean myMemoHamInsert(MyMemoHam memoham){
		return intConvert(session.insert("TeamService.myMemohamInsert", memoham));
	}
	
	public List<MyMemoHam> myMemoHamListDetail(MyMemoHam memoham){
		return session.selectList("TeamService.myMemoHamListDetail", memoham);
	}
	
	public boolean myMemoHamUpdate(MyMemoHam memoham){
		return intConvert(session.update("TeamService.myMemoHamUpdate", memoham));
	}
	
}

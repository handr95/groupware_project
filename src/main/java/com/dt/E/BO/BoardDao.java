package com.dt.E.BO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession session;
	
	
	public boolean intConvert(int value){
		return (value!=0)?true:false;
	}

	public List<Board> teamboardList(Board board){
		return session.selectList("Boards.teamboardlist", board);
	}
	public List<Board> teamboardListall(Board board){
		return session.selectList("Boards.teamboardlistall", board);
	}
	
	public List<Board> myboardList(Board board){
		return session.selectList("Boards.myboardlist", board);
	}
	public List<Board> myboardListall(Board board){
		return session.selectList("Boards.myboardListall", board);
	}
	
	
	public List<BoardPost> teamboardpostList(BoardPost boardpost){
		return session.selectList("Boards.teamboardpostlist", boardpost);
	}
	public List<BoardPost> myboardpostList(BoardPost boardpost){
		return session.selectList("Boards.myboardpostlist", boardpost);
	}
	
	public List<BoardDetail> myboardDetail_View(BoardDetail boardDetail){
		return session.selectList("Boards.myboardDetail", boardDetail);
	}
	public List<BoardDetail> teamboardDetail_View(BoardDetail boardDetail){
		return session.selectList("Boards.teamboardDetail", boardDetail);
	}
	
	public boolean teamboardInsert(Board board){
		return intConvert(session.insert("Boards.teamboardInsert", board));
	}	
		
	public boolean teamboardUpdate(Board board){
		return intConvert(session.update("Boards.teamboardUpdate", board));
	}	
	
	public boolean myboardUpdate(Board board){
		return intConvert(session.update("Boards.myboardUpdate", board));
	}	
	public List<Comment> MyCommentList(Comment comment){
		return session.selectList("Comments.boMyCommentList", comment);
	}
	public List<Comment> TeamCommentList(Comment comment){
		return session.selectList("Comments.boTeamCommentList", comment);
	}
	public boolean myCommentInsert(Comment comment){
		return intConvert(session.insert("Comments.boMyCommentInsert", comment));
	}		
	public boolean teamCommentInsert(Comment comment){
		return intConvert(session.insert("Comments.boTeamCommentInsert", comment));
	}

	public boolean teamCommentDelete(Comment comment) {		
		return intConvert(session.delete("Comments.boTeamCommentDelete", comment));
	}

	public boolean myCommentDelete(Comment comment) {
		return intConvert(session.delete("Comments.boMyCommentDelete", comment));
	}
	public Comment MyComment(Comment comment){
		return session.selectOne("Comments.boMyComment", comment);
	}
	public Comment TeamComment(Comment comment){
		return session.selectOne("Comments.boTeamComment", comment);
	}

	public boolean teamCommentUpdate(Comment comment) {
		return intConvert(session.update("Comments.boTeamCommentUpdate", comment));
	}
	public boolean myCommentUpdate(Comment comment) {
		return intConvert(session.update("Comments.boMyCommentUpdate", comment));
	}
	
	

	public boolean myboardInsert(Board board){
		//System.out.println("개인 디에온");
		return intConvert(session.insert("Boards.myboardInsert", board));
	}	
	
	public boolean hashInsert(Board board){
		return intConvert(session.insert("Boards.HashInsert", board));
	}
	
	public boolean hashDelete(Board board){
		return intConvert(session.delete("Boards.hashDelete", board));
	}
	
	public String myboardCode(Board board){
		return session.selectOne("Boards.myboardCode", board);
	}
	
	
}
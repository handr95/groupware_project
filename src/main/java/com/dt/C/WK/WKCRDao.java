package com.dt.C.WK;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WKCRDao {
	@Autowired
	private SqlSession session;
	
	
	public boolean intConvert(int value){
		return (value!=0)? true:false;
	}

	public boolean commentInsert(Comment comment){
		return intConvert(session.insert("Comments.bwcommentInsert", comment));
	}	
	public boolean commentUpdate(Comment comment){
		return intConvert(session.update("Comments.bwcommentUpdate", comment));
	}
	public boolean commentDelete(Comment comment){
		return intConvert(session.delete("Comments.bwcommentDelete", comment));
	}
	public List<Comment> commentSelect(Comment comment){
		return session.selectList("Comments.bwcommentSelect", comment);
	}
	
	public Comment bwComment(Comment comment){
		return session.selectOne("Comments.bwComment",comment);
	}

	public boolean replyInsert(Reply reply){
		return intConvert(session.insert("replyInsert", reply));
	}
	public boolean replyUpdate(Reply reply){
		return intConvert(session.update("replyUpdate", reply));
	}
	public boolean replyDelete(Reply reply){
		return intConvert(session.delete("replyDelete", reply));
	}
	public List<Reply> replySelect(Reply reply){
		return session.selectList("replySelect", reply);
	}
}
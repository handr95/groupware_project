package com.dt.D.DC;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class DCCRDao {
	
	private SqlSession session;
	
	
	public boolean intConvert(int value){
		return (value!=0)? true:false;
	}

	public boolean commentInsert(Comment comment){
		return intConvert(session.insert("commentInsert", comment));
	}	
	public boolean commentUpdate(Comment comment){
		return intConvert(session.update("commentUpdate", comment));
	}
	public boolean commentDelete(Comment comment){
		return intConvert(session.delete("commentDelete", comment));
	}
	public List<Comment> commentSelect(Comment comment){
		return session.selectList("commentSelect", comment);
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

package com.dt.B.PJ;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PJCRDao {
	@Autowired
	private SqlSession session;
	
	
	public boolean intConvert(int value){
		return (value!=0)? true:false;
	}

	public boolean commentInsert(Comment comment){
		return intConvert(session.insert("Comments.pjcommentInsert", comment));
	}	
	public boolean commentUpdate(Comment comment){
		return intConvert(session.update("Comments.pjcommentUpdate", comment));
	}
	public boolean commentDelete(Comment comment){
		return intConvert(session.delete("Comments.pjcommentDelete", comment));
	}
	public List<Comment> commentSelect(Comment comment){
		return session.selectList("Comments.pjcommentSelect", comment);
	}
	
	public Comment pjComment(Comment comment){
		return session.selectOne("Comments.pjComment",comment);
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
	public List<Reply> replySelect(){
		return session.selectList("replySelect");
	}
	
		

}

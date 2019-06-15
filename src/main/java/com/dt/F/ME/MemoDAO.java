package com.dt.F.ME;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemoDAO {
	@Autowired 
	private SqlSession session;

	
	public boolean intConvert(int value){
		return (value!=0)?true:false;
	}
	
	public List<MemoBean> getMemoList(MemoBean memobean){
		return session.selectList("Memo.getMemoList", memobean);
	}

	public List<MemoBean> getTeamMemoList(MemoBean memobean){
		return session.selectList("Memo.getTeamMemoList", memobean);
	}
	
	public List<MemoBean> getMemoHamList(MemoBean memobean) {
		return session.selectList("Memo.getMemoHamList",memobean);
	}
	
	public List<MemoBean> getTeamMemoHamList(MemoBean memobean) {
		return session.selectList("Memo.getTeamMemoHamList",memobean);
	}
	
	public boolean memoInsert(MemoBean memobean){
		return intConvert(session.insert("Memo.memoInesrt", memobean));
	}
	public boolean memoTeamInsert(MemoBean memobean){
		return intConvert(session.insert("Memo.memoTeamInesrt", memobean));
	}
	public boolean memoUpdate(MemoBean memobean){
		return intConvert(session.update("Memo.memoUpdate", memobean));
	}
	public boolean memoTeamUpdate(MemoBean memobean){
		return intConvert(session.update("Memo.memoTeamUpdate", memobean));
	}
	public boolean memoDelete(MemoBean memobean){
		return intConvert(session.delete("Memo.memoDelete", memobean));
	}
	public boolean memoTeamDelete(MemoBean memobean){
		return intConvert(session.delete("Memo.memoTeamDelete", memobean));
	}
	public MemoBean getMemo(MemoBean memobean){
		return session.selectOne("Memo.getMemo", memobean);
	}

	public MemoBean getTeamMemo(MemoBean memobean){
		return session.selectOne("Memo.getTeamMemo", memobean);
	}	
	
	
}

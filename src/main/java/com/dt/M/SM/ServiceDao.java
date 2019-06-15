package com.dt.M.SM;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceDao {
	
	@Autowired
	private SqlSession session;
	
	public boolean intConvert(int value){
		
		return (value!=0)? true:false;
	}
	
	public void alarmMgrUpdate(SM_Member member){
		
	}
		
	public void logOutTimeUpdate(SM_Member member){
		
	}
	
	public List<Alarms> getAlarm(Alarms alarm) {
		return session.selectList("Alarms.getAlarm", alarm);
		
	}
	/*
	public boolean getAlarm_PjInsert(SM_Member member){
		return intConvert(session.selectOne("getAlarm_PjInsert", member));
	}
	
	public boolean getAlarm_PjFinish(SM_Member member){
		return intConvert(session.selectOne("getAlarm_PjFinisht", member));
		
	}
	public boolean getAlarm_PjLinkWo(SM_Member member){
		return intConvert(session.selectOne("getAlarm_PjLinkWo", member));
		
	}
	public boolean getAlarm_BWoInsert(SM_Member member){
		return intConvert(session.selectOne("getAlarm_BWoInsert", member));
		
	}
	public boolean getAlarm_BWoUpdate(SM_Member member){
		return intConvert(session.selectOne("getAlarm_BWoUpdate", member));
		
	}
	public boolean getAlarm_BWoFinish(SM_Member member){
		return intConvert(session.selectOne("getAlarm_BWoFinish", member));
		
	}
	public boolean getAlarm_BWoReport(SM_Member member){
		return intConvert(session.selectOne("getAlarm_BWoReport", member));
		
	}
	public boolean getAlarm_SWoInsert(SM_Member member){
		return intConvert(session.selectOne("getAlarm_SWoInsert", member));
		
	}
	public boolean getAlarm_SWoUpdate(SM_Member member){
		return intConvert(session.selectOne("getAlarm_SWoUpdate", member));
		
	}
	public boolean getAlarm_SWoFinish(SM_Member member){
		return intConvert(session.selectOne("getAlarm_SWoFinish", member));
		
	}
	public boolean getAlarm_SWoReport(SM_Member member){
		return intConvert(session.selectOne("getAlarm_SWoReport", member));
		
	}
	public boolean getAlarm_CaInsert(SM_Member member){
		return intConvert(session.selectOne("getAlarm_CaInsert", member));
		
	}
	public boolean getAlarm_CaChange(SM_Member member){
		return intConvert(session.selectOne("getAlarm_CaChange", member));
		
	}
*/
	
}

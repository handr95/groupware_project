package com.dt.G.CA;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CalendarDAO {
	@Autowired
	private SqlSession session;	
	
	public boolean intConvert(int value){
		return (value!=0)?true:false;
	}
	
	
	public List<Calendar> calList(Calendar calendar){
		return session.selectList("Calendars.calList",calendar);
	}
	
	public List<Calendar> currentCal(Calendar calendar){
		return session.selectList("Calendars.currentCal",calendar);
	}
	
	public Calendar currentUpdatesel(Calendar calendar){
		return session.selectOne("Calendars.currentUpdatesel",calendar);
	}
	
	
	public boolean currentUpdate(Calendar calendar){
		return intConvert(session.update("Calendars.currentUpdate", calendar));
	}
	
	public boolean currentInsert(Calendar calendar){
		return intConvert(session.insert("Calendars.currentInsert", calendar));
	}
	 /*	 
	 monthTeamUp	 public	 List<Calendar>
	 monthDown	 public	 List<Calendar>
	 monthTeamDown	 public	 List<Calendar>
	 monthSel	 public	 List<Calendar>
	 monthTeamSel	 public	 List<Calendar>
	 weekUp()	 public	 List<Calendar>
	 weekTeamUp()	 public	 List<Calendar>
	 weekDown()	 public	 List<Calendar>
	 weekTeamDown()	 public	 List<Calendar>
	 todayMonth()	 public	 List<Calendar>
	 todayTeamMonth()	 public	 List<Calendar>
	 todayWeek()	 public	 List<Calendar>
	 todayTeamWeek()	 public	 List<Calendar>
	 today()	 public	 List<Calendar>
	 Teamtoday()	 public	 List<Calendar>
	 
*/
	
	public List<Calendar> allcal(Calendar calendar){
		return session.selectList("Calendars.allcal",calendar);
	}


	public List<Calendar> allteamcal(Calendar calendar) {
		return session.selectList("Calendars.allteamcal",calendar);
	}
}

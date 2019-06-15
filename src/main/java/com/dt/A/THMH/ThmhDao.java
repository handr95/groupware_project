package com.dt.A.THMH;

import java.util.List;






import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ThmhDao {
	@Autowired
	private SqlSession session;
	
	public List<Calendar> mtodayCal_View(Calendar calendar){
		return session.selectList("Calendar.mtoDayCalList", calendar);
	}
		
	public List<Calendar> ttodayCal_View(Calendar calendar){
		return session.selectList("Calendar.ttoDayCalList", calendar);
	}
	
	public List<Board> bnotice_View(Board board){
		return session.selectList("board.bnoticeList", board);
	}
	
	public List<BWork> myDo_View(BWork bwork){
		return session.selectList("bwork.myDoList", bwork);
	}
		
	public List<UpdateInfo> myTeamUpdate_View(UpdateInfo update){
		return session.selectList("update.myTeamUpdateList", update);
	}
		
	public List<Board> thnotice(Board board){
		return session.selectList("Boards.notice", board);
	}
	
	public List<Board> mhnotice(Board board){
		return session.selectList("Boards.notice", board);
	}
	
	public List<Board> findHash(Board board){
		//System.out.println("d"+board.getHs_Title());
		return session.selectList("Boards.findHash", board);
	}
	public List<Board> findHashBoard(Board board){
		return session.selectList("Boards.findHashBoard", board);
	}
	
	public List<Calendar> todayCal(Calendar calendar){
		return session.selectList("Calendars.todayCal", calendar);
	}

}
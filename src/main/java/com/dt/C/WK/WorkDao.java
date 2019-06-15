package com.dt.C.WK;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class WorkDao {
	@Autowired
	private SqlSession session;
	
	public boolean intConvert(int value){		
		return (value!=0)? true:false;
	}
	
	public List<BWork> workList(BWork bwork){
		return session.selectList("BWorks.wkList", bwork);
	}
	
	public List<BWork> workDetail_View(BWork bwork){
		return session.selectList("BWorks.wkselect", bwork);
	}
	
	public List<SWork> wkSWork_View(SWork swork){
		return session.selectList("SWorks.swkselect", swork);
	}
	
	public boolean workInsert(BWork bwork){
		return intConvert(session.insert("BWorks.wkinsert", bwork));
	}
	
	public boolean workUpdate(BWork bwork){
		return intConvert(session.insert("BWorks.wkupdate", bwork));
	}
	
	public boolean pjworkInsert(BWork bwork){
		return intConvert(session.insert("BWorks.pjwkinsert", bwork));
	}

	public List<BWork> workcList(BWork bwork) {
		return session.selectList("BWorks.wkCList", bwork);
	}
	public boolean workCInsert(BWork bwork){
		return intConvert(session.update("BWorks.wkCinsert", bwork));
	}

	public boolean sWorkInsert(SWork swork) {
		return intConvert(session.insert("SWorks.sWorkInsert",swork));
	}

	public boolean UnConnect(BWork bwork) {
		return intConvert(session.update("BWorks.UnConnect", bwork));
	}
	public boolean sWorkDelete(SWork swork) {
		return intConvert(session.delete("SWorks.sWorkDelete",swork));
	}
	
	
}

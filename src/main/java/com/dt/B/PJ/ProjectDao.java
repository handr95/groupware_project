package com.dt.B.PJ;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProjectDao {
	
	@Autowired
	private SqlSession session;
	
	public boolean intConvert(int value){		
		return (value!=0)? true:false;
	}
	
	public List<Project> projectList(Project project){
		return session.selectList("Projects.allpjselect", project);
	}
	
	public List<Project> projectDetail_View(Project project){
		return session.selectList("Projects.pjSelect", project);
	}

	public boolean projectInsert(Project project){
		return intConvert(session.insert("Projects.pjInsert", project));
	}
	
	public List<Project> projectUpdate_View(Project project){
		return session.selectList("Projects.pjSelect",project);
	}
	
	public boolean projectUpdate(Project project){
		return intConvert(session.update("Projects.pjupdate", project));
	}
	
	public boolean projectDelete(Project project){
		return intConvert(session.delete("pjdelete", project));
	}
	
	public List<BWork> pjBWork_View(BWork bwork){
		return session.selectList("BWorks.pjBWselect", bwork);
	}

	public boolean UnConnect(Project project) {
		return intConvert(session.update("Projects.UnConnect",project));
	}
	
}

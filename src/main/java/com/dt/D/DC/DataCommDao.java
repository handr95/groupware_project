package com.dt.D.DC;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DataCommDao {
	@Autowired
	private SqlSession session;
	
	public boolean intConvert(int value){
		return (value!=0)? true:false;
	}
	
	public List<DataComm> dataCommList(DataComm dataComm){
		return session.selectList("dataCommList", dataComm);
	}//자료실 전체 목록
	public boolean dataAddAfter(DataComm dataComm){
		return intConvert(session.insert("dataAddAfter", dataComm));
	}
	public List<DataComm> dataCommSelect(DataComm dataComm){
		return session.selectList("dataCommSelect", dataComm);
	}//자료 하나의 세부 정보
	public List<DataComm> dataUpdateform(DataComm dataComm){
		return session.selectList("dataUpdateform", dataComm);
	}//수정해야하는 자료의 세부 정보 가져와야함
	public boolean dataUpdate(DataComm dataComm){
		System.out.println("dao"+dataComm.getD_Title());
		return intConvert(session.update("dataUpdate", dataComm));
	}
	
	public List<DataComm> getD_Data(DataComm dataComm){
		return session.selectList("getD_Data",dataComm);
	}

	public boolean DataInsert(DataComm dataComm) {
		return intConvert(session.insert("insertData",dataComm));
	}
	
	public boolean dataDelete(DataComm dataComm) {
		return intConvert(session.delete("dataDelete", dataComm));
		
	}

	public boolean dataCommentInsert(Comment comment) {
		return intConvert(session.insert("dataCommentInsert", comment));
		
	}

	public boolean dataCommentUpdate(Comment comment) {
		return intConvert(session.update("dataCommentUpdate", comment));
		
	}

	public boolean dataCommentDelete(Comment comment) {
		return intConvert(session.delete("dataCommentDelete", comment));
		
	}

	public DataComm dataDetail_View(DataComm dataComm) {
		System.out.println("dao"+dataComm.getD_Code());
		return session.selectOne("dataDetail",dataComm);
	}

	
}

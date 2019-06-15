package com.dt.J.GC;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MainDao {

	@Autowired
	private SqlSession session;

	public boolean intConvert(int value) {

		return (value != 0) ? true : false;
	}

	public List<Notice> noticeform(Notice notice) {

		return  session.selectList("Notice.noticeform", notice);

	}

	public List<Notice> noticeDetail(Notice notice) {
		return  session.selectList("Notice.noticeDetail", notice);
	}

	public boolean noticeInsert(Notice notice) {
		return intConvert(session.insert("Notice.noticeInsert", notice));

	}


	
	public boolean noticeUpdate(Notice notice) {
		return intConvert(session.update("Notice.noticeUpdate", notice));

	}
	public boolean noticeDelete(Notice notice) {
		return intConvert(session.delete("Notice.noticeDelete", notice));

	}

	public List<Quest> questform(Quest quest) {
		return session.selectList("Myservice.questSelect", quest);

	}

	public List<Quest> questdform(Quest quest) {
		return session.selectList("Myservice.questdSelect", quest);
	}

	
	public Quest questdSelectOne(Quest quest) {		
		return session.selectOne("Myservice.questdSelectOne", quest);
	}
	public boolean questInsert(Quest quest){

		return intConvert(session.insert("Myservice.questInsert", quest));
	}


	public List<Quest> questUpdateform(Quest quest) {
		return session.selectList("FAQ.pjSelect", quest);
	}

	public boolean questUpdate(Quest quest) {
		return intConvert(session.update("Myservice.questUpdate", quest));

	}

	public boolean questDelete(Quest quest) {
		return intConvert(session.delete("Myservice.questDelete", quest));

	}

	public boolean questBClassInsert(BSubClass bsubClass) {
		return intConvert(session.insert("questBClassInsert", bsubClass));
	}

	public List<BSubClass> questBClassUpdateform(BSubClass bsubClass) {
		return session.selectList("questBClassUpdate", bsubClass);

	}

	public boolean questBClassDelete(BSubClass bsubClass) {
		return intConvert(session.delete("questBClassDelete", bsubClass));

	}

	public boolean questBClassUpdate(BSubClass bsubClass) {
		return intConvert(session.update("questBClassUpdate", bsubClass));

	}

	public boolean questSClassInsert(BSubClass bsubClass) {
		return intConvert(session.insert("questSClassInsert", bsubClass));
	}

	public List<SSubClass> questSClassUpdateform(BSubClass bsubClass) {
		return session.selectList("questSClassUpdate", bsubClass);

	}

	public boolean questSClassDelete(BSubClass bsubClass) {
		return intConvert(session.delete("questSClassDelete", bsubClass));

	}

	public boolean questSClassUpdate(BSubClass bsubClass) {
		return intConvert(session.update("questSClassUpdate", bsubClass));

	}

	public List<ErrorReport> errorReportform(ErrorReport errorReport) {
		return session.selectList("errors.errorReportListselect", errorReport);
	}

	public boolean ErrorReportInsert(ErrorReport errorReport) {
		return intConvert(session.insert("errorReportInsert", errorReport));

	}

	public List<ErrorReport> errorReportDetail(ErrorReport errorReport) {

		return session.selectList("errorReportDetail", errorReport);
	}
	
	public List<ErrorReport> errorReportReplyform(ErrorReport errorReport) {
		return session.selectList("errors.errorReportDetail", errorReport);
	}
	

	public boolean errorReportReply(ErrorReport errorReport) {

		return intConvert(session.update("errorReportReply", errorReport));
	}

	public boolean errorReportDelete(ErrorReport errorReport) {
		return intConvert(session.delete("errorReportDelete", errorReport));
	}

}

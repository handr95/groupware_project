package com.dt.H.MS;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class MessageDAO {
	@Autowired
	private SqlSession session;
	
	
	public boolean intConvert(int value){
		return (value!=0)?true:false;
	}
	public List<Team> getTeamList(Message message){
		return session.selectList("Messages.getTeamList", message);
		}
	public List<AddressBean> getaddrList(Message message){
		System.out.println("ddd");
		return session.selectList("Messages.getaddrList", message);
		}
	//보낸 메세지함
	public List<Message> getSendMessageList(Message message){
		return session.selectList("Messages.getSendMessageList", message);
	}
	//받은 메세지함
	public List<Message> getReciveMessageList(Message message){
		return session.selectList("Messages.getReciveMessageList", message);
	}
	//보낸 메세지 등록
	public boolean messageInsert(Message message){
		return intConvert(session.insert("Messages.messageInsert", message));
	}
	//받은 메세지 등록 저장되는 값음
	public boolean messageResiveInsert(Message message){
		return intConvert(session.insert("Messages.messageResiveInsert", message));
	}
	//보낸 메시지 삭제
	public boolean messageDelete(Message message){
		return intConvert(session.delete("Messages.messageDelete", message));
	}
	//받은 메시지 삭제
	public boolean messageResiveDelete(Message message){
		return intConvert(session.delete("Messages.messageResiveDelete", message));
	}
}

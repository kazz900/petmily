package chat.model.dao;

import java.sql.Connection;

import chat.model.vo.Chat;

public class ChatDao {
	
	public ChatDao () {}

	public Chat getChat(Connection conn, int chatSeq, int memberSeq, int otherId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int endChat(Connection conn,int memberSeq, int chatSeq) {
		// TODO Auto-generated method stub
		return 0;
	}
}

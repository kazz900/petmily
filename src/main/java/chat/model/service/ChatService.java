package chat.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import chat.model.dao.ChatDao;
import chat.model.vo.Chat;

public class ChatService {
	private ChatDao cDao = new ChatDao();
	
	public ChatService() {}
	
	public Chat getChat(int chatSeq, int memberSeq, int otherId) {
		// TODO Auto-generated method stub
		Chat chat = null;	
		Connection conn = getConnection();		
		chat = cDao.getChat(conn, chatSeq, memberSeq, otherId);
		close(conn);
		return chat;
	}
	
	public int endChat(int memberSeq, int chatSeq) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = getConnection();
		result = cDao.endChat(conn, memberSeq, chatSeq);
		close(conn);
		return result;
	}
}

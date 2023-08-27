package standardreply.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import standardreply.model.dao.StandardReplyDao;
import standardreply.model.vo.StandardReply;

public class StandardReplyService {
	private StandardReplyDao sprDao = new StandardReplyDao();
	
	public StandardReplyService() {}
	
	public int insertStandardReply(int postSeq, StandardReply standardReply) {
        // TODO Auto-generated constructor stub
		int result = 0;
		Connection conn = getConnection();
		result = sprDao.insertStandardReply(conn, postSeq, standardReply);
		return result;
	}
	
	public int deleteStandardReply(int postSeq, int replySeq) {
		// TODO Auto-generated constructor stub
		int result = 0;
		Connection conn = getConnection();
		result = sprDao.deleteStandardReply(conn, postSeq, replySeq);
		return result;
	}
	
	public ArrayList<StandardReply> getStandardReplyList(){
		// TODO Auto-generated constructor stub
		ArrayList<StandardReply> list = null;
		Connection conn = getConnection();
		list = sprDao.getStandardReplyList(conn);
		close(conn);
		return list;
	}
}

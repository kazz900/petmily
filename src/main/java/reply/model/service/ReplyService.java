package reply.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import reply.model.dao.ReplyDao;
import reply.model.vo.Reply;
import standardreply.model.vo.StandardReply;

public class ReplyService {
	private ReplyDao rDao = new ReplyDao();
	
	public ReplyService() {}
	
	public int insertReply(int postSeq, StandardReply standardReply) {
        // TODO Auto-generated constructor stub
		int result = 0;
		Connection conn = getConnection();
		result = rDao.insertReply(conn, postSeq, standardReply);
		return result;
	}
	
	public int deleteReply(int postSeq, int replySeq) {
		// TODO Auto-generated constructor stub
		int result = 0;
		Connection conn = getConnection();
		result = rDao.deleteReply(conn, postSeq, replySeq);
		return result;
	}
	
	public ArrayList<Reply> getReplyList(){
		ArrayList<Reply> list = null;
		Connection conn = getConnection();
		list = rDao.getReplyList(conn);
		close(conn);
		return list;
	}
}

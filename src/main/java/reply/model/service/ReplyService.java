package reply.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;
import static common.JDBCTemplate.commit;

import java.sql.Connection;
import java.util.ArrayList;

import reply.model.dao.ReplyDao;
import reply.model.vo.Reply;

public class ReplyService {
	private ReplyDao rDao = new ReplyDao();
	
	public ReplyService() {}
	
	public int insertReply(Reply reply) {
		int result = 0;
		Connection conn = getConnection();
		result = rDao.insertReply(conn, reply);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	public ArrayList<Reply> getReplyList(){
		ArrayList<Reply> list = null;
		Connection conn = getConnection();
		list = rDao.getReplyList(conn);
		close(conn);
		return list;
	}

	public int deleteReply(int replySeq) {
		int result = 0;
		Connection conn = getConnection();
		result = rDao.deleteReply(conn, replySeq);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
}

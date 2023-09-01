package tradereply.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import tradereply.model.dao.TradeReplyDao;
import tradereply.model.vo.TradeReply;

public class TradeReplyService {
	private TradeReplyDao sprDao = new TradeReplyDao();
	
	public TradeReplyService() {}
	
	public int insertStandardReply(int postSeq, TradeReply tradeReply) {
        // TODO Auto-generated constructor stub
		int result = 0;
		Connection conn = getConnection();
		result = sprDao.insertTradeReply(conn, postSeq, tradeReply);
		return result;
	}
	
	public int deleteStandardReply(int postSeq, int replySeq) {
		// TODO Auto-generated constructor stub
		int result = 0;
		Connection conn = getConnection();
		result = sprDao.deleteTradeReply(conn, postSeq, replySeq);
		return result;
	}
	
	public ArrayList<TradeReply> getStandardReplyList(){
		// TODO Auto-generated constructor stub
		ArrayList<TradeReply> list = null;
		Connection conn = getConnection();
		list = sprDao.getTradeReplyList(conn);
		close(conn);
		return list;
	}
}

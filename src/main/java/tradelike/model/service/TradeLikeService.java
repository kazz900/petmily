package tradelike.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import tradelike.model.dao.TradeLikeDao;


public class TradeLikeService {
	private TradeLikeDao tlDao = new TradeLikeDao();
	
	public TradeLikeService() {}
	
	public int putTradeLike(int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = getConnection();
		result = tlDao.putTradeLike(conn, memberSeq, postSeq);
		close(conn);
		return result;
	}

	public int undoTradeLike(int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = getConnection();
		result = tlDao.undoTradeLike(conn, memberSeq, postSeq);
		close(conn);
		return result;
	}
}

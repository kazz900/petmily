package tradepost.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import tradepost.model.dao.TradePostDao;
import tradepost.model.vo.TradePost;



public class TradePostService {
	private TradePostDao tpDao = new TradePostDao();
	
	public TradePostService() {}
	
	public int getTradePostListCount() {
		int count = 0;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		count = tpDao.getTradePostListCount(conn);
		close(conn);
		return count;
	}

	public ArrayList<TradePost> getTradePostList() {
		ArrayList<TradePost> list = null;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		list = tpDao.getTradePostList(conn);
		close(conn);
		return list;
	}

	public ArrayList<TradePost> getTradePostListFilter() {
		ArrayList<TradePost> list = null;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		list = tpDao.getTradePostListFilter(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<TradePost> getMyTradePostList(String userId) {
		ArrayList<TradePost> list = null;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		list = tpDao.getMyTradePostList(conn, userId);
		close(conn);
		return list;
	}
	
	public int insertTradePost(int memberSeq, TradePost standardPost) {
		int result = 0;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		result = tpDao.insertTradePost(conn, memberSeq, standardPost);
		close(conn);
		return result;
	}
	
	public int updateTradePost(int memberSeq, TradePost tradePost) {
		int result = 0;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		result = tpDao.updateTradePost(conn, memberSeq, tradePost);
		close(conn);
		return result;
	}
	
	public TradePost selectTradePost(int postSeq) {
		// TODO Auto-generated method stub
		TradePost sp = null;
		Connection conn = getConnection();

		sp = tpDao.selectTradePost(conn, postSeq);
		close(conn);
		return sp;
	}
	
	public int deleteTradePost(int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = getConnection();

		result = tpDao.deleteTradePost(conn, memberSeq, postSeq);
		close(conn);
		return result;
	}
	
	public int updateTradePostLikeNo(int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = getConnection();

		result = tpDao.updateTradePostLikeNo(conn, memberSeq, postSeq);
		close(conn);
		return result;
	}
	
	public int getTradePostLikeNo(int postSeq){
		// TODO Auto-generated method stub
		int tradePostLikeNo = 0;
		Connection conn = getConnection();
		tradePostLikeNo = tpDao.getTradePostLikeNo(conn, postSeq);
		
		close(conn);
		return tradePostLikeNo;
	}
}	

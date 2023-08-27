package tradepost.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import tradepost.model.vo.TradePost;

public class TradePostDao {
	public TradePostDao () {}

	public int getTradePostListCount(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<TradePost> getTradePostList(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TradePost> getTradePostListFilter(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TradePost> getMyTradePostList(Connection conn, String myId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertTradePost(Connection conn, int memberSeq, TradePost standardPost) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateTradePost(Connection conn, int memberSeq, TradePost tradePost) {
		// TODO Auto-generated method stub
		return 0;
	}

	public TradePost selectTradePost(Connection conn, int postSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteTradePost(Connection conn, int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateTradePostLikeNo(Connection conn, int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTradePostLikeNo(Connection conn, int postSeq) {
		// TODO Auto-generated method stub
		return 0;
	}
}

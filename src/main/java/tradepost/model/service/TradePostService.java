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
}	

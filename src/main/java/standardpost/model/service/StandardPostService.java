package standardpost.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import standardpost.model.dao.StandardPostDao;
import standardpost.model.vo.StandardPost;

public class StandardPostService {
	private StandardPostDao spDao = new StandardPostDao();

	public StandardPostService() {
	}

	public int getStandardPostListCount() {
		int count = 0;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		count = spDao.getStandardPostListCount(conn);
		close(conn);
		return count;
	}

	public ArrayList<StandardPost> getStandardPostList() {
		ArrayList<StandardPost> list = null;
		Connection conn = getConnection();

		list = spDao.getStandardPostList(conn);
		close(conn);
		return list;
	}

	public ArrayList<StandardPost> getStandardPostListFilter() {
		ArrayList<StandardPost> list = null;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		list = spDao.getStandardPostListFilter(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<StandardPost> getMyStandardPostList(String userId) {
		ArrayList<StandardPost> list = null;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		list = spDao.getMyStandardPostList(conn, userId);
		close(conn);
		return list;
	}
	
	public int insertStandardPost(int memberSeq, StandardPost standardPost) {
		int result = 0;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		result = spDao.insertStandardPost(conn, memberSeq, standardPost);
		close(conn);
		return result;
	}
	
	public int updateStandardPost(int memberSeq, StandardPost standardPost) {
		int result = 0;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		result = spDao.updateStandardPost(conn, memberSeq, standardPost);
		close(conn);
		return result;
	}
	
	public StandardPost selectStandardPost(int postSeq) {
		// TODO Auto-generated method stub
		StandardPost sp = null;
		Connection conn = getConnection();

		sp = spDao.selectStandardPost(conn, postSeq);
		close(conn);
		return sp;
	}
	
	public int deleteStrandardPost(int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = getConnection();

		result = spDao.deleteStrandardPost(conn, memberSeq, postSeq);
		close(conn);
		return result;
	}
	
	public int updateStandardPostLikeNo(int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = getConnection();

		result = spDao.updateStandardPostLikeNo(conn, memberSeq, postSeq);
		close(conn);
		return result;
	}
	
	public int getStandardPostLikeNo(int postSeq){
		// TODO Auto-generated method stub
		int tradePostLikeNo = 0;
		Connection conn = getConnection();
		tradePostLikeNo = spDao.getStandardPostLikeNo(conn, postSeq);
		
		close(conn);
		return tradePostLikeNo;
	}
}

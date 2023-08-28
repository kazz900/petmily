package standardpost.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import standardpost.model.vo.StandardPost;

public class StandardPostDao {
	public StandardPostDao () {}

	public int getStandardPostListCount(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<StandardPost> getStandardPostList(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<StandardPost> getStandardPostListFilter(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertStandardPost(Connection conn, int memberSeq, StandardPost standardPost) {
		// TODO Auto-generated method stub
		return 0;
	}

	public StandardPost selectStandardPost(Connection conn, int postSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<StandardPost> getMyStandardPostList(Connection conn, String myId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateStandardPost(Connection conn, int memberSeq, StandardPost standardPost) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteStrandardPost(Connection conn, int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateStandardPostLikeNo(Connection conn, int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getStandardPostLikeNo(Connection conn, int postSeq) {
		// TODO Auto-generated method stub
		return 0;
	}
}

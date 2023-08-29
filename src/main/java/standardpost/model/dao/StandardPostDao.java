package standardpost.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static common.JDBCTemplate.close;

import standardpost.model.vo.StandardPost;

public class StandardPostDao {
	public StandardPostDao () {}

	public int getStandardPostListCount(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<StandardPost> getStandardPostList(Connection conn) {
		ArrayList<StandardPost> list = new ArrayList<StandardPost>();
		PreparedStatement pstmt = null;
		ResultSet rest = null;
		
		String query = "SELECT *\r\n"
				+ "FROM \r\n"
				+ "    (SELECT\r\n"
				+ "        POST_CONTENT,\r\n"
				+ "        MEMBER_ID,\r\n"
				+ "        LIKE_NO,\r\n"
				+ "        REPLY_NO, \r\n"
				+ "        POST_DATE,\r\n"
				+ "        LAST_MODIFIED_DATE,\r\n"
				+ "        ROWNUM RNUM\r\n"
				+ "         FROM STANDARD_POST\r\n"
				+ "        JOIN MEMBER USING (MEMBER_SEQ)\r\n"
				+ "        ORDER BY POST_DATE DESC)\r\n"
				+ "WHERE RNUM <= 5";
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rest, pstmt);
		}
		
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

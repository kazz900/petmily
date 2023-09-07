package standardpost.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		ResultSet rset = null;
		
		String query = "SELECT *\r\n"
				+ "FROM \r\n"
				+ "    (SELECT\r\n"
				+ "        MEMBER_SEQ,\r\n"
				+ "        POST_SEQ,\r\n"
				+ "        MEMBER_ID,\r\n"
				+ "        POST_CONTENT,\r\n"
				+ "        LIKE_NO,\r\n"
				+ "        REPLY_NO, \r\n"
				+ "        POST_DATE,\r\n"
				+ "        LAST_MODIFIED_DATE,\r\n"
				+ "        ROWNUM RNUM\r\n"
				+ "         FROM STANDARD_POST\r\n"
				+ "        JOIN MEMBER USING (MEMBER_SEQ)\r\n"
				+ "        ORDER BY POST_DATE DESC)\r\n";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				StandardPost sp = new StandardPost();
				sp.setMemberSeq(rset.getInt("MEMBER_SEQ"));
				sp.setPostSeq(rset.getInt("POST_SEQ"));
				sp.setMemberId(rset.getString("MEMBER_ID"));
				sp.setPostContent(rset.getString("POST_CONTENT"));
				sp.setLikeNo(rset.getInt("LIKE_NO"));
				sp.setReplyNO(rset.getInt("REPLY_NO"));
				sp.setPostDate(rset.getDate("POST_DATE"));
				sp.setLastModifiedDate(rset.getDate("LAST_MODIFIED_DATE"));

				list.add(sp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset, pstmt);
		}
		
		return list;
	}

	public ArrayList<StandardPost> getStandardPostListFilter(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertStandardPost(Connection conn, int memberSeq, StandardPost standardPost) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String query = "INSERT INTO STANDARD_POST (POST_SEQ, MEMBER_SEQ, POST_CONTENT) VALUES (POST_SEQ.NEXTVAL, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberSeq);
			pstmt.setString(2, standardPost.getPostContent());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
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
		// TODO : ADD MEMBER VALDIATION 
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM STANDARD_POST WHERE POST_SEQ = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postSeq);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
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

package post.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import post.model.vo.Post;
import standardpost.model.vo.StandardPost;
import tradepost.model.vo.TradePost;

public class PostDao {
	public PostDao () {
		super();
	}

	public int getPostListCount(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Post> getPostList(Connection conn) {
		ArrayList<Post> list = new ArrayList<Post>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String getStandardPostQuery = "SELECT "
				+ "MEMBER_ID, "
				+ "POST_SEQ, "
				+ "MEMBER_SEQ, "
				+ "POST_CONTENT, "
				+ "POST_IMG, "
				+ "LIKE_NO, "
				+ "REPLY_NO, "
				+ "POST_DATE, "
				+ "LAST_MODIFIED_DATE, "
				+ "TRADE_RESULT, "
				+ "ORIGINAL_FILE_NAME,  "
				+ "RENAME_FILE_NAME  "
				+ "FROM STANDARD_POST "
				+ "JOIN MEMBER USING (MEMBER_SEQ)";
		
		String getTradePostQuery = "SELECT "
				+ "MEMBER_ID, "
				+ "POST_SEQ, "
				+ "MEMBER_SEQ, "
				+ "POST_CONTENT, "
				+ "POST_IMG, "
				+ "LIKE_NO, "
				+ "REPLY_NO, "
				+ "POST_DATE, "
				+ "LAST_MODIFIED_DATE, "
				+ "TRADE_RESULT, "
				+ "ORIGINAL_FILE_NAME,  "
				+ "RENAME_FILE_NAME  "
				+ "FROM TRADE_POST "
				+ "JOIN MEMBER USING (MEMBER_SEQ)";
		
		try {
			// Get all StandardPost from DB
			pstmt = conn.prepareStatement(getStandardPostQuery);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				StandardPost sp = new StandardPost();
				sp.setMemberId(rset.getString("MEMBER_ID"));
				sp.setPostSeq(rset.getInt("POST_SEQ"));
				sp.setMemberSeq(rset.getInt("MEMBER_SEQ"));
				sp.setPostContent(rset.getString("POST_CONTENT"));
				sp.setPostImg(rset.getString("POST_IMG"));
				sp.setLikeNo(rset.getInt("LIKE_NO"));
				sp.setReplyNO(rset.getInt("REPLY_NO"));
				sp.setPostDate(rset.getDate("POST_DATE"));
				sp.setLastModifiedDate(rset.getDate("LAST_MODIFIED_DATE"));
				sp.setTradeResult(rset.getString("TRADE_RESULT"));
				sp.setOriginalFileName(rset.getString("ORIGINAL_FILE_NAME"));
				sp.setChangedFileName(rset.getString("RENAME_FILE_NAME"));
				list.add(sp);
			}
			
			pstmt = null;
			rset = null;
			
			// Get all TradePost from DB
			pstmt = conn.prepareStatement(getTradePostQuery);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				TradePost tp = new TradePost();
				tp.setMemberId(rset.getString("MEMBER_ID"));
				tp.setPostSeq(rset.getInt("POST_SEQ"));
				tp.setMemberSeq(rset.getInt("MEMBER_SEQ"));
				tp.setPostContent(rset.getString("POST_CONTENT"));
				tp.setPostImg(rset.getString("POST_IMG"));
				tp.setLikeNo(rset.getInt("LIKE_NO"));
				tp.setReplyNO(rset.getInt("REPLY_NO"));
				tp.setPostDate(rset.getDate("POST_DATE"));
				tp.setLastModifiedDate(rset.getDate("LAST_MODIFIED_DATE"));
				tp.setTradeResult(rset.getString("TRADE_RESULT"));
				tp.setOriginalFileName(rset.getString("ORIGINAL_FILE_NAME"));
				tp.setChangedFileName(rset.getString("RENAME_FILE_NAME"));
				list.add(tp);
			}
			list.sort((p1 , p2) -> p2.getPostDate().compareTo(p1.getPostDate()) );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset, pstmt);
		}
		
		return list;
	}

	public ArrayList<Post> getPostListFilter(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Post> getMyPostList(Connection conn, int userId) {
		ArrayList<Post> list = new ArrayList<Post>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String getStandardPostQuery = "SELECT "
				+ "MEMBER_ID, "
				+ "POST_SEQ, "
				+ "MEMBER_SEQ, "
				+ "POST_CONTENT, "
				+ "POST_IMG, "
				+ "LIKE_NO, "
				+ "REPLY_NO, "
				+ "POST_DATE, "
				+ "LAST_MODIFIED_DATE, "
				+ "TRADE_RESULT, "
				+ "ORIGINAL_FILE_NAME,  "
				+ "RENAME_FILE_NAME  "
				+ "FROM STANDARD_POST "
				+ "JOIN MEMBER USING (MEMBER_SEQ) "
				+ "WHERE MEMBER_SEQ = ? ";
		
		String getTradePostQuery = "SELECT "
				+ "MEMBER_ID, "
				+ "POST_SEQ, "
				+ "MEMBER_SEQ, "
				+ "POST_CONTENT, "
				+ "POST_IMG, "
				+ "LIKE_NO, "
				+ "REPLY_NO, "
				+ "POST_DATE, "
				+ "LAST_MODIFIED_DATE, "
				+ "TRADE_RESULT, "
				+ "ORIGINAL_FILE_NAME,  "
				+ "RENAME_FILE_NAME  "
				+ "FROM TRADE_POST "
				+ "JOIN MEMBER USING (MEMBER_SEQ)"
				+ "WHERE MEMBER_SEQ = ? ";
		
		try {
			// Get all StandardPost from DB
			pstmt = conn.prepareStatement(getStandardPostQuery);
			pstmt.setInt(1, userId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				StandardPost sp = new StandardPost();
				sp.setMemberId(rset.getString("MEMBER_ID"));
				sp.setPostSeq(rset.getInt("POST_SEQ"));
				sp.setMemberSeq(rset.getInt("MEMBER_SEQ"));
				sp.setPostContent(rset.getString("POST_CONTENT"));
				sp.setPostImg(rset.getString("POST_IMG"));
				sp.setLikeNo(rset.getInt("LIKE_NO"));
				sp.setReplyNO(rset.getInt("REPLY_NO"));
				sp.setPostDate(rset.getDate("POST_DATE"));
				sp.setLastModifiedDate(rset.getDate("LAST_MODIFIED_DATE"));
				sp.setTradeResult(rset.getString("TRADE_RESULT"));
				sp.setOriginalFileName(rset.getString("ORIGINAL_FILE_NAME"));
				sp.setChangedFileName(rset.getString("RENAME_FILE_NAME"));
				list.add(sp);
			}
			
			pstmt = null;
			rset = null;
			 
			// Get all TradePost from DB
			pstmt = conn.prepareStatement(getTradePostQuery);
			pstmt.setInt(1, userId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				TradePost tp = new TradePost();
				tp.setMemberId(rset.getString("MEMBER_ID"));
				tp.setPostSeq(rset.getInt("POST_SEQ"));
				tp.setMemberSeq(rset.getInt("MEMBER_SEQ"));
				tp.setPostContent(rset.getString("POST_CONTENT"));
				tp.setPostImg(rset.getString("POST_IMG"));
				tp.setLikeNo(rset.getInt("LIKE_NO"));
				tp.setReplyNO(rset.getInt("REPLY_NO"));
				tp.setPostDate(rset.getDate("POST_DATE"));
				tp.setLastModifiedDate(rset.getDate("LAST_MODIFIED_DATE"));
				tp.setTradeResult(rset.getString("TRADE_RESULT"));
				tp.setOriginalFileName(rset.getString("ORIGINAL_FILE_NAME"));
				tp.setChangedFileName(rset.getString("RENAME_FILE_NAME"));
				list.add(tp);
			}
			
			list.sort((p1 , p2) -> p2.getPostDate().compareTo(p1.getPostDate()) );
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset, pstmt);
		}
		
		return list;
	}

	public int insertPost(Connection conn, int memberSeq, Post post) {
		int result = 0;
		String query = "";
		PreparedStatement pstmt = null;
		
		if(post instanceof StandardPost) {
			query = "INSERT INTO STANDARD_POST "
					+ "(POST_SEQ, MEMBER_SEQ, POST_CONTENT, ORIGINAL_FILE_NAME, RENAME_FILE_NAME) "
					+ "VALUES (POST_SEQ.NEXTVAL, ?, ?, ?, ?)";
		}else {
			query = "INSERT INTO TRADE_POST "
					+ "(POST_SEQ, MEMBER_SEQ, POST_CONTENT, ORIGINAL_FILE_NAME, RENAME_FILE_NAME) "
					+ "VALUES (POST_SEQ.NEXTVAL, ?, ?, ?, ?)";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberSeq);
			pstmt.setString(2, post.getPostContent());
			pstmt.setString(3, post.getOriginalFileName());
			pstmt.setString(4, post.getChangedFileName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePost(Connection conn, int memberSeq, Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	public StandardPost selectPost(Connection conn, int postSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deletePost(Connection conn, int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updatePostLikeNo(Connection conn, int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getPostLikeNo(Connection conn, int postSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Post> getPostListByType(Connection conn, String postType) {
		ArrayList<Post> list = new ArrayList<Post>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "";
		if(postType.equals("standardpost")) {
			query = "SELECT "
					+ "MEMBER_ID, "
					+ "POST_SEQ, "
					+ "MEMBER_SEQ, "
					+ "POST_CONTENT, "
					+ "POST_IMG, "
					+ "LIKE_NO, "
					+ "REPLY_NO, "
					+ "POST_DATE, "
					+ "LAST_MODIFIED_DATE, "
					+ "TRADE_RESULT, "
					+ "ORIGINAL_FILE_NAME,  "
					+ "RENAME_FILE_NAME  "
					+ "FROM STANDARD_POST "
					+ "JOIN MEMBER USING (MEMBER_SEQ) ";
		}else {
			query = "SELECT "
					+ "MEMBER_ID, "
					+ "POST_SEQ, "
					+ "MEMBER_SEQ, "
					+ "POST_CONTENT, "
					+ "POST_IMG, "
					+ "LIKE_NO, "
					+ "REPLY_NO, "
					+ "POST_DATE, "
					+ "LAST_MODIFIED_DATE, "
					+ "TRADE_RESULT, "
					+ "ORIGINAL_FILE_NAME,  "
					+ "RENAME_FILE_NAME  "
					+ "FROM TRADE_POST "
					+ "JOIN MEMBER USING (MEMBER_SEQ)";
		}
		
		try {
			// Get all StandardPost from DB
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(postType.equals("standardpost")) {
				while(rset.next()) {
					StandardPost sp = new StandardPost();
					sp.setMemberId(rset.getString("MEMBER_ID"));
					sp.setPostSeq(rset.getInt("POST_SEQ"));
					sp.setMemberSeq(rset.getInt("MEMBER_SEQ"));
					sp.setPostContent(rset.getString("POST_CONTENT"));
					sp.setPostImg(rset.getString("POST_IMG"));
					sp.setLikeNo(rset.getInt("LIKE_NO"));
					sp.setReplyNO(rset.getInt("REPLY_NO"));
					sp.setPostDate(rset.getDate("POST_DATE"));
					sp.setLastModifiedDate(rset.getDate("LAST_MODIFIED_DATE"));
					sp.setTradeResult(rset.getString("TRADE_RESULT"));
					sp.setOriginalFileName(rset.getString("ORIGINAL_FILE_NAME"));
					sp.setChangedFileName(rset.getString("RENAME_FILE_NAME"));
					list.add(sp);
				}
			} else {
				while(rset.next()) {
					TradePost tp = new TradePost();
					tp.setMemberId(rset.getString("MEMBER_ID"));
					tp.setPostSeq(rset.getInt("POST_SEQ"));
					tp.setMemberSeq(rset.getInt("MEMBER_SEQ"));
					tp.setPostContent(rset.getString("POST_CONTENT"));
					tp.setPostImg(rset.getString("POST_IMG"));
					tp.setLikeNo(rset.getInt("LIKE_NO"));
					tp.setReplyNO(rset.getInt("REPLY_NO"));
					tp.setPostDate(rset.getDate("POST_DATE"));
					tp.setLastModifiedDate(rset.getDate("LAST_MODIFIED_DATE"));
					tp.setTradeResult(rset.getString("TRADE_RESULT"));
					tp.setOriginalFileName(rset.getString("ORIGINAL_FILE_NAME"));
					tp.setChangedFileName(rset.getString("RENAME_FILE_NAME"));
					list.add(tp);
				}
			}
			
			list.sort((p1 , p2) -> p2.getPostDate().compareTo(p1.getPostDate()) );
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset, pstmt);
		}
		return list;
	}
}

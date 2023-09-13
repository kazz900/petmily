package post.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import post.model.vo.Post;
import standardpost.model.vo.StandardPost;
import tradepost.model.vo.TradePost;

public class PostDao {
	public PostDao () {
		super();
	}

	public ArrayList<Post> getPostList(Connection conn) {
		ArrayList<Post> list = new ArrayList<Post>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String getStandardPostQuery = "SELECT "
				+ "MEMBER_ID, "
				+ "POST_SEQ, "
				+ "MEMBER_SEQ, "
				+ "MEMBER_NICK, "
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
				+ "MEMBER_NICK, "
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
				sp.setMemberNick(rset.getString("MEMBER_NICK"));
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
				tp.setMemberNick(rset.getString("MEMBER_NICK"));
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

	public ArrayList<Post> getMyPostList(Connection conn, int userId) {
		ArrayList<Post> list = new ArrayList<Post>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String getStandardPostQuery = "SELECT "
				+ "MEMBER_ID, "
				+ "POST_SEQ, "
				+ "MEMBER_SEQ, "
				+ "MEMBER_NICK, "
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
				+ "MEMBER_NICK, "
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
				sp.setMemberNick(rset.getString("MEMBER_NICK"));
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
				tp.setMemberNick(rset.getString("MEMBER_NICK"));
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
			
			list.sort((p1 , p2) -> p2.getPostDate().compareTo(p1.getPostDate()));
			
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
		int result = 0;
		String query = "";
		PreparedStatement pstmt = null;
		
		if(post instanceof StandardPost) {
			if(post.getOriginalFileName() != null) {
				query = "UPDATE STANDARD_POST "
						+ "SET "
						+ "POST_CONTENT = ?, "
						+ "ORIGINAL_FILE_NAME = ?, "
						+ "RENAME_FILE_NAME = ?, "
						+ "LAST_MODIFIED_DATE = SYSDATE "
						+ "WHERE POST_SEQ = ? ";				
			} else {
				query = "UPDATE STANDARD_POST "
						+ "SET "
						+ "POST_CONTENT = ?, "
						+ "LAST_MODIFIED_DATE = SYSDATE "
						+ "WHERE POST_SEQ = ? ";
			}
		} else {
			if(post.getOriginalFileName() != null) {
				query = "UPDATE TRADE_POST "
						+ "SET "
						+ "POST_CONTENT = ?, "
						+ "ORIGINAL_FILE_NAME = ?, "
						+ "RENAME_FILE_NAME = ?, "
						+ "LAST_MODIFIED_DATE = SYSDATE "
						+ "WHERE POST_SEQ = ? ";				
			} else {
				query = "UPDATE TRADE_POST "
						+ "SET "
						+ "POST_CONTENT = ?, "
						+ "LAST_MODIFIED_DATE = SYSDATE "
						+ "WHERE POST_SEQ = ? ";
			}
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(post.getOriginalFileName() != null) {
				pstmt.setString(1, post.getPostContent());
				pstmt.setString(2, post.getOriginalFileName());
				pstmt.setString(3, post.getChangedFileName());
				pstmt.setInt(4, post.getPostSeq());
			} else {
				pstmt.setString(1, post.getPostContent());
				pstmt.setInt(2, post.getPostSeq());
			}
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Post> getPostListByType(Connection conn, String postType) {
		ArrayList<Post> list = new ArrayList<Post>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "";
		if(postType.equals("standardpost")) {
			query = "SELECT "
					+ "MEMBER_ID, "
					+ "MEMBER_NICK, "
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
					+ "MEMBER_NICK, "
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
					sp.setMemberNick(rset.getString("MEMBER_NICK"));
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
					tp.setMemberNick(rset.getString("MEMBER_NICK"));
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

	public int deleteImage(Connection conn, Post post) {
		int result = 0;
		String query = "";
		PreparedStatement pstmt = null;
		
		if(post instanceof StandardPost) {
			query = "UPDATE STANDARD_POST "
					+ "SET "
					+ "ORIGINAL_FILE_NAME = DEFAULT, "
					+ "RENAME_FILE_NAME = DEFAULT "
					+ "WHERE POST_SEQ = ? ";
		} else {
			query = "UPDATE TRADE_POST "
					+ "SET "
					+ "ORIGINAL_FILE_NAME = DEFAULT, "
					+ "RENAME_FILE_NAME = DEFAULT "
					+ "WHERE POST_SEQ = ? ";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, post.getPostSeq());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public void syso () {
		System.out.println();
		//asdf
		//asdfasdfasdf
	}

	public int deletePost(Connection conn, Post post) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		if(post instanceof StandardPost) {
			query = "DELETE FROM STANDARD_POST WHERE POST_SEQ = ?";			
		}else {
			query = "DELETE FROM TRADE_POST WHERE POST_SEQ = ?";	
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, post.getPostSeq());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Post> getPostListSortByPopularity(Connection conn) {
		ArrayList<Post> list = new ArrayList<Post>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String getStandardPostQuery = "SELECT "
				+ "MEMBER_ID, "
				+ "POST_SEQ, "
				+ "MEMBER_SEQ, "
				+ "MEMBER_NICK, "
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
		
		String getTradePostQuery = "SELECT "
				+ "MEMBER_ID, "
				+ "POST_SEQ, "
				+ "MEMBER_SEQ, "
				+ "MEMBER_NICK, "
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
				sp.setMemberNick(rset.getString("MEMBER_NICK"));
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
				tp.setMemberNick(rset.getString("MEMBER_NICK"));
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
			
			list.sort((p1 , p2) -> p2.getLikeNo() - p1.getLikeNo() );
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset, pstmt);
		}
		
		return list;
	}

	public int checkIfTypeChanged(Connection conn, int postSeq, String postType) {
		int result = 0;
		String query = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// post type이 일반 게시글이라면 
		// 일반게시글 테이블에 postSeq 존재하는지 확인
		if(postType.equals("standardpost")) {
			query = "SELECT * FROM TRADE_POST WHERE POST_SEQ = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, postSeq);
				rset = pstmt.executeQuery();
				// POST TYPE이 standardpost이면 TRADE POST table에 post seq가 존재하는지 확인
				// TRADE POST TABLE에 POST SEQ가 존재한다면 타입이 변경되지 않았음을 의미
				// result가 1이면 타입이 변경되지 않은것이고 0이면 타입이 변경되었다는 의미
				if(rset.next()) {
					result = 1;
				}else {
					result = 0;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset, pstmt);
			}
		}else {
			query = "SELECT * FROM STANDARD_POST WHERE POST_SEQ = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, postSeq);
				rset = pstmt.executeQuery();
				// POST TYPE이 tradepost이면 STANDARD POST table에 post seq가 존재하는지 확인
				// STANARD_POST TABLE에 POST SEQ가 있다면 타입이 변경되지 않았음을 의미
				// result가 1이면 타입이 변경되지 않은것이고 0이면 타입이 변경되었다는 의미
				if(rset.next()) {
					result = 1;
				}else {
					result = 0;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset, pstmt);
			}
		}
		return result;
	}

	public Post selectPost(Connection conn, int postSeq, String postType) {
		Post p = new Post();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "";
		
		if(postType.equals("standardpost")) {
			query = "SELECT "
					+ "MEMBER_ID, "
					+ "POST_SEQ, "
					+ "MEMBER_SEQ, "
					+ "MEMBER_NICK, "
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
					+ "JOIN MEMBER USING (MEMBER_SEQ) "
					+ "WHERE POST_SEQ = ? ";
		}else {
			query = "SELECT "
					+ "MEMBER_ID, "
					+ "POST_SEQ, "
					+ "MEMBER_SEQ, "
					+ "MEMBER_NICK, "
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
					+ "JOIN MEMBER USING (MEMBER_SEQ)"
					+ "WHERE POST_SEQ = ? ";
		}
		
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postSeq);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				if(postType.equals("standardpost")) {
					p = new StandardPost();
				}else {
					p = new TradePost();
				}
				p.setMemberId(rset.getString("MEMBER_ID"));
				p.setPostSeq(rset.getInt("POST_SEQ"));
				p.setMemberSeq(rset.getInt("MEMBER_SEQ"));
				p.setMemberNick(rset.getString("MEMBER_NICK"));
				p.setPostContent(rset.getString("POST_CONTENT"));
				p.setPostImg(rset.getString("POST_IMG"));
				p.setLikeNo(rset.getInt("LIKE_NO"));
				p.setReplyNO(rset.getInt("REPLY_NO"));
				p.setPostDate(rset.getDate("POST_DATE"));
				p.setLastModifiedDate(rset.getDate("LAST_MODIFIED_DATE"));
				p.setTradeResult(rset.getString("TRADE_RESULT"));
				p.setOriginalFileName(rset.getString("ORIGINAL_FILE_NAME"));
				p.setChangedFileName(rset.getString("RENAME_FILE_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset, pstmt);
		}
		
		return p;
	}
}

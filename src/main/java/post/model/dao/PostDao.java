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
		
		String getStandardPostQuery = "SELECT\r\n"
				+ "MEMBER_ID,\r\n"
				+ "POST_SEQ,\r\n"
				+ "MEMBER_SEQ,\r\n"
				+ "POST_CONTENT,\r\n"
				+ "POST_IMG,\r\n"
				+ "LIKE_NO,\r\n"
				+ "REPLY_NO,\r\n"
				+ "POST_DATE,\r\n"
				+ "LAST_MODIFIED_DATE,\r\n"
				+ "TRADE_RESULT\r\n"
				+ "FROM STANDARD_POST\r\n"
				+ "JOIN MEMBER USING (MEMBER_SEQ)";
		
		String getTradePostQuery = "SELECT\r\n"
				+ "MEMBER_ID,\r\n"
				+ "POST_SEQ,\r\n"
				+ "MEMBER_SEQ,\r\n"
				+ "POST_CONTENT,\r\n"
				+ "POST_IMG,\r\n"
				+ "LIKE_NO,\r\n"
				+ "REPLY_NO,\r\n"
				+ "POST_DATE,\r\n"
				+ "LAST_MODIFIED_DATE,\r\n"
				+ "TRADE_RESULT\r\n"
				+ "FROM TRADE_POST\r\n"
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

	public ArrayList<Post> getMyPostList(Connection conn, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertPost(Connection conn, int memberSeq, Post post) {
		// TODO Auto-generated method stub
		return 0;
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

}

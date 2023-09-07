package reply.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import post.model.vo.Post;
import reply.model.vo.Reply;
import standardpost.model.vo.StandardPost;
import tradepost.model.vo.TradePost;

public class ReplyDao {

	public ReplyDao() {}

	public int insertReply(Connection conn, Reply reply) {
		int result = 0;
		String query = "INSERT INTO REPLY (REPLY_SEQ, POST_SEQ, MEMBER_SEQ, REPLY_CONTENT)"
				+ " VALUES(REPLY_SEQ.NEXTVAL, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reply.getPostSeq());
			pstmt.setInt(2, reply.getMemberSeq());
			pstmt.setString(3, reply.getReplyContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Reply> getReplyList(Connection conn) {
		ArrayList<Reply> rList = new ArrayList<Reply>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT "
				+ "REPLY_SEQ, "
				+ "POST_SEQ, "
				+ "MEMBER_SEQ, "
				+ "MEMBER_ID, "
				+ "MEMBER_NICK, "
				+ "REPLY_CONTENT, "
				+ "REPLY_DATE "
				+ "FROM REPLY "
				+ "JOIN MEMBER USING (MEMBER_SEQ)";
		
		try {
			// Get all StandardPost from DB
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Reply r = new Reply();
				r.setReplySeq(rset.getInt("REPLY_SEQ"));
				r.setPostSeq(rset.getInt("POST_SEQ"));
				r.setMemberSeq(rset.getInt("MEMBER_SEQ"));
				r.setMemberNick(rset.getString("MEMBER_NICK"));
				r.setMemberId(rset.getString("MEMBER_ID"));
				r.setReplyContent(rset.getString("REPLY_CONTENT"));
				r.setReplyDate(rset.getDate("REPLY_DATE"));
				rList.add(r);
			}
			
			rList.sort((p1 , p2) -> p1.getReplyDate().compareTo(p2.getReplyDate()));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset, pstmt);
		}
		
		return rList;
	}

	public int deleteReply(Connection conn, int replySeq) {
		int result = 0;
		String query = "DELETE FROM REPLY "
				+ "WHERE REPLY_SEQ = ?";
		PreparedStatement pstmt = null;
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, replySeq);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}

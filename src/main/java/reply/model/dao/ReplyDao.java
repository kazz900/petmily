package reply.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import post.model.vo.Post;
import reply.model.vo.Reply;
import standardpost.model.vo.StandardPost;
import standardreply.model.vo.StandardReply;
import tradepost.model.vo.TradePost;

public class ReplyDao {

	public ReplyDao() {}

	public int insertReply(Connection conn, int postSeq, StandardReply standardReply) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteReply(Connection conn, int postSeq, int replySeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Reply> getReplyList(Connection conn) {
		ArrayList<Reply> rList = new ArrayList<Reply>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT \r\n"
				+ "REPLY_SEQ,\r\n"
				+ "POST_SEQ,\r\n"
				+ "MEMBER_SEQ,\r\n"
				+ "REPLY_CONTENT,\r\n"
				+ "REPLY_DATE\r\n"
				+ "FROM REPLY";
		
		try {
			// Get all StandardPost from DB
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Reply r = new Reply();
				r.setReplySeq(rset.getInt("REPLY_SEQ"));
				r.setPostSeq(rset.getInt("POST_SEQ"));
				r.setMemberSeq(rset.getInt("MEMBER_SEQ"));
				r.setReplyContent(rset.getString("REPLY_CONTENT"));
				r.setReplyDate(rset.getDate("REPLY_DATE"));
				rList.add(r);
				System.out.println(r.toString());
			}
			
			rList.sort((p1 , p2) -> p2.getReplyDate().compareTo(p1.getReplyDate()));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset, pstmt);
		}
		
		return rList;
	}
}
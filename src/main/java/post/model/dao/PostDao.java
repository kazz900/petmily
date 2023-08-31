package post.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import post.model.vo.Post;
import standardpost.model.vo.StandardPost;

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
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		String query = "SELECT *\r\n"
//				+ "FROM \r\n"
//				+ "    (SELECT\r\n"
//				+ "        MEMBER_SEQ,\r\n"
//				+ "        POST_SEQ,\r\n"
//				+ "        MEMBER_ID,\r\n"
//				+ "        POST_CONTENT,\r\n"
//				+ "        LIKE_NO,\r\n"
//				+ "        REPLY_NO, \r\n"
//				+ "        POST_DATE,\r\n"
//				+ "        LAST_MODIFIED_DATE,\r\n"
//				+ "        TRADE_RESULT\r\n"
//				+ "        FROM STANDARD_POST\r\n"
//				+ "        FULL OUTER JOIN TRADE_POST USING (POST_SEQ)\r\n"
//				+ "        JOIN MEMBER USING (MEMBER_SEQ)\r\n"
//				+ "        ORDER BY POST_DATE DESC)\r\n";
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			rset = pstmt.executeQuery();
//			
//			while(rset.next()) {
//				Post sp = new Post();
//				sp.setMemberSeq(rset.getInt("MEMBER_SEQ"));
//				sp.setPostSeq(rset.getInt("POST_SEQ"));
//				sp.setMemberId(rset.getString("MEMBER_ID"));
//				sp.setPostContent(rset.getString("POST_CONTENT"));
//				sp.setLikeNo(rset.getInt("LIKE_NO"));
//				sp.setReplyNO(rset.getInt("REPLY_NO"));
//				sp.setPostDate(rset.getDate("POST_DATE"));
//				sp.setLastModifieddate(rset.getDate("LAST_MODIFIED_DATE"));
//				System.out.println(sp.toString());
//				list.add(sp);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(rset, pstmt);
//		}
//		
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

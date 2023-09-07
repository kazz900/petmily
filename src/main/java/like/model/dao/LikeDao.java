package like.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import like.model.vo.Like;

public class LikeDao {

	public int updateLike(Connection conn, Like l, String postType) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String checkIfLiked = "SELECT * FROM LIKES WHERE LIKE_KEY = ?";
		
		try {
			pstmt = conn.prepareStatement(checkIfLiked);
			pstmt.setString(1, l.getLikeKey());
			rset = pstmt.executeQuery();
			
			// like key 이용해서 이미 좋아한적이 있는지 확인
			// RSET 존재한다면 좋아한적 있는것임
			if(rset.next()) {
				result = 0;
			}else {
				String query = "INSERT INTO LIKES "
						+ " VALUES(?, ?, ?)";
				
				// LIKES TABLE에 이미 똑같은 게시글을 좋아요 한적이 있는지 확인
				// 그냥 INSERT해서 확인함
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, l.getLikeKey());
				pstmt.setInt(2, l.getPostSeq());
				pstmt.setInt(3, l.getMemberSeq());
				result = pstmt.executeUpdate();
				
				
				if(result > 0) {
					pstmt = null;
					// 좋아한 게시글이 일반 게시글이라면
					if(postType.equals("standardpost")) {
						query = "UPDATE STANDARD_POST "
								+ "SET LIKE_NO = LIKE_NO + 1"
								+ "WHERE POST_SEQ = ? ";
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, l.getPostSeq());
						pstmt.executeUpdate();
					} else {
						// 좋아한 게시글이 중고거래글이라면
						query = "UPDATE TRADE_POST "
								+ "SET LIKE_NO = LIKE_NO + 1"
								+ "WHERE POST_SEQ = ? ";
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, l.getPostSeq());
						pstmt.executeUpdate();
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}

package servicecenter.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

import servicecenter.model.vo.Board;

public class BoardDao implements Serializable {

	private static final long serialVersionUID = -6193829464532553691L;

	public int addMySuggest(Connection conn, Board board) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO SERV_CENTER "
					 + "VALUES (TO_CHAR(SERV_SEQ.NEXTVAL), "
					 + "7, ?, ?, SYSDATE, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
// 값 받아서 하는거로 수정
//			pstmt.setInt(1, board.getBrdMemberNo());
			pstmt.setString(1, board.getBrdTitle());
			pstmt.setString(2, board.getBrdContent());
			pstmt.setString(3, board.getBrdResult());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> selectAllSuggest(Connection conn) {
		ArrayList<Board> list = new ArrayList<Board>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * "
					 + "FROM SERV_CENTER "
					 + "ORDER BY SERV_SEQ DESC";

		try {

			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			while (rset.next()) {

				Board board = new Board();

				board.setBrdNo(rset.getInt("SERV_SEQ"));
				board.setBrdMemberNo(rset.getInt("MEMBER_SEQ"));
				board.setBrdTitle(rset.getString("TITLE"));
				board.setBrdContent(rset.getString("CONTENT"));
				board.setBrdDate(rset.getDate("UPLOAD_DATE"));
				board.setBrdResult(rset.getString("RESULT"));

				list.add(board);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

}

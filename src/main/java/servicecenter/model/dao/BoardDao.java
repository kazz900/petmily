package servicecenter.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

import servicecenter.model.vo.Board;

public class BoardDao {

	public int addMySuggest(Connection conn, Board board) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "insert into mylog values (to_char(log_seq.nextval), ?, ?, sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, board.getBrdTitle());
			pstmt.setString(2, board.getBrdContent());

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
					 + "FROM MYLOG "
					 + "ORDER BY BRD_NO DESC";

		try {

			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();

				board.setBrdNo(rset.getInt("brd_no"));
				board.setBrdTitle(rset.getString("brd_title"));
				board.setBrdContent(rset.getString("brd_content"));
				board.setBrdDate(rset.getDate("brd_date"));

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

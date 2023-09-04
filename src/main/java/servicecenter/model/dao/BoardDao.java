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
					 + "?, ?, ?, SYSDATE, ?, DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, board.getBrdMemberNo());
			pstmt.setString(2, board.getBrdTitle());
			pstmt.setString(3, board.getBrdContent());
			pstmt.setString(4, board.getBrdResult());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> selectAllSuggest(Connection conn, int mseq) {
		ArrayList<Board> list = new ArrayList<Board>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * "
					 + "FROM SERV_CENTER "
					 + "WHERE MEMBER_SEQ = ? "
					 + "ORDER BY SERV_SEQ DESC";

		try {

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, mseq);
			
			rset = pstmt.executeQuery();

			while (rset.next()) {

				Board board = new Board();

				board.setBrdNo(rset.getInt("SERV_SEQ"));
				board.setBrdMemberNo(rset.getInt("MEMBER_SEQ"));
				board.setBrdTitle(rset.getString("TITLE"));
				board.setBrdContent(rset.getString("CONTENT"));
				board.setBrdDate(rset.getDate("UPLOAD_DATE"));
				board.setBrdResult(rset.getString("RESULT"));
				board.setBrdReply(rset.getString("REPLY"));

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

	public Board selectBoard(Connection conn, int bnum) {
		Board board = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * "
					 + "FROM SERV_CENTER "
					 + "WHERE SERV_SEQ = ?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, bnum);
			
			rset = pstmt.executeQuery();

			if (rset.next()) {

				board = new Board();

				board.setBrdNo(rset.getInt("SERV_SEQ"));
				board.setBrdMemberNo(rset.getInt("MEMBER_SEQ"));
				board.setBrdTitle(rset.getString("TITLE"));
				board.setBrdContent(rset.getString("CONTENT"));
				board.setBrdDate(rset.getDate("UPLOAD_DATE"));
				board.setBrdResult(rset.getString("RESULT"));
				board.setBrdReply(rset.getString("REPLY"));

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return board;
	}

	public int updateMySuggest(Connection conn, int userid, String title, String content, int boardNo, String result) {
		int eResult = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "UPDATE SERV_CENTER "
					 + "SET TITLE = ?, CONTENT = ?, UPLOAD_DATE = SYSDATE, RESULT = ? "
					 + "WHERE MEMBER_SEQ = ? AND SERV_SEQ = ?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, result);
			pstmt.setInt(4, userid);
			pstmt.setInt(5, boardNo);
			
			eResult = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return eResult;
	}

	public ArrayList<Board> allSuggestAdmin(Connection conn) {
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
				board.setBrdReply(rset.getString("REPLY"));

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

	public int updateMySuggest(Connection conn, String reply, int boardNo, String result) {
		int eResult = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "UPDATE SERV_CENTER "
					 + "SET REPLY = ?, RESULT = ? "
					 + "WHERE SERV_SEQ = ?";
		System.out.println("Hi1");
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, reply);
			pstmt.setString(2, result);
			pstmt.setInt(3, boardNo);
			
			System.out.println("Hi2");
			eResult = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return eResult;
	}

}

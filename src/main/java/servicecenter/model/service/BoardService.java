package servicecenter.model.service;

import static common.JDBCTemplate.*;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;

import servicecenter.model.dao.BoardDao;
import servicecenter.model.vo.Board;

public class BoardService implements Serializable {
	private static final long serialVersionUID = 5537854167716412519L;
	BoardDao bdao = new BoardDao();
	
	public int addMySuggest(Board board) {
		Connection conn = getConnection();
		int result = bdao.addMySuggest(conn, board);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Board> selectAllSuggest(int mseq) {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectAllSuggest(conn, mseq);
		close(conn);
		return list;
	}

	public Board selectBoard(int bnum) {
		Connection conn = getConnection();
		Board board = bdao.selectBoard(conn, bnum);
		close(conn);
		return board;
	}

	public int updateMySuggest(int userid, String title, String content, int boardNo, String result) {
		Connection conn = getConnection();
		int eResult = bdao.updateMySuggest(conn, userid, title, content, boardNo, result);
		close(conn);
		return eResult;
	}

}

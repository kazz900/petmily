package servicecenter.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import servicecenter.model.dao.BoardDao;
import servicecenter.model.vo.Board;

public class BoardService {
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

	public ArrayList<Board> selectAllSuggest() {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectAllSuggest(conn);
		close(conn);
		return list;
	}

}

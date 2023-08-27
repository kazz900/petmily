package standardlike.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import standardlike.model.dao.StandardLikeDao;

public class StandardLikeService {
	private StandardLikeDao sldao = new StandardLikeDao();

	public StandardLikeService() {
	}

	public int putStandardLike(int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = getConnection();
		result = sldao.putStandardLike(conn, memberSeq, postSeq);
		close(conn);
		return result;
	}

	public int undoStandardLike(int memberSeq, int postSeq) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = getConnection();
		result = sldao.undoStandardLike(conn, memberSeq, postSeq);
		close(conn);
		return result;
	}
}

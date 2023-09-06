package like.model.service;

import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import like.model.dao.LikeDao;
import like.model.vo.Like;

public class LikeService {
	private LikeDao lDao = new LikeDao();
	
	public int updateLike(Like l, String postType) {
		int result = 0;
		Connection conn = getConnection();
		result = lDao.updateLike(conn, l, postType);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
}

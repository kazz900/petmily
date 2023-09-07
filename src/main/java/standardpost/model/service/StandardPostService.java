package standardpost.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import standardpost.model.dao.StandardPostDao;
import standardpost.model.vo.StandardPost;

public class StandardPostService {
	private StandardPostDao spDao = new StandardPostDao();

	public StandardPostService() {
	}
}

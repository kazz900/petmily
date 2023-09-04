package admin.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import admin.model.dao.AdminPostDao;
import admin.model.vo.AdminPost;
import member.model.vo.Member;

public class AdminPostService {
	AdminPostDao adao = new AdminPostDao();
	public ArrayList<AdminPost> selectPostList() {
		Connection conn = getConnection();
		ArrayList<AdminPost> list = adao.selectPostList(conn);
		close(conn);
		return list;
	}
	public ArrayList<AdminPost> showTradePostList() {
		Connection conn = getConnection();
		ArrayList<AdminPost> list = adao.showTradePostList(conn);
		close(conn);
		return list;
	}
	public ArrayList<AdminPost> selectSearchMemberId(String keyword) {
		Connection conn = getConnection();
		ArrayList<AdminPost> list = adao.selectSearchMemberId(conn,keyword);
		close(conn);
		return list;
	}
	public ArrayList<AdminPost> selectSearchContent(String keyword) {
		Connection conn = getConnection();
		ArrayList<AdminPost> list = adao.selectSearchContent(conn, keyword);
		close(conn);
		return list;
	}
	public ArrayList<AdminPost> selectSearchMemberGrade(String keyword) {
		Connection conn = getConnection();
		ArrayList<AdminPost> list = adao.selectSearchMemberGrade(conn, keyword);
		close(conn);
		return list;
	}
	public int terminatePost(String value) {
		Connection conn = getConnection();
		int result = adao.terminatePost(conn, value);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public ArrayList<AdminPost> findSearchMemberId(String keyword) {
		Connection conn = getConnection();
		ArrayList<AdminPost> list = adao.findSearchMemberId(conn,keyword);
		close(conn);
		return list;
	}
	public ArrayList<AdminPost> findSearchContent(String keyword) {
		Connection conn = getConnection();
		ArrayList<AdminPost> list = adao.findSearchContent(conn,keyword);
		close(conn);
		return list;
	}
	public ArrayList<AdminPost> findSearchMemberGrade(String keyword) {
		Connection conn = getConnection();
		ArrayList<AdminPost> list = adao.findSearchMemberGrade(conn,keyword);
		close(conn);
		return list;
	}
	public int terminateTPost(String value) {
		Connection conn = getConnection();
		int result = adao.terminateTPost(conn, value);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
		
	
}

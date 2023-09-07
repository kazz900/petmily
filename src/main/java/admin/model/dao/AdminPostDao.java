package admin.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.model.vo.AdminPost;
import member.model.vo.Member;

public class AdminPostDao {

	public ArrayList<AdminPost> selectPostList(Connection conn) {
		ArrayList<AdminPost> list = new ArrayList<AdminPost>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select A.post_seq, A.member_seq, A.post_content, B.member_id, B.member_nick, B.member_grade from standard_post A "
				+ "LEFT JOIN member  B on A.member_seq = B.member_seq order by 1 desc";

		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				AdminPost adm = new AdminPost();

				adm.setPostSeq(rset.getInt("post_seq"));
				adm.setMemberSeq(rset.getInt("member_seq"));
				adm.setMemberId(rset.getString("member_id"));
				adm.setMemberNick(rset.getString("member_nick"));
				adm.setMemberGrade(rset.getString("member_grade"));
				adm.setPostContent(rset.getString("post_content"));
				
				
				list.add(adm);
			}
		} catch (Exception e) {
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}

	public ArrayList<AdminPost> showTradePostList(Connection conn) { //미완
		ArrayList<AdminPost> list = new ArrayList<AdminPost>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select A.post_seq, A.member_seq, A.post_content, B.member_id, B.member_nick, B.member_grade from trade_post A "
				+ "LEFT JOIN member  B on A.member_seq = B.member_seq order by 1 desc";

		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				AdminPost adm = new AdminPost();

				adm.setPostSeq(rset.getInt("post_seq"));
				adm.setMemberSeq(rset.getInt("member_seq"));
				adm.setMemberId(rset.getString("member_id"));
				adm.setMemberNick(rset.getString("member_nick"));
				adm.setMemberGrade(rset.getString("member_grade"));
				adm.setPostContent(rset.getString("post_content"));
				
				list.add(adm);
			}
		} catch (Exception e) {
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<AdminPost> selectSearchMemberId(Connection conn, String keyword) {
		ArrayList<AdminPost> list = new ArrayList<AdminPost>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select A.post_seq, A.member_seq, A.post_content, B.member_id, B.member_nick, B.member_grade from standard_post A LEFT JOIN member  B on A.member_seq = B.member_seq order by 1 desc) where member_id like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();

			
			while (rset.next()) {
				AdminPost adm = new AdminPost();

				adm.setPostSeq(rset.getInt("post_seq"));
				adm.setMemberId(rset.getString("member_id"));
				adm.setMemberSeq(rset.getInt("member_seq"));
				adm.setMemberNick(rset.getString("member_nick"));
				adm.setPostContent(rset.getString("post_content"));
				adm.setMemberGrade(rset.getString("member_grade"));
				
				list.add(adm);
			}
		} catch (Exception e) {
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<AdminPost> selectSearchContent(Connection conn, String keyword) {
		ArrayList<AdminPost> list = new ArrayList<AdminPost>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from(select A.post_seq, A.member_seq, A.post_content, B.member_id, B.member_nick, B.member_grade from standard_post A  "
				+ "	LEFT JOIN member  B on A.member_seq = B.member_seq order by 1 desc) where post_content like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				AdminPost adm = new AdminPost();

				adm.setPostSeq(rset.getInt("post_seq"));
				adm.setMemberSeq(rset.getInt("member_seq"));
				adm.setMemberId(rset.getString("member_id"));
				adm.setMemberNick(rset.getString("member_nick"));
				adm.setMemberGrade(rset.getString("member_grade"));
				adm.setPostContent(rset.getString("post_content"));
				
				list.add(adm);
			}
		} catch (Exception e) {
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<AdminPost> selectSearchMemberGrade(Connection conn, String keyword) {
		ArrayList<AdminPost> list = new ArrayList<AdminPost>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from(select A.post_seq, A.member_seq, A.post_content, B.member_id, B.member_nick, B.member_grade from standard_post A  "
				+ "	LEFT JOIN member  B on A.member_seq = B.member_seq order by 1 desc) where member_grade = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				AdminPost adm = new AdminPost();

				adm.setPostSeq(rset.getInt("post_seq"));
				adm.setMemberSeq(rset.getInt("member_seq"));
				adm.setMemberId(rset.getString("member_id"));
				adm.setMemberNick(rset.getString("member_nick"));
				adm.setMemberGrade(rset.getString("member_grade"));
				adm.setPostContent(rset.getString("post_content"));
				
				list.add(adm);
			}
		} catch (Exception e) {
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int terminatePost(Connection conn, String value) {
		int result = 0;

		PreparedStatement pstmt = null;

		String query = "delete from standard_post where post_seq = ? ";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, Integer.parseInt(value));


			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<AdminPost> findSearchMemberId(Connection conn, String keyword) {
		ArrayList<AdminPost> list = new ArrayList<AdminPost>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select A.post_seq, A.member_seq, A.post_content, B.member_id, B.member_nick, B.member_grade from trade_post A LEFT JOIN member  B on A.member_seq = B.member_seq order by 1 desc) where member_id like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();

			
			while (rset.next()) {
				AdminPost adm = new AdminPost();

				adm.setPostSeq(rset.getInt("post_seq"));
				adm.setMemberId(rset.getString("member_id"));
				adm.setMemberSeq(rset.getInt("member_seq"));
				adm.setMemberNick(rset.getString("member_nick"));
				adm.setPostContent(rset.getString("post_content"));
				adm.setMemberGrade(rset.getString("member_grade"));
				
				list.add(adm);
			}
		} catch (Exception e) {
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<AdminPost> findSearchContent(Connection conn, String keyword) {
		ArrayList<AdminPost> list = new ArrayList<AdminPost>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select A.post_seq, A.member_seq, A.post_content, B.member_id, B.member_nick, B.member_grade from trade_post A LEFT JOIN member  B on A.member_seq = B.member_seq order by 1 desc) where post_content like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();

			
			while (rset.next()) {
				AdminPost adm = new AdminPost();

				adm.setPostSeq(rset.getInt("post_seq"));
				adm.setMemberId(rset.getString("member_id"));
				adm.setMemberSeq(rset.getInt("member_seq"));
				adm.setMemberNick(rset.getString("member_nick"));
				adm.setPostContent(rset.getString("post_content"));
				adm.setMemberGrade(rset.getString("member_grade"));
				
				list.add(adm);
			}
		} catch (Exception e) {
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<AdminPost> findSearchMemberGrade(Connection conn, String keyword) {
		ArrayList<AdminPost> list = new ArrayList<AdminPost>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from(select A.post_seq, A.member_seq, A.post_content, B.member_id, B.member_nick, B.member_grade from trade_post A  "
				+ "	LEFT JOIN member  B on A.member_seq = B.member_seq order by 1 desc) where member_grade = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				AdminPost adm = new AdminPost();

				adm.setPostSeq(rset.getInt("post_seq"));
				adm.setMemberSeq(rset.getInt("member_seq"));
				adm.setMemberId(rset.getString("member_id"));
				adm.setMemberNick(rset.getString("member_nick"));
				adm.setMemberGrade(rset.getString("member_grade"));
				adm.setPostContent(rset.getString("post_content"));
				
				list.add(adm);
			}
		} catch (Exception e) {
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int terminateTPost(Connection conn, String value) {
		int result = 0;

		PreparedStatement pstmt = null;

		String query = "delete from trade_post where post_seq = ? ";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, Integer.parseInt(value));


			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
}

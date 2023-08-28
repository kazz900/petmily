package member.model.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.model.vo.Member;

public class MemberDao {
	public MemberDao() {}

	// 일반회원 로그인
	public Member commonLogin(Connection conn, String mid, String mpwd) {
		Member member =new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where member_Id = ? and member_Pwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, mid);
			pstmt.setString(2, mpwd);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				member.setMemberId(mid);
				member.setMemberNick(rset.getString("member_nick"));
				member.setMemberEmail(rset.getString("member_email"));
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);			
		}
		
		return member;
	}

	//sns계정 로그인(네이버 구글 카카오)
	public Member snsLogin(Connection conn, String memail) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where member_email = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memail);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				
				member.setMemberId(rset.getString("member_id"));
				member.setMemberNick(rset.getString("member_nick"));
				member.setMemberEmail(memail);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);			
		}
		
		return member;
	}

	// 회원가입 처리용
	public int insertMember(Connection conn, Member member) {
		int result = 0;
		String query = "insert into member values ((member_seq.nextval),?,?,?,?,1)";
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberNick());
			pstmt.setString(4, member.getMemberEmail());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);	
		}
		return result;
	}
	//아이디 중복 체크용
	public int selectCheckid(Connection conn, String mid) {
		 int idc = 0;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String query = "select count(member_id) from member where member_id = ?";
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, mid);
	         
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	            idc = rset.getInt(1);   //select 절의 항목 순번으로도 값 추출할 수 있음
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return idc;
	}
	//이메일 중복 체크용
	public int selectCheckemail(Connection conn, String memail) {
		 int emc = 0;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String query = "select count(member_email) from member where member_email = ?";
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, memail);
	         
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	            emc = rset.getInt(1);   //select 절의 항목 순번으로도 값 추출할 수 있음
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return emc;
	}

	//회원아이디 조회용
	public Member findMemberid(Connection conn, String memail) {
		Member mem = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where member_email = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memail);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				mem.setMemberId(rset.getString("member_id"));
				mem.setMemberPwd(rset.getString("member_pwd"));
				mem.setMemberNick(rset.getString("member_nick"));
				mem.setMemberEmail(memail);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);			
		}
		return mem;
	}

	//회원 패스워드변경을 위한 조회용
	public Member findMemberpwd(Connection conn, String mid, String memail) {
		Member mem = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where member_id = ? and member_email = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, mid);
			pstmt.setString(2, memail);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				mem.setMemberId(rset.getString(mid));
				mem.setMemberPwd(rset.getString("member_pwd"));
				mem.setMemberNick(rset.getString("member_nick"));
				mem.setMemberEmail(rset.getString(memail));
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);			
		}
		return mem;
	}

	//회원 패스워드 변경용
	public int updatePwd(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update member set member_pwd = ? where member_id = ? and member_email = ?";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberId());
			pstmt.setString(3, member.getMemberEmail());		
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	
	
}

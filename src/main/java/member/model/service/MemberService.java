package member.model.service;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import pet.model.vo.Pet;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import department.model.vo.Department;

public class MemberService {
	private MemberDao mdao = new MemberDao();
	
	public MemberService() {}
	
	//일반회원 로그인용
	public Member commonLogin(String mid, String mpwd) {
		Connection conn = getConnection();
		Member loginMember = mdao.commonLogin(conn, mid, mpwd);
		close(conn);
		return loginMember;
	}
	
	//sns계정 로그인용
	public Member snsLogin(String memail) {
		Connection conn = getConnection();
		Member loginMember = mdao.snsLogin(conn, memail);
		close(conn);
		return loginMember;
	}
	
	//회원가입용
	public int insertMember(Member mem) {
		Connection conn = getConnection();
		int result = mdao.insertMember(conn, mem);
		if (result>0) {
			commit(conn);
		}	else	{
			rollback(conn);
		}
		close(conn);
		return result;
	}
	//아이디 중복 체크용
	public int selectCheckid(String mid) {
		Connection conn = getConnection();
		int result = mdao.selectCheckid(conn, mid);
		close(conn);
		return result;
	}
	//이메일 중복 체크용
	public int selectCheckemail(String memail) {
		Connection conn = getConnection();
		int result = mdao.selectCheckemail(conn, memail);
		close(conn);
		return result;
	}
	
	
	//회원아이디 조회용
	public Member findMemberid(String memail) {
		Connection conn = getConnection();
		Member mem = mdao.findMemberid(conn, memail);
		close(conn);
		return mem;
	}
	
	//회원 패스워드변경을 위한 조회용
	public Member findMemberpwd(String mid, String memail) {
		Connection conn = getConnection();
		Member mem = mdao.findMemberpwd(conn, mid, memail);
		close(conn);
		return mem;
	}
	//회원 패스워드 변경용
	public int updatePwd(Member member) {
		Connection conn = getConnection();
		int result = mdao.updatePwd(conn, member);
		if (result>0) {
			commit(conn);
		}	else	{
			rollback(conn);
		}
		close(conn);
		return result;
	}

	//관리자가 회원 등급 변경용
	public int managementMember(String memberSeq, String memberGrade) {
		Connection conn = getConnection();
		int result = mdao.managementMember(conn, memberSeq, memberGrade);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateMemberInfo(String userid, String nickname) {
		Connection conn = getConnection();
		int result = mdao.updateMemberInfo(conn, userid, nickname);
		if (result>0) {
			commit(conn);
		}	else	{
			rollback(conn);
		}
		close(conn);
		return result;
	}


	public int updateMemberpwd(Member member) {
		Connection conn = getConnection();
		int result = mdao.updateMemberpwd(conn, member);
		if (result>0) {
			commit(conn);
		}	else	{
			rollback(conn);
		}
		close(conn);
		return result;
	}


	public ArrayList<Member> selectList() {
		Connection conn = getConnection();
		ArrayList<Member> list = mdao.selectList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Member> selectSearchMemberId(String keyword) {
		Connection conn = getConnection();
		ArrayList<Member> list = mdao.selectSearchMemberId(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Member> againList(String memberId) {
		Connection conn = getConnection();
		ArrayList<Member> list = mdao.againList(conn, memberId);
		close(conn);
		return list;
	}

	public ArrayList<Member> selectSearchContent(String keyword) {
		Connection conn = getConnection();
		ArrayList<Member> list = mdao.selectSearchContent(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<Member> selectSearchMemberGrade(String keyword) {
		Connection conn = getConnection();
		ArrayList<Member> list = mdao.selectSearchMemberGrade(conn, keyword);
		close(conn);
		return list;
	}

	


}

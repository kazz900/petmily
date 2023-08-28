package department.model.service;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;

import static common.JDBCTemplate.*;
import department.model.dao.DepartmentDao;
import department.model.vo.Department;

public class DepartmentService implements Serializable{
	
	private static final long serialVersionUID = -1766401393106953822L;
	private DepartmentDao ddao = new DepartmentDao();
	
	public ArrayList<Department> selectList(String value) {
		Connection conn = getConnection();
		ArrayList<Department> list = ddao.selectList(conn, value);
		close(conn);
		return list;
	}

	public ArrayList<Department> selectType(String value) {
		Connection conn = getConnection();
		ArrayList<Department> list = ddao.selectType(conn, value);
		close(conn);
		return list;
	}
	
	public int insertDepartment(Department dept) {
		Connection conn = getConnection();
		int result = ddao.insertDepartment(conn, dept);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteDepartment(Department dept) {
		Connection conn = getConnection();
		int result = ddao.deleteDepartment(conn, dept);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public Department selectMainInfo(String deptSeq) {
		Connection conn = getConnection();
		Department dptmt = ddao.selectMainInfo(conn, deptSeq);
		close(conn);
		return dptmt;
	}
}

package department.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import department.model.vo.Department;
import static common.JDBCTemplate.close;

public class DepartmentDao {

	public ArrayList<Department> selectList(Connection conn, String value) {

		ArrayList<Department> list = new ArrayList<Department>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from department where adminok = 'y' and dept_name like ? and dept_address like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + value + "%");
			pstmt.setString(2, "%" + value + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Department dept = new Department();

				dept.setDeptSeq(rset.getInt("dept_seq"));
				dept.setDeptType(rset.getString("dept_type"));
				dept.setDeptName(rset.getString("dept_name"));
				dept.setDeptAddress(rset.getString("dept_address"));
				dept.setDeptPhone(rset.getString("dept_phone"));
				dept.setDeptLatitude(rset.getString("dept_latitude"));
				dept.setDeptLongitude(rset.getString("dept_longtitude"));
				dept.setDeptTime(rset.getString("dept_time"));
				dept.setDeptParking(rset.getString("dept_parking"));
				dept.setDeptEntrancefee(rset.getString("dept_entrance_fee"));
				dept.setDeptSizerestrict(rset.getString("dept_sizerestrict"));
				dept.setDeptRestrict(rset.getString("dept_restrict"));
				dept.setDeptWithpetfee(rset.getString("dept_withpetfee"));
				dept.setDeptUrl(rset.getString("dept_url"));
				dept.setDeptPic(rset.getString("dept_pic"));

				list.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Department> selectType(Connection conn, String value) {
		ArrayList<Department> list = new ArrayList<Department>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from department where adminok = 'y' and dept_type like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + value + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Department dept = new Department();

				dept.setDeptSeq(rset.getInt("dept_seq"));
				dept.setDeptType(rset.getString("dept_type"));
				dept.setDeptName(rset.getString("dept_name"));
				dept.setDeptAddress(rset.getString("dept_address"));
				dept.setDeptPhone(rset.getString("dept_phone"));
				dept.setDeptLatitude(rset.getString("dept_latitude"));
				dept.setDeptLongitude(rset.getString("dept_longtitude"));
				dept.setDeptTime(rset.getString("dept_time"));
				dept.setDeptParking(rset.getString("dept_parking"));
				dept.setDeptEntrancefee(rset.getString("dept_entrance_fee"));
				dept.setDeptSizerestrict(rset.getString("dept_sizerestrict"));
				dept.setDeptRestrict(rset.getString("dept_restrict"));
				dept.setDeptWithpetfee(rset.getString("dept_withpetfee"));
				dept.setDeptUrl(rset.getString("dept_url"));
				dept.setDeptPic(rset.getString("dept_pic"));

				list.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

}

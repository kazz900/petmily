package department.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import department.model.vo.Department;
import static common.JDBCTemplate.close;

public class DepartmentDao implements Serializable {

   private static final long serialVersionUID = 85103058248412049L;

   public ArrayList<Department> selectList(Connection conn, String value) {

      ArrayList<Department> list = new ArrayList<Department>();

      PreparedStatement pstmt = null;
      ResultSet rset = null;

      String query = "select * from department where dept_insert_ok = 'y' and dept_name like ? or dept_address like ?";

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
            dept.setDeptLongitude(rset.getString("dept_longitude"));
            dept.setDeptTime(rset.getString("dept_time"));
            dept.setDeptParking(rset.getString("dept_parking"));
            dept.setDeptEntrancefee(rset.getString("dept_entrance_fee"));
            dept.setDeptSizerestrict(rset.getString("dept_sizerestrict"));
            dept.setDeptRestrict(rset.getString("dept_restrict"));
            dept.setDeptWithpetfee(rset.getString("dept_withpetfee"));
            dept.setDeptUrl(rset.getString("dept_url"));
            dept.setDeptPic(rset.getString("dept_pic"));
            dept.setDeptInsertOk(rset.getString("dept_insert_ok"));
            dept.setDeptDeleteOk(rset.getString("dept_delete_ok"));

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

      String query = null;
     
      //관리자에서 삭제요청만 조회시 9
      if (value.equals("9")) {
         query = "select * from department where dept_insert_ok = 'y'";
      } else {
         query = "select * from department where dept_insert_ok = 'y' and dept_type like ? ";
      }

      try {
         pstmt = conn.prepareStatement(query);

         if (!value.equals("9")) {
            pstmt.setString(1, "%" + value + "%");
         }

         rset = pstmt.executeQuery();

         while (rset.next()) {
            Department dept = new Department();

            dept.setDeptSeq(rset.getInt("dept_seq"));
            dept.setDeptType(rset.getString("dept_type"));
            dept.setDeptName(rset.getString("dept_name"));
            dept.setDeptAddress(rset.getString("dept_address"));
            dept.setDeptPhone(rset.getString("dept_phone"));
            dept.setDeptLatitude(rset.getString("dept_latitude"));
            dept.setDeptLongitude(rset.getString("dept_longitude"));
            dept.setDeptLatitude(rset.getString("dept_latitude"));
            dept.setDeptLongitude(rset.getString("dept_longitude"));
            dept.setDeptTime(rset.getString("dept_time"));
            dept.setDeptParking(rset.getString("dept_parking"));
            dept.setDeptEntrancefee(rset.getString("dept_entrance_fee"));
            dept.setDeptSizerestrict(rset.getString("dept_sizerestrict"));
            dept.setDeptRestrict(rset.getString("dept_restrict"));
            dept.setDeptWithpetfee(rset.getString("dept_withpetfee"));
            dept.setDeptUrl(rset.getString("dept_url"));
            dept.setDeptPic(rset.getString("dept_pic"));
            dept.setDeptInsertOk(rset.getString("dept_insert_ok"));
            dept.setDeptDeleteOk(rset.getString("dept_delete_ok"));

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

   public int insertDepartment(Connection conn, Department dept) {
      int result = 0;

      PreparedStatement pstmt = null;

      String query = "INSERT INTO DEPARTMENT " 
    		  	   + "VALUES (TO_CHAR(DEPT_SEQ.NEXTVAL), "
    		  	   + "?, ?, ?, ?, NULL, NULL, ?, ?, ?, " 
    		  	   + "?, ?, ?, NULL, NULL, ?, ?)";

      try {
         pstmt = conn.prepareStatement(query);

         pstmt.setString(1, dept.getDeptType());
         pstmt.setString(2, dept.getDeptName());
         pstmt.setString(3, dept.getDeptAddress());
         pstmt.setString(4, dept.getDeptPhone());
         pstmt.setString(5, dept.getDeptTime());
         pstmt.setString(6, dept.getDeptParking());
         pstmt.setString(7, dept.getDeptEntrancefee());
         pstmt.setString(8, dept.getDeptSizerestrict());
         pstmt.setString(9, dept.getDeptRestrict());
         pstmt.setString(10, dept.getDeptWithpetfee());
         pstmt.setString(11, dept.getDeptInsertOk());
         pstmt.setString(12, dept.getDeptDeleteOk());

         result = pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }

   public Department selectMainInfo(Connection conn, String deptSeq) {
      Department dptmt = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;

      String query = "SELECT * FROM department WHERE dept_seq = ?";

      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, deptSeq);

         rset = pstmt.executeQuery();

         if (rset.next()) {
            dptmt = new Department();

            dptmt.setDeptSeq(Integer.parseInt(deptSeq));
            dptmt.setDeptType(rset.getString("DEPT_TYPE"));
            dptmt.setDeptName(rset.getString("DEPT_NAME"));
            dptmt.setDeptAddress(rset.getString("DEPT_ADDRESS"));
            dptmt.setDeptPhone(rset.getString("DEPT_PHONE"));
            dptmt.setDeptLatitude(rset.getString("DEPT_LATITUDE"));
            dptmt.setDeptLongitude(rset.getString("DEPT_LONGITUDE"));
            dptmt.setDeptTime(rset.getString("DEPT_TIME"));
            dptmt.setDeptParking(rset.getString("DEPT_PARKING"));
            dptmt.setDeptEntrancefee(rset.getString("DEPT_ENTRANCE_FEE"));
            dptmt.setDeptSizerestrict(rset.getString("DEPT_SIZERESTRICT"));
            dptmt.setDeptRestrict(rset.getString("DEPT_RESTRICT"));
            dptmt.setDeptWithpetfee(rset.getString("DEPT_WITHPETFEE"));
            dptmt.setDeptUrl(rset.getString("DEPT_URL"));
            dptmt.setDeptPic(rset.getString("DEPT_PIC"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }

      return dptmt;
   }

   public int requestDeleteDept(Connection conn, Department dept) {

      int result = 0;

      PreparedStatement pstmt = null;

      String query = "UPDATE DEPARTMENT " 
    		  	   + "SET DEPT_DELETE_OK = ? " 
    		  	   + "WHERE DEPT_NAME = ? "
    		  	   + "AND DEPT_ADDRESS = ?";

      try {
         pstmt = conn.prepareStatement(query);

         pstmt.setString(1, dept.getDeptDeleteOk());
         pstmt.setString(2, dept.getDeptName());
         pstmt.setString(3, dept.getDeptAddress());

         result = pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }

   public ArrayList<Department> selectNotInsertedDept(Connection conn) {
      ArrayList<Department> list = new ArrayList<Department>();

      PreparedStatement pstmt = null;
      ResultSet rset = null;

      String query = "select * from department where dept_insert_ok = 'n'";

      try {
         pstmt = conn.prepareStatement(query);

         rset = pstmt.executeQuery();

         while (rset.next()) {
            Department dept = new Department();

            dept.setDeptSeq(rset.getInt("dept_seq"));
            dept.setDeptType(rset.getString("dept_type"));
            dept.setDeptName(rset.getString("dept_name"));
            dept.setDeptAddress(rset.getString("dept_address"));
            dept.setDeptPhone(rset.getString("dept_phone"));
            dept.setDeptLatitude(rset.getString("dept_latitude"));
            dept.setDeptLongitude(rset.getString("DEPT_LONGITUDE"));
            dept.setDeptTime(rset.getString("dept_time"));
            dept.setDeptParking(rset.getString("dept_parking"));
            dept.setDeptEntrancefee(rset.getString("dept_entrance_fee"));
            dept.setDeptSizerestrict(rset.getString("dept_sizerestrict"));
            dept.setDeptRestrict(rset.getString("dept_restrict"));
            dept.setDeptWithpetfee(rset.getString("dept_withpetfee"));
            dept.setDeptUrl(rset.getString("dept_url"));
            dept.setDeptPic(rset.getString("dept_pic"));
            dept.setDeptInsertOk(rset.getString("dept_insert_ok"));
            dept.setDeptDeleteOk(rset.getString("dept_delete_ok"));

            dept.typeSelect();

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

   public int approveDept(Connection conn, String value) {

      int result = 0;

      PreparedStatement pstmt = null;

      String query = "update department set dept_insert_ok = 'y' where dept_seq = ? ";

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

   public ArrayList<Department> selectRequestTerminateDept(Connection conn) {
      ArrayList<Department> list = new ArrayList<Department>();

      PreparedStatement pstmt = null;
      ResultSet rset = null;

      String query = "select * from department where dept_delete_ok = 'y'";

      try {
         pstmt = conn.prepareStatement(query);

         rset = pstmt.executeQuery();

         while (rset.next()) {
            Department dept = new Department();

            dept.setDeptSeq(rset.getInt("dept_seq"));
            dept.setDeptType(rset.getString("dept_type"));
            dept.setDeptName(rset.getString("dept_name"));
            dept.setDeptAddress(rset.getString("dept_address"));
            dept.setDeptPhone(rset.getString("dept_phone"));
            dept.setDeptLatitude(rset.getString("dept_latitude"));
            dept.setDeptLongitude(rset.getString("DEPT_LONGITUDE"));
            dept.setDeptTime(rset.getString("dept_time"));
            dept.setDeptParking(rset.getString("dept_parking"));
            dept.setDeptEntrancefee(rset.getString("dept_entrance_fee"));
            dept.setDeptSizerestrict(rset.getString("dept_sizerestrict"));
            dept.setDeptRestrict(rset.getString("dept_restrict"));
            dept.setDeptWithpetfee(rset.getString("dept_withpetfee"));
            dept.setDeptUrl(rset.getString("dept_url"));
            dept.setDeptPic(rset.getString("dept_pic"));
            dept.setDeptInsertOk(rset.getString("dept_insert_ok"));
            dept.setDeptDeleteOk(rset.getString("dept_delete_ok"));

            dept.typeSelect();

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

   public int terminateDept(Connection conn, String value) {

      int result = 0;

      PreparedStatement pstmt = null;

      String query = "delete from department where dept_seq = ? ";

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

   public ArrayList<Department> selectDeptName(Connection conn, String keyword) {
      ArrayList<Department> list = new ArrayList<Department>();

      PreparedStatement pstmt = null;
      ResultSet rset = null;

      String query = "select * from department where dept_insert_ok = 'n' and dept_name like ?";

      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, "%" + keyword + "%");

         rset = pstmt.executeQuery();

         while (rset.next()) {
            Department dept = new Department();

            dept.setDeptSeq(rset.getInt("dept_seq"));
            dept.setDeptType(rset.getString("dept_type"));
            dept.setDeptName(rset.getString("dept_name"));
            dept.setDeptAddress(rset.getString("dept_address"));
            dept.setDeptPhone(rset.getString("dept_phone"));
            dept.setDeptLatitude(rset.getString("dept_latitude"));
            dept.setDeptLongitude(rset.getString("dept_longitude"));
            dept.setDeptTime(rset.getString("dept_time"));
            dept.setDeptParking(rset.getString("dept_parking"));
            dept.setDeptEntrancefee(rset.getString("dept_entrance_fee"));
            dept.setDeptSizerestrict(rset.getString("dept_sizerestrict"));
            dept.setDeptRestrict(rset.getString("dept_restrict"));
            dept.setDeptWithpetfee(rset.getString("dept_withpetfee"));
            dept.setDeptUrl(rset.getString("dept_url"));
            dept.setDeptPic(rset.getString("dept_pic"));
            dept.setDeptInsertOk(rset.getString("dept_insert_ok"));
            dept.setDeptDeleteOk(rset.getString("dept_delete_ok"));

            dept.typeSelect();

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

   public ArrayList<Department> findDeptName(Connection conn, String keyword) {
      ArrayList<Department> list = new ArrayList<Department>();

      PreparedStatement pstmt = null;
      ResultSet rset = null;

      String query = "select * from department where dept_name like ?";

      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, "%" + keyword + "%");
         rset = pstmt.executeQuery();

         while (rset.next()) {

            Department dept = new Department();

            dept.setDeptSeq(rset.getInt("dept_seq"));
            dept.setDeptType(rset.getString("dept_type"));
            dept.setDeptName(rset.getString("dept_name"));
            dept.setDeptAddress(rset.getString("dept_address"));
            dept.setDeptPhone(rset.getString("dept_phone"));
            dept.setDeptLatitude(rset.getString("dept_latitude"));
            dept.setDeptLongitude(rset.getString("dept_longitude"));
            dept.setDeptTime(rset.getString("dept_time"));
            dept.setDeptParking(rset.getString("dept_parking"));
            dept.setDeptEntrancefee(rset.getString("dept_entrance_fee"));
            dept.setDeptSizerestrict(rset.getString("dept_sizerestrict"));
            dept.setDeptRestrict(rset.getString("dept_restrict"));
            dept.setDeptWithpetfee(rset.getString("dept_withpetfee"));
            dept.setDeptUrl(rset.getString("dept_url"));
            dept.setDeptPic(rset.getString("dept_pic"));
            dept.setDeptInsertOk(rset.getString("dept_insert_ok"));
            dept.setDeptDeleteOk(rset.getString("dept_delete_ok"));

            dept.typeSelect();

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

   public ArrayList<Department> reDeptList(Connection conn, String keyword) {
      ArrayList<Department> list = new ArrayList<Department>();

      PreparedStatement pstmt = null;
      ResultSet rset = null;

      String query = "select * from department where dept_name like ?";

      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, "%" + keyword + "%");
         rset = pstmt.executeQuery();

         while (rset.next()) {

            Department dept = new Department();

            dept.setDeptSeq(rset.getInt("dept_seq"));
            dept.setDeptType(rset.getString("dept_type"));
            dept.setDeptName(rset.getString("dept_name"));
            dept.setDeptAddress(rset.getString("dept_address"));
            dept.setDeptPhone(rset.getString("dept_phone"));
            dept.setDeptLatitude(rset.getString("dept_latitude"));
            dept.setDeptLongitude(rset.getString("dept_longitude"));
            dept.setDeptTime(rset.getString("dept_time"));
            dept.setDeptParking(rset.getString("dept_parking"));
            dept.setDeptEntrancefee(rset.getString("dept_entrance_fee"));
            dept.setDeptSizerestrict(rset.getString("dept_sizerestrict"));
            dept.setDeptRestrict(rset.getString("dept_restrict"));
            dept.setDeptWithpetfee(rset.getString("dept_withpetfee"));
            dept.setDeptUrl(rset.getString("dept_url"));
            dept.setDeptPic(rset.getString("dept_pic"));
            dept.setDeptInsertOk(rset.getString("dept_insert_ok"));
            dept.setDeptDeleteOk(rset.getString("dept_delete_ok"));

            dept.typeSelect();

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
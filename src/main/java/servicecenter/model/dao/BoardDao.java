package servicecenter.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

import servicecenter.model.vo.Board;

public class BoardDao implements Serializable {

   private static final long serialVersionUID = -6193829464532553691L;

   public int addMySuggest(Connection conn, Board board) {
      int result = 0;
      
      PreparedStatement pstmt = null;
      
      String query = "INSERT INTO SERV_CENTER "
                + "VALUES (TO_CHAR(SERV_SEQ.NEXTVAL), "
                + "?, ?, ?, SYSDATE, ?, DEFAULT)";
      
      try {
         pstmt = conn.prepareStatement(query);

         pstmt.setInt(1, board.getBrdMemberNo());
         pstmt.setString(2, board.getBrdTitle());
         pstmt.setString(3, board.getBrdContent());
         pstmt.setString(4, board.getBrdResult());

         result = pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }

   public ArrayList<Board> selectAllSuggest(Connection conn, int mseq, int startRow, int endRow) {
      ArrayList<Board> list = new ArrayList<Board>();

      PreparedStatement pstmt = null;
      ResultSet rset = null;

      String query = "SELECT * "
                + "FROM (SELECT ROWNUM RNUM, SERV_SEQ, "
                + "MEMBER_SEQ, TITLE, CONTENT, UPLOAD_DATE, "
                + "RESULT, REPLY "
                + "FROM (SELECT * FROM SERV_CENTER WHERE MEMBER_SEQ = ? "
                + "ORDER BY SERV_SEQ DESC)) "
                + "WHERE RNUM >= ? AND RNUM <= ?";

      try {

         pstmt = conn.prepareStatement(query);

         pstmt.setInt(1, mseq);
         pstmt.setInt(2, startRow);
         pstmt.setInt(3, endRow);
         
         rset = pstmt.executeQuery();

         while (rset.next()) {

            Board board = new Board();

            board.setBrdNo(rset.getInt("SERV_SEQ"));
            board.setBrdMemberNo(rset.getInt("MEMBER_SEQ"));
            board.setBrdTitle(rset.getString("TITLE"));
            board.setBrdContent(rset.getString("CONTENT"));
            board.setBrdDate(rset.getDate("UPLOAD_DATE"));
            board.setBrdResult(rset.getString("RESULT"));
            board.setBrdReply(rset.getString("REPLY"));

            list.add(board);
         }

      } catch (Exception e) {

         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }

      return list;
   }

   public Board selectBoard(Connection conn, int bnum) {
      Board board = null;

      PreparedStatement pstmt = null;
      ResultSet rset = null;

      String query = "SELECT * "
                + "FROM SERV_CENTER "
                + "WHERE SERV_SEQ = ?";

      try {
         pstmt = conn.prepareStatement(query);

         pstmt.setInt(1, bnum);

         rset = pstmt.executeQuery();

         if (rset.next()) {

            board = new Board();

            board.setBrdNo(rset.getInt("SERV_SEQ"));
            board.setBrdMemberNo(rset.getInt("MEMBER_SEQ"));
            board.setBrdTitle(rset.getString("TITLE"));
            board.setBrdContent(rset.getString("CONTENT"));
            board.setBrdDate(rset.getDate("UPLOAD_DATE"));
            board.setBrdResult(rset.getString("RESULT"));
            board.setBrdReply(rset.getString("REPLY"));

         }

      } catch (Exception e) {

         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }

      return board;
   }

   public int updateMySuggest(Connection conn, Board board) {
      
	  int eResult = 0;
      
      PreparedStatement pstmt = null;

      String query = "UPDATE SERV_CENTER "
                + "SET TITLE = ?, CONTENT = ?, "
                + "UPLOAD_DATE = SYSDATE, RESULT = ? "
                + "WHERE MEMBER_SEQ = ? AND SERV_SEQ = ?";

      try {
         pstmt = conn.prepareStatement(query);

         pstmt.setString(1, board.getBrdTitle());
         pstmt.setString(2, board.getBrdContent());
         pstmt.setString(3, board.getResult());
         pstmt.setInt(4, board.getMemberNo());
         pstmt.setInt(5, board.getBrdNo());
         
         eResult = pstmt.executeUpdate();
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return eResult;
   }

   public ArrayList<Board> allSuggestAdmin(Connection conn, int startRow, int endRow) {
      ArrayList<Board> list = new ArrayList<Board>();

      PreparedStatement pstmt = null;
      ResultSet rset = null;

      String query = "SELECT * "
             + "FROM (SELECT ROWNUM RNUM, SERV_SEQ, "
             + "MEMBER_SEQ, TITLE, CONTENT, UPLOAD_DATE, "
             + "RESULT, REPLY "
             + "FROM (SELECT * FROM SERV_CENTER "
             + "ORDER BY SERV_SEQ DESC)) "
             + "WHERE RNUM >= ? AND RNUM <= ?";

      try {

         pstmt = conn.prepareStatement(query);
         
         pstmt.setInt(1, startRow);
         pstmt.setInt(2, endRow);
         
         rset = pstmt.executeQuery();

         while (rset.next()) {

            Board board = new Board();

            board.setBrdNo(rset.getInt("SERV_SEQ"));
            board.setBrdMemberNo(rset.getInt("MEMBER_SEQ"));
            board.setBrdTitle(rset.getString("TITLE"));
            board.setBrdContent(rset.getString("CONTENT"));
            board.setBrdDate(rset.getDate("UPLOAD_DATE"));
            board.setBrdResult(rset.getString("RESULT"));
            board.setBrdReply(rset.getString("REPLY"));

            list.add(board);
         }

      } catch (Exception e) {

         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }

      return list;
   }

   public int adminEditReply(Connection conn, Board board) {
      int eResult = 0;
      
      PreparedStatement pstmt = null;
      
      String query = "UPDATE SERV_CENTER "
                + "SET REPLY = ?, RESULT = ? "
                + "WHERE SERV_SEQ = ?";

      try {
         pstmt = conn.prepareStatement(query);

         pstmt.setString(1, board.getBrdReply());
         pstmt.setString(2, board.getResult());
         pstmt.setInt(3, board.getBrdNo());
         
         eResult = pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return eResult;
   }

   public int getListCount(Connection conn, int mseq) {
      int listCount = 0;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = "SELECT COUNT(*) "
                + "FROM SERV_CENTER "
                + "WHERE MEMBER_SEQ = ?";

      try {
         pstmt = conn.prepareStatement(query);
         
         pstmt.setInt(1, mseq);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            listCount = rset.getInt(1);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }      

      return listCount;
   }

   public int getListCountAdmin(Connection conn) {
      int listCount = 0;
      Statement pstmt = null;
      ResultSet rset = null;
      
      String query = "SELECT COUNT(*) "
                + "FROM SERV_CENTER";
      
      try {
         pstmt = conn.prepareStatement(query);
         
         rset = pstmt.executeQuery(query);
         
         if(rset.next()) {
            listCount = rset.getInt(1);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }      
      
      return listCount;
   }

}
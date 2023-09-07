package servicecenter.model.service;

import static common.JDBCTemplate.*;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;

import servicecenter.model.dao.BoardDao;
import servicecenter.model.vo.Board;

public class BoardService implements Serializable {
   private static final long serialVersionUID = 5537854167716412519L;
   BoardDao bdao = new BoardDao();
   
   public int addMySuggest(Board board) {
      Connection conn = getConnection();
      int result = bdao.addMySuggest(conn, board);
      if (result > 0) {
         commit(conn);
      } else {
         rollback(conn);
      }
      close(conn);
      return result;
   }

   public ArrayList<Board> selectAllSuggest(int mseq, int startRow, int endRow) {
      Connection conn = getConnection();
      ArrayList<Board> list = bdao.selectAllSuggest(conn, mseq, startRow, endRow);
      close(conn);
      return list;
   }

   public Board selectBoard(int bnum) {
      Connection conn = getConnection();
      Board board = bdao.selectBoard(conn, bnum);
      close(conn);
      return board;
   }

   public int updateMySuggest(Board board) {
      Connection conn = getConnection();
      int eResult = bdao.updateMySuggest(conn, board);
      if (eResult > 0) {
         commit(conn);
      } else {
         rollback(conn);
      }
      close(conn);
      return eResult;
   }

   public ArrayList<Board> allSuggestAdmin(int startRow, int endRow) {
      Connection conn = getConnection();
      ArrayList<Board> list = bdao.allSuggestAdmin(conn, startRow, endRow);
      close(conn);
      return list;
   }

   public int adminEditReply(Board board) {
      Connection conn = getConnection();
      int eResult = bdao.adminEditReply(conn, board);
      if (eResult > 0) {
         commit(conn);
      } else {
         rollback(conn);
      }
      close(conn);
      return eResult;
   }

   public int getListCount(int mseq) {
      Connection conn = getConnection();
      int listCount = bdao.getListCount(conn, mseq);
      close(conn);
      return listCount;
   }

   public int getListCountAdmin() {
      Connection conn = getConnection();
      int listCount = bdao.getListCountAdmin(conn);
      close(conn);
      return listCount;
   }

}
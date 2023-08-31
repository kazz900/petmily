package pet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static common.JDBCTemplate.close;
import member.model.vo.Member;
import pet.model.vo.Pet;

public class PetDao {

	public ArrayList<Pet> selectList(Connection conn, int memberSeq) {
		
		ArrayList<Pet> list = new ArrayList<Pet>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//관리자를 제외한 일반회원만 전체 조회
		String query = "select * from pet where member_seq = ?";
		
		try {
			pstmt = conn.prepareStatement(query);					
			pstmt.setInt(1, memberSeq);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Pet pet = new Pet();
				
				//결과매핑 : 컬럼값 꺼내서 필드에 옮기기
				pet.setPetSeq(rset.getInt("pet_seq"));
				pet.setMemberSeq(rset.getInt("member_seq"));
				pet.setPetName(rset.getString("pet_name"));
				pet.setPetType(rset.getString("pet_type"));
				pet.setPetSize(rset.getString("pet_size"));
				pet.setPetImg(rset.getString("pet_img"));
				
				list.add(pet);
				
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

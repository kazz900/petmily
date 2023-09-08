package pet.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pet.model.vo.Pet;

public class PetDao {

	public ArrayList<Pet> selectList(Connection conn, int memberSeq) {

		ArrayList<Pet> list = new ArrayList<Pet>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 관리자를 제외한 일반회원만 전체 조회
		String query = "select * from pet where member_seq = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberSeq);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Pet pet = new Pet();

				// 결과매핑 : 컬럼값 꺼내서 필드에 옮기기
				pet.setPetSeq(rset.getInt("pet_seq"));
				pet.setMemberSeq(rset.getInt("member_seq"));
				pet.setPetName(rset.getString("pet_name"));
				pet.setPetType(rset.getString("pet_type"));
				pet.setPetSize(rset.getString("pet_size"));
				pet.setPetImg(rset.getString("pet_img"));

				pet.typeSelect(pet.getPetType());

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

	public int insertPet(Connection conn, Pet pet) {

		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into pet values " + "(to_char(pet_seq.nextval), ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pet.getMemberSeq());
			pstmt.setString(2, pet.getPetName());
			pstmt.setString(3, pet.getPetType());
			pstmt.setString(4, pet.getPetSize());
			pstmt.setString(5, pet.getPetImg());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	public int updatePet(Connection conn, Pet pet) {		
			int result = 0;
			PreparedStatement pstmt = null;
			String query = null;
			if(pet.getPetImg() != null) {
			query = "update pet set pet_name = ?, pet_type = ?, pet_size = ?, pet_img = ? where member_seq = ? and pet_seq = ?";
			}else {
			query = "update pet set pet_name = ?, pet_type = ?, pet_size = ? where member_seq = ? and pet_seq = ?";	
			}
			try {
				pstmt = conn.prepareStatement(query);
				if(pet.getPetImg() != null) {
				pstmt.setString(1, pet.getPetName());
				pstmt.setString(2, pet.getPetType());
				pstmt.setString(3, pet.getPetSize());
				pstmt.setString(4, pet.getPetImg());
				pstmt.setInt(5, pet.getMemberSeq());
				pstmt.setInt(6, pet.getPetSeq());
				}else {
					pstmt.setString(1, pet.getPetName());
					pstmt.setString(2, pet.getPetType());
					pstmt.setString(3, pet.getPetSize());
					pstmt.setInt(4, pet.getMemberSeq());
					pstmt.setInt(5, pet.getPetSeq());
				}
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		
	}

	public Pet selectPetmily(Connection conn, int petSeq, int memberSeq) {

		Pet pet = new Pet();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 관리자를 제외한 일반회원만 전체 조회
		String query = "select * from pet where member_seq = ? and pet_seq = ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberSeq);
			pstmt.setInt(2, petSeq);
			rset = pstmt.executeQuery();

			if (rset.next()) {

				// 결과매핑 : 컬럼값 꺼내서 필드에 옮기기
				pet.setPetSeq(rset.getInt("pet_seq"));
				pet.setMemberSeq(rset.getInt("member_seq"));
				pet.setPetName(rset.getString("pet_name"));
				pet.setPetType(rset.getString("pet_type"));
				pet.setPetSize(rset.getString("pet_size"));
				pet.setPetImg(rset.getString("pet_img"));

				pet.typeSelect(pet.getPetType());

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return pet;

	}

	public Pet selectPetSeq(Connection conn, int petSeq) {
		Pet pet = new Pet();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 관리자를 제외한 일반회원만 전체 조회
		String query = "select * from pet where pet_seq = ? ";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, petSeq);
			rset = pstmt.executeQuery();

			if (rset.next()) {

				// 결과매핑 : 컬럼값 꺼내서 필드에 옮기기
				pet.setPetSeq(rset.getInt("pet_seq"));
				pet.setMemberSeq(rset.getInt("member_seq"));
				pet.setPetName(rset.getString("pet_name"));
				pet.setPetType(rset.getString("pet_type"));
				pet.setPetSize(rset.getString("pet_size"));
				pet.setPetImg(rset.getString("pet_img"));

				pet.typeSelect(pet.getPetType());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return pet;

	}

	public int petDelete(Connection conn, Pet pet) {
		int result = 0;

		PreparedStatement pstmt = null;

		String query = "delete from pet where member_seq = ? and pet_seq = ? ";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, pet.getMemberSeq());
			pstmt.setInt(2, pet.getPetSeq());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updatePetNoneImg(Connection conn, Pet pet) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = null;
		
		query = "update pet set pet_name = ?, pet_type = ?, pet_size = ? where member_seq = ? and pet_seq = ?";	
		
		try {
			pstmt = conn.prepareStatement(query);
			
				pstmt.setString(1, pet.getPetName());
				pstmt.setString(2, pet.getPetType());
				pstmt.setString(3, pet.getPetSize());
				pstmt.setInt(4, pet.getMemberSeq());
				pstmt.setInt(5, pet.getPetSeq());
			
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}

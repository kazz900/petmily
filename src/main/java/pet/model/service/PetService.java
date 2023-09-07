package pet.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import pet.model.dao.PetDao;
import pet.model.vo.Pet;

public class PetService {
	
	private PetDao pdao = new PetDao();

	public PetService() {}
	
	public ArrayList<Pet> selectPet(int memberSeq) {
		Connection conn = getConnection();
		ArrayList<Pet> list = pdao.selectList(conn, memberSeq);
		close(conn);
		return list;
	}

	

	public int insertPet(Pet pet) {
		Connection conn = getConnection();
		int result = pdao.insertPet(conn, pet);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updatePet(Pet pet) {
		Connection conn = getConnection();
		int result = pdao.updatePet(conn, pet);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public Pet selectPetmily(int petSeq, int memberSeq) {
		Connection conn = getConnection();
		Pet pet = pdao.selectPetmily(conn, petSeq, memberSeq);
		close(conn);
		return pet;
		
	}

	public Pet selectPetSeq(int petSeq) {
		Connection conn = getConnection();
		Pet pet = pdao.selectPetSeq(conn, petSeq);
		close(conn);
		return pet;
	}

	public int petDelete(Pet pet) {
		Connection conn = getConnection();
		int result = pdao.petDelete(conn, pet);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updatePetNoneImg(Pet pet) {
		Connection conn = getConnection();
		int result = pdao.updatePetNoneImg(conn, pet);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	
}

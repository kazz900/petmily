package pet.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.vo.Member;
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

	

}

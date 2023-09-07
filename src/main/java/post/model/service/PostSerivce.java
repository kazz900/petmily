package post.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import post.model.dao.PostDao;
import post.model.vo.Post;
import standardpost.model.vo.StandardPost;

public class PostSerivce {
	PostDao pdao = new PostDao();
	
	public PostSerivce() {}

	public ArrayList<Post> getPostList() {
		ArrayList<Post> list = null;
		Connection conn = getConnection();

		list = pdao.getPostList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Post> getPostListSortByPopularity() {
		ArrayList<Post> list = null;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		list = pdao.getPostListSortByPopularity(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Post> getMyPostList(int userId) {
		ArrayList<Post> list = null;
		Connection conn = getConnection();

		list = pdao.getMyPostList(conn, userId);
		close(conn);
		return list;
	}
	
	public int insertPost(int memberSeq, Post Post) {
		int result = 0;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		result = pdao.insertPost(conn, memberSeq, Post);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public int updatePost(int memberSeq, Post post) {
		int result = 0;
		Connection conn = getConnection();
		// TODO Auto-generated method stub

		result = pdao.updatePost(conn, memberSeq, post);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public ArrayList<Post> getPostListByType(String postType) {
		ArrayList<Post> list = null;
		Connection conn = getConnection();

		list = pdao.getPostListByType(conn, postType);
		close(conn);
		return list;
	}

	public int deleteImage(Post post) {
		int result = 0;
		Connection conn = getConnection();

		result = pdao.deleteImage(conn, post);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int deletePost(Post post) {
		int result = 0;
		Connection conn = getConnection();

		result = pdao.deletePost(conn, post);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}


	public int checkIfTypeChanged(int postSeq, String postType) {
		int result = 0;
		Connection conn = getConnection();

		result = pdao.checkIfTypeChanged(conn, postSeq, postType);
		
		close(conn);
		return result;
	}

	public Post selectPost(int postSeq, String postType) {
		// TODO Auto-generated method stub
		Post p = null;
		Connection conn = getConnection();

		p = pdao.selectPost(conn, postSeq, postType);
		close(conn);
		return p;
	}
}

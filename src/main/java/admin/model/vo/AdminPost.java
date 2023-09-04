package admin.model.vo;

import java.io.Serializable;

public class AdminPost implements Serializable{

	private static final long serialVersionUID = -6536813911097453263L;
	
	private int postSeq;
	private String memberId;
	private int memberSeq;
	private String memberNick;
	private String postContent;
	private String memberGrade;
	
	
	public AdminPost() {
		super();
	}


	public AdminPost(int postSeq, String memberId, int memberSeq, String memberNick, String postContent,
			String memberGrade) {
		super();
		this.postSeq = postSeq;
		this.memberId = memberId;
		this.memberSeq = memberSeq;
		this.memberNick = memberNick;
		this.postContent = postContent;
		this.memberGrade = memberGrade;
	}


	public int getPostSeq() {
		return postSeq;
	}


	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public int getMemberSeq() {
		return memberSeq;
	}


	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}


	public String getMemberNick() {
		return memberNick;
	}


	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}


	public String getPostContent() {
		return postContent;
	}


	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}


	public String getMemberGrade() {
		return memberGrade;
	}


	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "AdminPost [postSeq=" + postSeq + ", memberId=" + memberId + ", memberSeq=" + memberSeq + ", memberNick="
				+ memberNick + ", postContent=" + postContent + ", memberGrade=" + memberGrade + "]";
	}
	
   	

	
	
}

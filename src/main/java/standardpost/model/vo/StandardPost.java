package standardpost.model.vo;

import java.sql.Date;

import post.model.vo.Post;

public final class StandardPost extends Post implements java.io.Serializable {
	private static final long serialVersionUID = -2455094323948180247L;

	private int postSeq;
	private int memberSeq;
	private String memberId;
	private String postContent;
	private String postImg;
	private int likeNo;
	private int replyNO;
	private Date postDate;
	private Date lastModifiedDate;
	public StandardPost() {
		//TOPUSH
		super();
	}
	public StandardPost(int postSeq, int memberSeq, String postContent, String postImg, int likeNo, int replyNO,
			Date postDate, Date lastModifieddate) {
		super();
		this.postSeq = postSeq;
		this.memberSeq = memberSeq;
		this.postContent = postContent;
		this.postImg = postImg;
		this.likeNo = likeNo;
		this.replyNO = replyNO;
		this.postDate = postDate;
		this.lastModifiedDate = lastModifieddate;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getPostSeq() {
		return postSeq;
	}
	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}
	public int getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostImg() {
		return postImg;
	}
	public void setPostImg(String postImg) {
		this.postImg = postImg;
	}
	public int getLikeNo() {
		return likeNo;
	}
	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}
	public int getReplyNO() {
		return replyNO;
	}
	public void setReplyNO(int replyNO) {
		this.replyNO = replyNO;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Date getLastModifieddate() {
		return lastModifiedDate;
	}
	public void setLastModifieddate(Date lastModifieddate) {
		this.lastModifiedDate = lastModifieddate;
	}
		@Override
	public String toString() {
		return "StandardPost [postSeq=" + postSeq + ", memberSeq=" + memberSeq + ", postContent=" + postContent
				+ ", postImg=" + postImg + ", likeNo=" + likeNo + ", replyNO=" + replyNO + ", postDate=" + postDate
				+ ", lastModifieddate=" + lastModifiedDate + "]";
	}
	
}

package tradepost.model.vo;

import java.sql.Date;

public class TradePost implements java.io.Serializable {
	private static final long serialVersionUID = 3591915937329788194L;

	private int postSeq;
	private int memberSeq;
	private String postContent;
	private String postImg;
	private int likeNo;
	private int replyNO;
	private Date postDate;
	private Date lastModifieddate;
	public TradePost() {
		super();
	}
	public TradePost(int postSeq, int memberSeq, String postContent, String postImg, int likeNo, int replyNO,
			Date postDate, Date lastModifieddate) {
		super();
		this.postSeq = postSeq;
		this.memberSeq = memberSeq;
		this.postContent = postContent;
		this.postImg = postImg;
		this.likeNo = likeNo;
		this.replyNO = replyNO;
		this.postDate = postDate;
		this.lastModifieddate = lastModifieddate;
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
		return lastModifieddate;
	}
	public void setLastModifieddate(Date lastModifieddate) {
		this.lastModifieddate = lastModifieddate;
	}
	@Override
	public String toString() {
		return "StandardPost [postSeq=" + postSeq + ", memberSeq=" + memberSeq + ", postContent=" + postContent
				+ ", postImg=" + postImg + ", likeNo=" + likeNo + ", replyNO=" + replyNO + ", postDate=" + postDate
				+ ", lastModifieddate=" + lastModifieddate + "]";
	}
	
}

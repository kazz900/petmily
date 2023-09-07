package post.model.vo;

import java.sql.Date;

public class Post {
	
	public Post () {
		super();
	}
	
	private int postSeq;
	private int memberSeq;
	private String memberId;
	private String memberNick;
	private String postContent;
	private String postImg;
	private int likeNo;
	private int replyNO;
	private Date postDate;
	private Date lastModifiedDate;
	private String tradeResult;
	private String originalFileName;
	private String changedFileName;
	
	@Override
	public String toString() {
		return "Post [postSeq=" + postSeq + ", memberSeq=" + memberSeq + ", memberId=" + memberId + ", postContent="
				+ postContent + ", postImg=" + postImg + ", likeNo=" + likeNo + ", replyNO=" + replyNO + ", postDate="
				+ postDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	public Post(int postSeq, int memberSeq, String memberId, String postContent, String postImg, int likeNo,
			int replyNO, Date postDate, Date lastModifiedDate, String tradeResult) {
		super();
		this.postSeq = postSeq;
		this.memberSeq = memberSeq;
		this.memberId = memberId;
		this.postContent = postContent;
		this.postImg = postImg;
		this.likeNo = likeNo;
		this.replyNO = replyNO;
		this.postDate = postDate;
		this.lastModifiedDate = lastModifiedDate;
		this.tradeResult = tradeResult;
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getTradeResult() {
		return tradeResult;
	}
	public void setTradeResult(String tradeResult) {
		this.tradeResult = tradeResult;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getChangedFileName() {
		return changedFileName;
	}
	public void setChangedFileName(String changedFileName) {
		this.changedFileName = changedFileName;
	}
}

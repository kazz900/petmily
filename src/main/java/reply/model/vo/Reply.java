package reply.model.vo;

import java.sql.Date;

public class Reply implements java.io.Serializable {
	private static final long serialVersionUID = 6836665688053468270L;

	private int replySeq;
	private int postSeq;
	private int memberSeq;
	private String memberId;
	private String memberNick;
	private String replyContent;
	private Date replyDate;
	public Reply() {
		super();
	}
	public Reply(int replySeq, int postSeq, int memberSeq, String replyContent, Date replyDate) {
		super();
		this.replySeq = replySeq;
		this.postSeq = postSeq;
		this.memberSeq = memberSeq;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
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
	public int getReplySeq() {
		return replySeq;
	}
	public void setReplySeq(int replySeq) {
		this.replySeq = replySeq;
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
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	@Override
	public String toString() {
		return "StandardReply [replySeq=" + replySeq + ", postSeq=" + postSeq + ", memberSeq=" + memberSeq
				+ ", replyContent=" + replyContent + ", replyDate=" + replyDate + "]";
	}
	
}

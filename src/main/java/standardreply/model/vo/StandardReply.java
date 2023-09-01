package standardreply.model.vo;

import java.sql.Date;

public class StandardReply implements java.io.Serializable {
	private static final long serialVersionUID = 6836665688053468270L;

	private int replySeq;
	private int postSeq;
	private String memberSeq;
	private String replyContent;
	private Date replyDate;
	public StandardReply() {
		super();
	}
	public StandardReply(int replySeq, int postSeq, String memberSeq, String replyContent, Date replyDate) {
		super();
		this.replySeq = replySeq;
		this.postSeq = postSeq;
		this.memberSeq = memberSeq;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
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
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
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

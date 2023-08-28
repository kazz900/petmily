package standardlike.model.vo;

public class StandardLike implements java.io.Serializable {
	private static final long serialVersionUID = 3755581056007570622L;
	
	private int postSeq;
	private int memberSeq;
	public StandardLike() {
		super();
	}
	public StandardLike(int postSeq, int memberSeq) {
		super();
		this.postSeq = postSeq;
		this.memberSeq = memberSeq;
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
	@Override
	public String toString() {
		return "StandardLike [postSeq=" + postSeq + ", memberSeq=" + memberSeq + "]";
	}
	
}

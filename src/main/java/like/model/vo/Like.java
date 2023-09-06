package like.model.vo;

public class Like {
	String likeKey;
	int memberSeq;
	int postSeq;
	
	public Like (){
		super();
	}

	public Like(String likeKey, int memberSeq, int postSeq) {
		super();
		this.likeKey = likeKey;
		this.memberSeq = memberSeq;
		this.postSeq = postSeq;
	}

	public String getLikeKey() {
		return likeKey;
	}

	public void setLikeKey(String likeKey) {
		this.likeKey = likeKey;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public int getPostSeq() {
		return postSeq;
	}

	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}

	@Override
	public String toString() {
		return "Like [likeKey=" + likeKey + ", memberSeq=" + memberSeq + ", postSeq=" + postSeq + "]";
	}
	
}

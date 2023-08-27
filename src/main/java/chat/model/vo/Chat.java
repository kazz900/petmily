package chat.model.vo;

public class Chat implements java.io.Serializable {
	private static final long serialVersionUID = -1873129770629368230L;
	
	private int chatSeq;
	private int memberSeq;
	private int otherId;
	private String isEnded;
	
	public Chat() {
		super();
	}
	public Chat(int chatSeq, int memberSeq, int otherId) {
		super();
		this.chatSeq = chatSeq;
		this.memberSeq = memberSeq;
		this.otherId = otherId;
	}
	public int getChatSeq() {
		return chatSeq;
	}
	public void setChatSeq(int chatSeq) {
		this.chatSeq = chatSeq;
	}
	public int getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}
	public int getOtherId() {
		return otherId;
	}
	public void setOtherId(int otherId) {
		this.otherId = otherId;
	}
	public String getIsEnded() {
		return isEnded;
	}
	public void setIsEnded(String isEnded) {
		this.isEnded = isEnded;
	}
	@Override
	public String toString() {
		return "Chat [chatSeq=" + chatSeq + ", memberSeq=" + memberSeq + ", otherId=" + otherId + "]";
	}

}

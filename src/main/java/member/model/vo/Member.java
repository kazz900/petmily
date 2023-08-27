package member.model.vo;

public class Member implements java.io.Serializable {
	private static final long serialVersionUID = -4952932019676617041L;

	private int memberSeq;
	private String memberId;
	private String memberPwd;
	private String memberEmail;
	private String memberNick;
	private String memberGrade;
	public Member() {
		super();
	}
	public Member(int memberSeq, String memberId, String memberPwd, String memberEmail, String memberNick,
			String memberGrade) {
		super();
		this.memberSeq = memberSeq;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberEmail = memberEmail;
		this.memberNick = memberNick;
		this.memberGrade = memberGrade;
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
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	@Override
	public String toString() {
		return "Member [memberSeq=" + memberSeq + ", memberId=" + memberId + ", memberPwd=" + memberPwd
				+ ", memberEmail=" + memberEmail + ", memberNick=" + memberNick + ", memberGrade=" + memberGrade + "]";
	}
	
}

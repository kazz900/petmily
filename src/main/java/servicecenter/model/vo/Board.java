package servicecenter.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable {
	private static final long serialVersionUID = -7473679959559549806L;

	private int brdNo;
	private int memberNo;
	private String brdTitle;
	private String brdContent;
	private Date brdDate;
	private String result;
	private String brdReply;

	public Board() {
		super();
	}

	public Board(int brdNo, String brdTitle, String brdContent, Date brdDate) {
		super();
		this.brdNo = brdNo;
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdDate = brdDate;
	}

	public Board(int brdNo, int memberNo, String brdTitle, String brdContent, Date brdDate, String result, String brdReply) {
		super();
		this.brdNo = brdNo;
		this.memberNo = memberNo;
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdDate = brdDate;
		this.result = result;
		this.brdReply = brdReply;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getBrdTitle() {
		return brdTitle;
	}

	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}

	public String getBrdContent() {
		return brdContent;
	}

	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}

	public Date getBrdDate() {
		return brdDate;
	}

	public void setBrdDate(Date brdDate) {
		this.brdDate = brdDate;
	}

	public int getBrdMemberNo() {
		return memberNo;
	}

	public void setBrdMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getBrdResult() {
		return result;
	}

	public void setBrdResult(String result) {
		this.result = result;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getBrdReply() {
		return brdReply;
	}

	public void setBrdReply(String brdReply) {
		this.brdReply = brdReply;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
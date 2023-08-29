package servicecenter.model.vo;

import java.sql.Date;

public class ServiceCenter implements java.io.Serializable {
	private static final long serialVersionUID = 7025185044200927852L;

	private int servSeq;
	private int memberSeq;
	private String title;
	private String content;
	private Date uploadDate;
	private String result;
	public ServiceCenter() {
		super();
	}
	public ServiceCenter(int servSeq, int memberSeq, String title, String content, Date uploadDate, String result) {
		super();
		this.servSeq = servSeq;
		this.memberSeq = memberSeq;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.result = result;
	}
	public int getServSeq() {
		return servSeq;
	}
	public void setServSeq(int servSeq) {
		this.servSeq = servSeq;
	}
	public int getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ServiceCenter [servSeq=" + servSeq + ", memberSeq=" + memberSeq + ", title=" + title + ", content="
				+ content + ", uploadDate=" + uploadDate + ", result=" + result + "]";
	}
	
}

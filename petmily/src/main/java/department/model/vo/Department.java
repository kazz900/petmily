package department.model.vo;

public class Department implements java.io.Serializable {
	private static final long serialVersionUID = -1084980007355400623L;

	private int deptSeq;
	private String deptType;
	private String deptName;
	private String deptAddress;
	private String deptPhone;
	private String deptLatitude;
	private String deptLongitude;
	private String deptTime;
	private String deptParking;
	private String deptEntrancefee;
	private String deptSizerestrict;
	private String deptRestrict;
	private String deptWithpetfee;
	private String deptUrl;
	private String deptPic;
	public Department() {
		super();
	}
	public Department(int deptSeq, String deptType, String deptName, String deptAddress, String deptPhone,
			String deptLatitude, String deptLongitude, String deptTime, String deptParking, String deptEntrancefee,
			String deptSizerestrict, String deptRestrict, String deptWithpetfee, String deptUrl, String deptPic) {
		super();
		this.deptSeq = deptSeq;
		this.deptType = deptType;
		this.deptName = deptName;
		this.deptAddress = deptAddress;
		this.deptPhone = deptPhone;
		this.deptLatitude = deptLatitude;
		this.deptLongitude = deptLongitude;
		this.deptTime = deptTime;
		this.deptParking = deptParking;
		this.deptEntrancefee = deptEntrancefee;
		this.deptSizerestrict = deptSizerestrict;
		this.deptRestrict = deptRestrict;
		this.deptWithpetfee = deptWithpetfee;
		this.deptUrl = deptUrl;
		this.deptPic = deptPic;
	}
	public int getDeptSeq() {
		return deptSeq;
	}
	public void setDeptSeq(int deptSeq) {
		this.deptSeq = deptSeq;
	}
	public String getDeptType() {
		return deptType;
	}
	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptAddress() {
		return deptAddress;
	}
	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}
	public String getDeptPhone() {
		return deptPhone;
	}
	public void setDeptPhone(String deptPhone) {
		this.deptPhone = deptPhone;
	}
	public String getDeptLatitude() {
		return deptLatitude;
	}
	public void setDeptLatitude(String deptLatitude) {
		this.deptLatitude = deptLatitude;
	}
	public String getDeptLongitude() {
		return deptLongitude;
	}
	public void setDeptLongitude(String deptLongitude) {
		this.deptLongitude = deptLongitude;
	}
	public String getDeptTime() {
		return deptTime;
	}
	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}
	public String getDeptParking() {
		return deptParking;
	}
	public void setDeptParking(String deptParking) {
		this.deptParking = deptParking;
	}
	public String getDeptEntrancefee() {
		return deptEntrancefee;
	}
	public void setDeptEntrancefee(String deptEntrancefee) {
		this.deptEntrancefee = deptEntrancefee;
	}
	public String getDeptSizerestrict() {
		return deptSizerestrict;
	}
	public void setDeptSizerestrict(String deptSizerestrict) {
		this.deptSizerestrict = deptSizerestrict;
	}
	public String getDeptRestrict() {
		return deptRestrict;
	}
	public void setDeptRestrict(String deptRestrict) {
		this.deptRestrict = deptRestrict;
	}
	public String getDeptWithpetfee() {
		return deptWithpetfee;
	}
	public void setDeptWithpetfee(String deptWithpetfee) {
		this.deptWithpetfee = deptWithpetfee;
	}
	public String getDeptUrl() {
		return deptUrl;
	}
	public void setDeptUrl(String deptUrl) {
		this.deptUrl = deptUrl;
	}
	public String getDeptPic() {
		return deptPic;
	}
	public void setDeptPic(String deptPic) {
		this.deptPic = deptPic;
	}
	@Override
	public String toString() {
		return "Department [deptSeq=" + deptSeq + ", deptType=" + deptType + ", deptName=" + deptName + ", deptAddress="
				+ deptAddress + ", deptPhone=" + deptPhone + ", deptLatitude=" + deptLatitude + ", deptLongitude="
				+ deptLongitude + ", deptTime=" + deptTime + ", deptParking=" + deptParking + ", deptEntrancefee="
				+ deptEntrancefee + ", deptSizerestrict=" + deptSizerestrict + ", deptRestrict=" + deptRestrict
				+ ", deptWithpetfee=" + deptWithpetfee + ", deptUrl=" + deptUrl + ", deptPic=" + deptPic + "]";
	}
}

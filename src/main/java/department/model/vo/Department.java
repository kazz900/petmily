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
   private String deptInsertOk;
   private String deptDeleteOk;
   
   public Department() {
      super();
   }

   public Department(int deptSeq, String deptType, String deptName, String deptAddress, String deptPhone,
		   String deptLatitude, String deptLongitude, String deptTime, String deptParking, String deptEntrancefee,
         String deptSizerestrict, String deptRestrict, String deptWithpetfee, String deptUrl, String deptPic,
         String deptInsertOk, String deptDeleteOk) {
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
      this.deptInsertOk = deptInsertOk;
      this.deptDeleteOk = deptDeleteOk;
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
   

   
   public String getDeptInsertOk() {
      return deptInsertOk;
   }

   public void setDeptInsertOk(String deptInsertOk) {
      this.deptInsertOk = deptInsertOk;
   }

   public String getDeptDeleteOk() {
      return deptDeleteOk;
   }

   public void setDeptDeleteOk(String deptDeleteOk) {
      this.deptDeleteOk = deptDeleteOk;
   }

   public static long getSerialversionuid() {
      return serialVersionUID;
   }

   @Override
   public String toString() {
      return "Department [deptSeq=" + deptSeq + ", deptType=" + deptType + ", deptName=" + deptName + ", deptAddress="
            + deptAddress + ", deptPhone=" + deptPhone + ", deptLatitude=" + deptLatitude + ", deptLongitude="
            + deptLongitude + ", deptTime=" + deptTime + ", deptParking=" + deptParking + ", deptEntrancefee="
            + deptEntrancefee + ", deptSizerestrict=" + deptSizerestrict + ", deptRestrict=" + deptRestrict
            + ", deptWithpetfee=" + deptWithpetfee + ", deptUrl=" + deptUrl + ", deptPic=" + deptPic + "]";
   }
   public void typeSelect() {
      if(this.deptType.contains("1/2")) {
         setDeptType("의료, 미용");
      }else if(this.deptType.equals("1")){
         setDeptType("의료");
      }else if(this.deptType.equals("2")){
         setDeptType("미용");
      }else if(this.deptType.equals("3")){
         setDeptType("용품");
      }else if(this.deptType.equals("4")){
         setDeptType("위탁");
      }else if(this.deptType.equals("5")){
         setDeptType("장묘");
      }else if(this.deptType.equals("6")){
         setDeptType("카페,식당");
      }else if(this.deptType.equals("7")){
         setDeptType("펜션/호텔");
      }else{
         setDeptType("여행/문화");
      }
   }
   
   public void parkingSelect() {
      if(this.deptParking.equals("0")) {
         setDeptParking("주차불가");
      }else {
         setDeptParking("주차가능");
      }
   }
   public void entranceFee() {
      if(this.deptEntrancefee.equals("0")) {
         setDeptEntrancefee("입장료 있음");
      }else {
         setDeptEntrancefee("입장료 없음");
      }
   }
   public void sizeSelect() {
      if(this.deptSizerestrict.equals("0")) {
         setDeptSizerestrict("제한사항 없음");
      }else if(this.deptSizerestrict.equals("1")) {
         setDeptSizerestrict("소형");
      }else if(this.deptSizerestrict.equals("2")) {
         setDeptSizerestrict("중형");
      }else {
         setDeptSizerestrict("대형");
      }
   }
}
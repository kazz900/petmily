package pet.model.vo;

public class Pet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7499976768809950717L;
	
	private int petSeq;
	private int memberSeq;
	private String petName;
	private String petType;
	private String petSize;
	private String petImg;
	public Pet() {
		super();
	}
	public Pet(int petSeq, int memberSeq, String petName, String petType, String petSize, String petImg) {
		super();
		this.petSeq = petSeq;
		this.memberSeq = memberSeq;
		this.petName = petName;
		this.petType = petType;
		this.petSize = petSize;
		this.petImg = petImg;
	}
	public int getPetSeq() {
		return petSeq;
	}
	public void setPetSeq(int petSeq) {
		this.petSeq = petSeq;
	}
	public int getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	public String getPetSize() {
		return petSize;
	}
	public void setPetSize(String petSize) {
		this.petSize = petSize;
	}
	public String getPetImg() {
		return petImg;
	}
	public void setPetImg(String petImg) {
		this.petImg = petImg;
	}
	@Override
	public String toString() {
		return "Pet [petSeq=" + petSeq + ", memberSeq=" + memberSeq + ", petName=" + petName + ", petType=" + petType
				+ ", petSize=" + petSize + ", petImg=" + petImg + "]";
	}
	

	public void typeSelect(String value) {
		if(this.petType.equals("0")) {
			setPetType("고양이");
		}else if(this.petType.equals("1")){
			setPetType("강아지");
		}else if(this.petType.equals("2")){
			setPetType("모든 동물");
		}
	}
	
	

	
	
}
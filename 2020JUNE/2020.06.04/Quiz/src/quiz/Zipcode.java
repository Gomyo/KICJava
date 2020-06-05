package quiz;

// 데이터 저장 클래스(데이터의 열과 1:1 mapping되는 멤버를 가진다)
// 이론에 의해서 클래스 역할을 분리 - Pattern이라고 함. 클래스를 어떻게 배치해야 가장 효과적인 방법이 되는가?
// TO(Transfer Object) / VO(Value Object)
public class Zipcode {
	private String seq;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getRi() {
		return ri;
	}
	public void setRi(String ri) {
		this.ri = ri;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	private String code;
	private String sido;
	private String gugun;
	private String dong;
	private String ri;
	private String bunji;
}

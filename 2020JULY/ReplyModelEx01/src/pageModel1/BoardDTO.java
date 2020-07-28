package pageModel1;

public class BoardDTO {
	private String seq;
	private String subject;
	private String writer;
	private String mail;
	private String password;
	private String content;
	private String emot;
	private String emots;
	private String hit;
	private String wip;
	private String wdate;
	private String[] modifyMail;
	private int grp;
	private int grps;
	private int grpl;
	private int wgap;
	private String cpage;
	
	public int getGrp() {
		return grp;
	}
	public void setGrp(int grp) {
		this.grp = grp;
	}
	public int getGrps() {
		return grps;
	}
	public void setGrps(int grps) {
		this.grps = grps;
	}
	public int getGrpl() {
		return grpl;
	}
	public void setGrpl(int grpl) {
		this.grpl = grpl;
	}
	public String getEmots() {
		return emots;
	}
	public void setEmots(String emots) {
		this.emots = emots;
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmot() {
		return emot;
	}
	public void setEmot(String emot) {
		this.emot = emot;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getWip() {
		return wip;
	}
	public void setWip(String wip) {
		this.wip = wip;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getWgap() {
		return wgap;
	}
	public void setWgap(int wgap) {
		this.wgap = wgap;
	}
	public String getCpage() {
		return cpage;
	}
	public void setCpage(String cpage) {
		this.cpage = cpage;
	}
	public String[] getModifyMail() {
		return modifyMail;
	}
	public void setModifyMail(String[] modifyMail) {
		this.modifyMail = modifyMail;
	}
	
	
}
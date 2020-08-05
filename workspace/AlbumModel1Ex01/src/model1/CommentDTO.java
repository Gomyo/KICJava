package model1;

import java.util.ArrayList;

public class CommentDTO {
	private String cwriter;
	private String cpassword;
	private String ccontent;
	private String wdate;
	private String seq;
	private int commentAll;
	private int wgap;
	private ArrayList<CommentDTO> commentList;
	
	public String getCwriter() {
		return cwriter;
	}
	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
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
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public ArrayList<CommentDTO> getCommentList() {
		return commentList;
	}
	public void setCommentList(ArrayList<CommentDTO> commentList) {
		this.commentList = commentList;
	}
	public int getCommentAll() {
		return commentAll;
	}
	public void setCommentAll(int commentAll) {
		this.commentAll = commentAll;
	}
	
}

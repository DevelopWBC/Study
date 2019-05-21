package cn.wzw.util;

public class Code {
	private int status; //状态码
	private String msg; //信息
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Code(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
}

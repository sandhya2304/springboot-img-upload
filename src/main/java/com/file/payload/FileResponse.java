package com.file.payload;




public class FileResponse 
{
	String fileName;
	String msg;
	
	
	public FileResponse(String fileName, String msg) {
		super();
		this.fileName = fileName;
		this.msg = msg;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}

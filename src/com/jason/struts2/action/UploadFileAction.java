package com.jason.struts2.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class UploadFileAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -544171173810449785L;
	
	
	private File myFile;
	
	private String myFileContentType;
	
	private String myFileFileName;
	
	private String destPath;
	
	public String execute() throws Exception {
		destPath = "C:/testBook/";
		try{
			System.out.println("Src File Name "+myFile);
			System.out.println("Dest File Name "+myFileFileName);
			File destFile = new File(destPath, myFileFileName);
			FileUtils.copyFile(myFile, destFile);
		}catch(IOException e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

}

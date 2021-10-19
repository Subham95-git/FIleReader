package com.subham.filereader.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class FileDTO{
	
	long fileCount;
	double fileSize;
	
	public FileDTO(long fileCount, double fileSize) {
		super();
		this.fileCount = fileCount;
		this.fileSize = fileSize;
	}

	public long getFileCount() {
		return fileCount;
	}

	public void setFileCount(long fileCount) {
		this.fileCount = fileCount;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "FileDTO [fileCount=" + fileCount + ", fileSize=" + fileSize + "]";
	}
	
	
	
	
}

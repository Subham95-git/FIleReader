package com.subham.filereader.utility;

import java.io.File;
import java.io.FilenameFilter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import com.subham.filereader.dto.FileDTO;

public class FileFilter implements FilenameFilter {
	
	private String[] allowedExtensions = null;
	 
    public FileFilter(String[] allowedExtensions) {
        this.allowedExtensions = allowedExtensions.clone();
    }

	@Override
	public boolean accept(File dir, String name) {
		String fileExt = name.substring(name.lastIndexOf(".") + 1);
        for (String imgExt : allowedExtensions) {
            if (imgExt.compareToIgnoreCase(fileExt) == 0)
                return true;
        }
        return false;
	}
	
	public static Map<String, FileDTO> printFiles(File inputDirectory, String[] filters, String filetype) {
		
		Map<String, FileDTO> data = new HashMap<>();
		DecimalFormat df = new DecimalFormat("#.###");
		 
		long fileCount=0;
		double fileSize=0;
        File[] files = inputDirectory.listFiles(new FileFilter(filters));
        for (File file : files) {
            System.out.println(file.getName());
            fileCount++;
            fileSize+=file.length();
        }
        
        double fileSizeMB = fileSize/(1024*1024);
        
        	data.put(filetype, new FileDTO(fileCount, (double)Math.round(fileSizeMB* 100d)/ 100d));
        
       
        
        System.out.println("Total file count "+fileCount+" total file size "+fileSize/(1024*1024)+" MB");
        
        return data;
    }

}

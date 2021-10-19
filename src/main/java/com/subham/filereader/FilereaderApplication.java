package com.subham.filereader;

import java.io.File;
import java.nio.file.FileSystems;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.subham.filereader.utility.FileFilter;

@SpringBootApplication
public class FilereaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilereaderApplication.class, args);
	}


//	@Override
//	public void run(String[] args) {
//		File directory = new File("C:\\Users\\ASUS\\Desktop\\Needful Docs");
//		
//		String[] videoFileFilters = {"avi", "wmv", "mov", "mp4"};
//		
//		String[] imageFileFilters = {"jpg", "png", "tif", "jpeg"};
//		
//		String[] txtFileFilters = {"txt"};
//		
//		String[] docFilter = {"docs","pdf"};
//		
//		System.out.println("\n1. Listing video files present in input directory");
//        printFiles(directory, videoFileFilters, "video");
//		
//		System.out.println("\n2. Listing image files present in input directory");
//        printFiles(directory, imageFileFilters, "image");
//        
//        System.out.println("\n3. Listing text files present in input directory");
//        printFiles(directory, txtFileFilters, "text");
//        
//        System.out.println("\n4. Listing document files present in input directory");
//        printFiles(directory, docFilter, "document");
//	}
//	
//	public static void printFiles(File inputDirectory, String[] filters, String filetype) {
//		 
//		long fileCount=0;
//		long fileSize=0;
//        File[] files = inputDirectory.listFiles(new FileFilter(filters));
//        for (File file : files) {
//            System.out.println(file.getName());
//            fileCount++;
//            fileSize+=file.length();
//        }
//        
//        System.out.println("Total file count "+fileCount+" total file size "+fileSize/(1024*1024)+" MB");
//    }
	
}

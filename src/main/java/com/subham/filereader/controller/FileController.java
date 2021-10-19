package com.subham.filereader.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.subham.filereader.dto.FileDTO;
import com.subham.filereader.utility.FileFilter;

@RestController
public class FileController {

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/getstatus", produces = "application/json")
	public Map<String, Long> getFolderStatus() {

		Map<String, Long> data = new HashMap<>();

		for (Path root : FileSystems.getDefault().getRootDirectories()) {


			try {
				FileStore store = Files.getFileStore(root);
				System.out.println("available=" + store.getUsableSpace()/(1024*1024*1024)
						+ " GB, total=" + store.getTotalSpace()/(1024*1024*1024));
				long available = store.getUsableSpace()/(1024*1024*1024);
				long total = store.getTotalSpace()/(1024*1024*1024);

				data.put("available", available);
				data.put("used", total-available);

			} catch (IOException e) {
				System.out.println("error querying space: " + e.toString());
			}
		}

		return data;
	}


	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/getFilecountBy", produces = "application/json")
	public Map<String, FileDTO> getFileCountByTypeInFolder(@RequestParam String dir){
		
		Map<String, FileDTO> data = new HashMap<>();
		
		Decoder decoder = Base64.getUrlDecoder();
		byte[] bytes = decoder.decode(dir);
		String direc = new String(bytes);
		System.out.println("After Decoding.............\n");
		System.out.println(new String(bytes));
		
		File directory = new File(direc);

		String[] videoFileFilters = {"avi", "wmv", "mov", "mp4"};

		String[] imageFileFilters = {"jpg", "png", "tif", "jpeg", "ico"};

		String[] txtFileFilters = {"txt"};
		
		String[] excelFilters = {"xls", "xlsx"};

		String[] docFilter = {"docs","pdf"};
		
		System.out.println("\n1. Listing video files present in input directory");
		data.putAll(FileFilter.printFiles(directory, videoFileFilters, "video"));
		
		System.out.println("\n2. Listing image files present in input directory");
		data.putAll(FileFilter.printFiles(directory, imageFileFilters, "image"));
        
        System.out.println("\n3. Listing text files present in input directory");
        data.putAll(FileFilter.printFiles(directory, txtFileFilters, "text"));
        
        System.out.println("\n4. Listing document files present in input directory");
        data.putAll(FileFilter.printFiles(directory, docFilter, "document"));
        
        System.out.println("\n5. Listing excel files present in input directory");
        data.putAll(FileFilter.printFiles(directory, excelFilters, "excel"));
		
		return data;
	}
}

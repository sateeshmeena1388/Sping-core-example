package com.mhb.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service("listUploaedFiles")
public class ListUploaedFilesImpl implements ListUploaedFiles {
private static final String UPLOAD_BAS_DIR="D:/springuploads";
	@Override
	public List<String> getAllListFiles() {
		// TODO Auto-generated method stub
		File uploadFolder=null;
		File files[]=null;
		List<String> filesList=null;
		//locate upload folder
		uploadFolder=new File(UPLOAD_BAS_DIR);
		files=uploadFolder.listFiles();
		filesList=new ArrayList<>();
		for(File file:files){
			if(!file.isDirectory()){
				filesList.add(file.getName());
			}
		}
		return filesList;
	}

}

package com.mhb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mhb.service.ListUploaedFiles;

@Controller
public class FileDownLoadController {
	private static final String UPLOAD_BASE_DIR="D:/springuploads";
	@Autowired
	private ListUploaedFiles service;
	
	@RequestMapping(value="/home.htm")
	public String showHomePage(){
		return "home";
	}
	
	@RequestMapping(value="/list_files.htm")
public void showUploadFiles(Map<String, Object>map){
	List<String> filesList=null;
	//use service
	filesList=service.getAllListFiles();
	map.put("filesList", filesList);
}
	@RequestMapping(value="download.htm")
	public String download(@RequestParam("file_name")String fname,HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		System.out.println("file_name::"+fname);
		File file=null;
		InputStream is =null;
		OutputStream os=null;
		
		//make browser to make recived content as downloadable file
		res.addHeader("Content-Disposition","attachement;fileName="+fname);
		// locate file
		file=new File(UPLOAD_BASE_DIR+"/"+fname);
		//get file MIME type and set its as response content type
		res.setContentType(req.getServletContext().getMimeType(file.getAbsolutePath()));
		//take file length as response content length
		res.setContentLength((int)file.length());
		//create inputstream pointing to the file be downloaded
		is=new FileInputStream(file);
		//create outputSream pointing ti the response objs
		os=res.getOutputStream();
		IOUtils.copy(is, os);
		res.flushBuffer();
		is.close();os.close();
		return null;
	} 
}

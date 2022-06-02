package com.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.payload.FileResponse;
import com.file.service.FileService;



@RestController
@RequestMapping("/file")
public class FileController 
{
	
	@Autowired
	private FileService service;
	
	@Value("${project.image}")
	String path;
	
	@PostMapping(value="/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image)
	{
	    String fileName	 =  null;
	    		
	    try
	    {
	    		fileName = service.uploadImage(path, image);
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    	return new ResponseEntity<>(new FileResponse(null, "file not upload"),HttpStatus.INTERNAL_SERVER_ERROR);
	    	
	    }
	    return new ResponseEntity<>(new FileResponse(fileName, "file upload"),HttpStatus.OK);
	}
	

}

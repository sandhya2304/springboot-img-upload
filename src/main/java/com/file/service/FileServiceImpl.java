package com.file.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileServiceImpl implements FileService
{

	
	@Override
	public String uploadImage(String path, MultipartFile file)
	{
		String name = file.getOriginalFilename();
		
		try
		{
		
			String randomid = UUID.randomUUID().toString();
			String filename1 = randomid.concat(name.substring(name.lastIndexOf(".")));
			
			
		String filepath = path + File.separator + filename1;
	
		
		//create folder if not exist
		File ff = new File(path);
		if(!ff.exists())
		{
		    ff.mkdir();
		}
		
		//file copy
		Files.copy(file.getInputStream(),Paths.get(filepath));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return name;
	}
	
	
	
	

}

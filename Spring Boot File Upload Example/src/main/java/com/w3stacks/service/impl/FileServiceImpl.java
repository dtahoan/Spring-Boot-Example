package com.w3stacks.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.w3stacks.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadFile(MultipartFile multipartFile) {
	
		if(multipartFile.isEmpty()) {
			// Throw Exception (400, "Uploaded file must not empty")
			return null;
		}
		
		Matcher m = Pattern.compile("(.+)\\.(.+)").matcher(multipartFile.getOriginalFilename());
		if (m.matches()) {
			String ext = m.group(2);
			String name = m.group(1);

			if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpeg") 
					|| ext.equalsIgnoreCase("7z") || ext.equalsIgnoreCase("rar") || ext.equalsIgnoreCase("zip")) {
				try {
					Date date = new Date(System.currentTimeMillis());

					String folderPath = new SimpleDateFormat("yyyy-MM-dd").format(date);
					new File("/opt/tomcat/webapps/uploads/" + folderPath).mkdirs();

					String filePath = folderPath + "/" + name + "_" + String.valueOf(System.currentTimeMillis()) + "."
							+ ext;

					File file = new File("/opt/tomcat/webapps/uploads/" + filePath);

					byte[] bytes = multipartFile.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
					stream.write(bytes);
					stream.close();

					return filePath;
					
				} catch (IOException e) {
					e.printStackTrace();
					// Throw Exception (400, "Uploaded file must not empty");
					return null;
				}
			} else {
				// Throw Exception (400, "File extension isn't supported");
				return null;
			}
		} else {
			// Throw Exception (400, "File extension isn't supported");
			return null;
		}
	}

}

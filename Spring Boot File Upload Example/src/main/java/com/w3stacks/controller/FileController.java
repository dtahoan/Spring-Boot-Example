package com.w3stacks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.w3stacks.service.FileService;

@Controller
@RequestMapping("/files")
public class FileController {

	@Autowired
	private FileService fileService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView fileIndex() {
		
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/jsp/files/index.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public RedirectView upload(
			
			@RequestParam("file") MultipartFile file) {
		
		String redirectResponse = fileService.uploadFile(file);
	
		return new RedirectView("/uploads/" + redirectResponse);
	}
}

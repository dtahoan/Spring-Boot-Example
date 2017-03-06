package com.w3stacks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w3stacks.entity.Framework;
import com.w3stacks.service.FrameworkService;

@RestController
@RequestMapping("/api/v1/frameworks")
public class FrameworkController {

	@Autowired
	private FrameworkService frameworkService;
	
	@RequestMapping(value = "")
	public List<Framework> getList() {
		return frameworkService.getList();
	}
}

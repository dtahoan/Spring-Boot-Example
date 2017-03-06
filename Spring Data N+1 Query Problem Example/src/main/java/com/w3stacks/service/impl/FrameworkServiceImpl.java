package com.w3stacks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w3stacks.entity.Framework;
import com.w3stacks.repository.FrameworkRepository;
import com.w3stacks.service.FrameworkService;

@Service
public class FrameworkServiceImpl implements FrameworkService {

	@Autowired
	private FrameworkRepository frameworkRepository;
	
	@Override
	public List<Framework> getList() {
		
		List<Framework> result = frameworkRepository.findAll();
		
		return result;
	}

}

package com.w3stacks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

import com.w3stacks.entity.Framework;

public interface FrameworkRepository extends JpaRepository<Framework, Long> {

	@EntityGraph(value = "graph.FrameworkLanguage", type = EntityGraphType.LOAD)
	List<Framework> findAll();
}

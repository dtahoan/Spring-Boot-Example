package com.w3stacks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w3stacks.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {

}

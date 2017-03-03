package com.w3stacks;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.w3stacks.entity.Framework;
import com.w3stacks.entity.Language;
import com.w3stacks.repository.LanguageRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext appContext = SpringApplication.run(Application.class, args);
		
		LanguageRepository languageRepo = appContext.getBean(LanguageRepository.class);
		
		Language language = new Language();
		language.setName("PHP");
		
		Framework cakePhpFramework = new Framework("Cake PHP", "Fullstack");
		Framework laravelFramework = new Framework("Laravel", "Fullstack");
		Framework slimFramework = new Framework("Slim", "Micro");
		
		language.setFrameworks(new ArrayList<Framework>());
		language.getFrameworks().add(cakePhpFramework);
		language.getFrameworks().add(laravelFramework);
		language.getFrameworks().add(slimFramework);
		
		cakePhpFramework.setLanguage(language);
		laravelFramework.setLanguage(language);
		slimFramework.setLanguage(language);
		
		languageRepo.save(language);
		
	}
}

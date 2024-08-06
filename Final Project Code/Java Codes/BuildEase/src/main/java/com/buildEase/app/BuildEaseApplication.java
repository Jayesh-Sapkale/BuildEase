package com.buildEase.app;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.buildEase.entities.BaseClass;

@SpringBootApplication
public class BuildEaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildEaseApplication.class, args);
		

	}

	@Bean
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.STRICT)
		.setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}
}
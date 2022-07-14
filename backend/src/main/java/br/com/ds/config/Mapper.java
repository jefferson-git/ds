package br.com.ds.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
	
	@Bean
	public ModelMapper mp() {
		return new ModelMapper();
	}

}

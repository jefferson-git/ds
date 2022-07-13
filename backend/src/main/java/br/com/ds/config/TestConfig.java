package br.com.ds.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("test")
public class TestConfig {
	
	@Bean
	public void CriandoDados() {
	
		
	}

}

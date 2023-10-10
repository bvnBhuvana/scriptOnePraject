package com.slokam.scriptone;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
//@EnableResourceServer
public class ScriptOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScriptOneApplication.class, args);
		
	
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}

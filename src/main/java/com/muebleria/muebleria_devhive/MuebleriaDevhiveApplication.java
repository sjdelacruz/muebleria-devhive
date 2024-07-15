package com.muebleria.muebleria_devhive;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableDiscoveryClient
public class MuebleriaDevhiveApplication {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MuebleriaDevhiveApplication.class, args);
	}

}

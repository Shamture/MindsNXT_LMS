package com.minds.lms.springboot2jpacrud;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.minds.lms.springboot2jpacrud.controller.FileUploadController;


@SpringBootApplication

public class MindsNxtLmsApplication {

	public static void main(String[] args) {
		
		new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(MindsNxtLmsApplication.class, args);
	}

}


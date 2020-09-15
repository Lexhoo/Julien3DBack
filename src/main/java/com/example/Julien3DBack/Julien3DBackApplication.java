package com.example.Julien3DBack;

import com.example.Julien3DBack.Storage.StorageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Julien3DBackApplication {

	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(Julien3DBackApplication.class, args);
	}


}

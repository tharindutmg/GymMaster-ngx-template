package com.gym;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.gym.util.CommonFileActions;
import com.gym.util.CommonFilePath;

@EnableJpaAuditing
@SpringBootApplication
public class GymApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GymApiApplication.class, args);
	}
	
	@Override
	public void run(String... arg) throws Exception {
		//CommonFileActions.createDirectory(CommonFilePath.mainUserImageDIR);
	}
	
	

}


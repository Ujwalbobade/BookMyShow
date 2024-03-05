package com.example.BookMyShow;

import com.example.BookMyShow.Controller.UserController;
import com.example.BookMyShow.DTOs.SignupReqDTO;
import com.example.BookMyShow.DTOs.SignupResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {
	@Autowired
	private UserController userController;
	public static void main(String[] args) {

		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SignupReqDTO signupReqDTO = new SignupReqDTO();
		signupReqDTO.setEmail("ujwalbobade03@gmail.com");
		signupReqDTO.setPasoword("Ujwal@111");

		SignupResDTO response = userController.signup(signupReqDTO);
	}
}

//create show funtionality
//and run the booking service
//implement chnaged user email id


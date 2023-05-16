package com.example.demo;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	CommandLineRunner run(UserService userService){
//		return args -> {
//			userService.saveRole(new Role(null,"ROLE_USER"));
//			userService.saveRole(new Role(null,"ROLE_MANAGER"));
//			userService.saveRole(new Role(null,"ROLE_ADMIN"));
//
//			userService.saveUser(new User(null,"Cao Tuyen","tuyen","caotuyen@gmail.com","123456",new HashSet<>()));
//			userService.saveUser(new User(null,"Huyen Trang","trang","huyentrang@gmail.com","123456",new HashSet<>()));
//
//			userService.addToUser("caotuyen@gmail.com","ROLE_ADMIN");
//			userService.addToUser("caotuyen@gmail.com","ROLE_MANAGER");
//			userService.addToUser("caotuyen@gmail.com","ROLE_USER");
//
//			userService.addToUser("huyentrang@gmail.com","ROLE_USER");
//
//
//
//
//		};
//	}
}

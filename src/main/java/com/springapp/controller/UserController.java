package com.springapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.model.User;
import com.springapp.request.UserRequest;
import com.springapp.response.MessageResponse;
import com.springapp.respository.UserRepository;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@Service 
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
@Api(tags = "User", description = "Service menage create user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("")
	public Object registerUser(@Valid @RequestBody UserRequest userRequest) {
		if (userRepository.existsByUsername(userRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse(" O nome de usuário já foi usado!"));
		}

		if (userRepository.existsByEmail(userRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("O e-mail já está sendo usado!"));
		}
		
		LocalDateTime localDateTime = LocalDateTime.now();

		var user = User.builder()
				.password(getEncryptor(userRequest.getPassword()))
				.email(userRequest.getEmail())
				.username(userRequest.getUsername())
		        .createdAt(localDateTime)
				.build();

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("Usuário cadastrado com sucesso!"));
	}
	
   @GetMapping
   public List<User> listAll(){
       return userRepository.findAll();
   }
   
   public static String getEncryptor(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

}

package com.example.personal_trainer_app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personal_trainer_app.domain.users.RequestEmailAndSenha;
import com.example.personal_trainer_app.domain.users.RequestUsers;
import com.example.personal_trainer_app.domain.users.Users;
import com.example.personal_trainer_app.domain.users.UsersRepository;

@RestController
@RequestMapping("/home")
public class LoginController {
	@Autowired
	private UsersRepository usersRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody RequestEmailAndSenha data) {
	    Optional<Users> user = usersRepository.findByEmailAndSenha(data.email(), data.senha());
	    if (user.isPresent()) {
	        return ResponseEntity.ok("Login autorizado!");
	    } else {
	        return ResponseEntity.status(401).body("Credenciais inválidas.");
	    }
	}
    
    @PostMapping("/cadastro")
    public ResponseEntity registerUser(@RequestBody @Validated RequestUsers data) {
        Users newUsers = new Users(data);
        usersRepository.save(newUsers);
        return ResponseEntity.ok().build();
    }

}

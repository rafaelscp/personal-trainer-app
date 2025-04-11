package com.example.personal_trainer_app.domain.users;

public record RequestUsers(
		String nome, 
		String email, 
		String senha, 
		String tipo) {

}

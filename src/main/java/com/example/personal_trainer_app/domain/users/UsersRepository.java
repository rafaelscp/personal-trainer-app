package com.example.personal_trainer_app.domain.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Optional<Users> findByEmailAndSenha(String email, String senha);
	
}

package com.example.personal_trainer_app.domain.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String tipo;
	
	
	public Users(RequestUsers requestUsers) {
		this.nome = requestUsers.nome();
		this.email = requestUsers.email();
		this.senha = requestUsers.senha();
		this.tipo = requestUsers.tipo();
	}
}

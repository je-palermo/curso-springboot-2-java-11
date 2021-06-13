package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

//Classe que representa os recursos basicos da classe User

@RestController // Recurso Web implementado (REST)
@RequestMapping(value = "/users") // Nome para o recurso (value = "/users") -> Recurso relacionado a classe User
public class UserResource {
	
	//Método que será um endpoint para acessar os usuários
	//ResponseEntity -> Tipo especifico do Spring para retornar respostas de requisições web
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "982702239", "1234");
		return ResponseEntity.ok().body(u);
	}
	

}

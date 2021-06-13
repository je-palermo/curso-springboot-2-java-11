package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserServices;

//Classe que representa os recursos basicos da classe User

@RestController // Recurso Web implementado (REST)
@RequestMapping(value = "/users") // Nome para o recurso (value = "/users") -> Recurso relacionado a classe User
public class UserResource {
	
	@Autowired
	private UserServices service;
	
	//Método que será um endpoint para acessar os usuários
	//ResponseEntity -> Tipo especifico do Spring para retornar respostas de requisições web
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// Endpoint para buscar um usuario por Id
	@GetMapping(value = "/{id}") // Indica que a requisição aceitará um ID dentro da URL
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}

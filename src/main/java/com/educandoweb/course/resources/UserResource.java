package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		// Para retornar um 201 é esperado que a resposta contenha um cabecalho,
		// chamado Locale contendo o endereço do novo recurso que foi inserido
		// Forma padrão de gerar o endereço 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "{/id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		// noContent() retorna uma resposta vazia, e o código http de uma resposta 
		// que não tem conteúdo é o 204 que será tratado pelo método noContent()
		return ResponseEntity.noContent().build();
	}

}

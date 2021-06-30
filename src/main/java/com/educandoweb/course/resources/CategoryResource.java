package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryServices;

//Classe que representa os recursos basicos da classe Category

@RestController // Recurso Web implementado (REST)
@RequestMapping(value = "/categories") // Nome para o recurso (value = "/users") -> Recurso relacionado a classe Category
public class CategoryResource {
	
	@Autowired
	private CategoryServices service;
	
	//Método que será um endpoint para acessar os usuários
	//ResponseEntity -> Tipo especifico do Spring para retornar respostas de requisições web
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// Endpoint para buscar um usuario por Id
	@GetMapping(value = "/{id}") // Indica que a requisição aceitará um ID dentro da URL
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}

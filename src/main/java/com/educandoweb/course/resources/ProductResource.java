package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProcuctServices;


//Classe que representa os recursos basicos da classe Product

@RestController // Recurso Web implementado (REST)
@RequestMapping(value = "/products") // Nome para o recurso (value = "/users") -> Recurso relacionado a classe Product
public class ProductResource {
	
	@Autowired
	private ProcuctServices service;
	
	//Método que será um endpoint para acessar os usuários
	//ResponseEntity -> Tipo especifico do Spring para retornar respostas de requisições web
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// Endpoint para buscar um usuario por Id
	@GetMapping(value = "/{id}") // Indica que a requisição aceitará um ID dentro da URL
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}

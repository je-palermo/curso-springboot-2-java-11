package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderServices;

//Classe que representa os recursos basicos da classe Order

@RestController // Recurso Web implementado (REST)
@RequestMapping(value = "/orders") // Nome para o recurso (value = "/Orders") -> Recurso relacionado a classe Order
public class OrderResource {
	
	@Autowired
	private OrderServices service;
	
	//Método que será um endpoint para acessar os usuários
	//ResponseEntity -> Tipo especifico do Spring para retornar respostas de requisições web
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// Endpoint para buscar um usuario por Id
	@GetMapping(value = "/{id}") // Indica que a requisição aceitará um ID dentro da URL
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}

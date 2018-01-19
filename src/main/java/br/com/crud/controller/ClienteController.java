package br.com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.crud.model.Cliente;
import br.com.crud.service.ClienteService;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService service;
	
	public void save(Cliente cliente) {
		service.save(cliente);
	}
	
	public void remover(Long idCliente) {
		service.remover(idCliente);
	}

	@GetMapping("/Listar/")
	public ResponseEntity<List<Cliente>> Listar(){
		List<Cliente> clientes = service.Listar();
		
		if(clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
	}
	
	@GetMapping("/Buscar/{idCliente}/")
	public ResponseEntity<?> BuscarPorId(@PathVariable("idCliente") Long id){
		Cliente clientes = service.buscaPorId(id);
		
		if(clientes==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Cliente>(clientes,HttpStatus.OK);
	}
	
	@GetMapping("/Deletar/{idCliente}/")
	public ResponseEntity<?> Deletar(@PathVariable("idCliente") Long id){
		Cliente clientes = service.remover(id);
		
		if(clientes==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Cliente>(clientes,HttpStatus.OK);
	}
	
	public void update(Cliente cliente) {
		service.update(cliente);
	}
	
}

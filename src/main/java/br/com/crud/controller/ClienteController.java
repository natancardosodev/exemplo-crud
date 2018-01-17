package br.com.crud.controller;

import org.springframework.stereotype.Controller;

import br.com.crud.model.Cliente;
import br.com.crud.service.ClienteService;

@Controller
public class ClienteController {
	private ClienteService service;
	
	public void save(Cliente cliente) {
		service.save(cliente);
	}
	
	public void remover(Long idCliente) {
		service.remover(idCliente);
	}
	
}

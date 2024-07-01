package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.AcessosRepository;
import com.example.demo.service.AcessosServices;
import com.example.demo.model.acesso;

@Controller
@RestController
public class AcessoController {

	@Autowired
	private AcessosServices acessoService;
	
	@Autowired
	private AcessosRepository acessoRepository;
	
	@PostMapping(value = "**/salvarAcesso")  // ** -> SERVE PRA IGNORAR O RESTANTE DA URL
	public ResponseEntity<acesso> salvarAcesso(@RequestBody acesso acesso) {
		acesso acessoSalvo = acessoService.save(acesso);
	
		return new ResponseEntity<acesso>(acessoSalvo, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "**/deleteAcesso")  
	public ResponseEntity<?> deleteAcesso(@RequestBody acesso acesso) {
		acessoRepository.deleteById(acesso.getId());
	
		return new ResponseEntity("Acesso removido.", HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "**/deleteAcessoPorId/{id}")  
	public ResponseEntity<?> deleteAcessoPorId(@PathVariable Long id) {
		acessoRepository.deleteById(id);
	
		return new ResponseEntity("Acesso removido.", HttpStatus.OK);
	}
	
	@GetMapping(value = "**/obterAcessoPorId/{id}")  
	public ResponseEntity<acesso> obterAcessoPorId(@PathVariable Long id) {
		acesso acesso = acessoRepository.findById(id).get();
	
		return new ResponseEntity<acesso>(acesso, HttpStatus.OK);
	}
	
	@GetMapping(value = "**/buscarAcessoPorDesc/{descricao}")  
	public ResponseEntity<List<acesso>> buscarAcessoPorDesc(@PathVariable String descricao) {
		List<acesso> acessos = acessoRepository.buscarAcessoDescricao(descricao);
	
		return new ResponseEntity<List<acesso>>(acessos, HttpStatus.OK);
	}
}
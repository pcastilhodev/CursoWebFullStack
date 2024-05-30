package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@ResponseBody /*Poder dar um retorno da API*/
	@PostMapping(value = "**/salvarAcesso") /*Mapeando a url para receber JSON*/
	public ResponseEntity<acesso> salvarAcesso(@RequestBody acesso acesso) { /*Recebe o JSON e converte pra Objeto*/
		
		acesso acessoSalvo = acessoService.save(acesso);
		
		return new ResponseEntity<acesso>(acessoSalvo, HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PreAuthorize("hasAuthority('SCOPE_ACESSO_ADMIN')")
	@ResponseBody /*Poder dar um retorno da API*/
	@PostMapping(value = "**/deleteAcesso") /*Mapeando a url para receber JSON*/
	public ResponseEntity<?> deleteAcesso(@RequestBody acesso acesso) { /*Recebe o JSON e converte pra Objeto*/
		
		acessoRepository.deleteById(acesso.getId());
		
		return new ResponseEntity("Acesso Removido",HttpStatus.OK);
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@DeleteMapping(value = "**/deleteAcessoPorId/{id}")
	public ResponseEntity<?> deleteAcessoPorId(@PathVariable("id") Long id) { 
		
		acessoRepository.deleteById(id);
		
		return new ResponseEntity("Acesso Removido",HttpStatus.OK);
	}
	
	
	
	@ResponseBody
	@GetMapping(value = "**/obterAcesso/{id}")
	public ResponseEntity<acesso> obterAcesso(@PathVariable("id") Long id) { 
		
		acesso acesso = acessoRepository.findById(id).get();
		
		return new ResponseEntity<acesso>(acesso,HttpStatus.OK);
	}
	
	
	
	@ResponseBody
	@GetMapping(value = "**/buscarPorDesc/{desc}")
	public ResponseEntity<List<acesso>> buscarPorDesc(@PathVariable("desc") String desc) { 
		
		List<acesso> acesso = acessoRepository.buscarAcessoDescricao(desc);
		
		return new ResponseEntity<List<acesso>>(acesso,HttpStatus.OK);
	}
	
	
	

}
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.acesso;
import com.example.demo.repository.AcessosRepository;

@Service
public class AcessosServices {

	@Autowired
	private AcessosRepository acessosRepository;
	
	public acesso save(acesso acesso) {
		return acessosRepository.save(acesso);
	}

}
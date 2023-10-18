package com.senai.lana.PrjGame.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.lana.PrjGame.entities.Jogo;
import com.senai.lana.PrjGame.repositories.JogoRepository;

@Service
public class JogoService {
	
	private final JogoRepository jogoRepository;
	
	public JogoService (JogoRepository produtoRepository ) {
		this.jogoRepository = produtoRepository;
	}
	//inserir 
	public Jogo saveJogo(Jogo jogo) {
		return jogoRepository.save(jogo);
	}
	//listar por id
	public Jogo getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	//listar tudo
	public List<Jogo> getAllJogos(){
		return jogoRepository.findAll();
	}
	//apagar
	public void deleteJogo(Long id) {
		jogoRepository.deleteById(id);
	}
	

}

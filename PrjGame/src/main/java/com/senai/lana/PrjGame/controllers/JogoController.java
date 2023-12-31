package com.senai.lana.PrjGame.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.lana.PrjGame.entities.Jogo;
import com.senai.lana.PrjGame.services.JogoService;

@RestController
@RequestMapping("/jogos")
public class JogoController {

	private final JogoService jogoService;

	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; // index.html
	}

	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}

	@PostMapping
	public Jogo createProduct(@RequestBody Jogo jogo) {
		return jogoService.saveJogo(jogo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getJogo(@PathVariable Long id) {
		Jogo jogo = jogoService.getJogoById(id);
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public List<Jogo> getJogos() {
		return jogoService.getAllJogos();
	}

	@DeleteMapping
	public void deleteProduto(@PathVariable Long id) {
		jogoService.deleteJogo(id);
	}

}

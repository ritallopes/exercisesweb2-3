package br.com.imd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.domain.Login;
import br.com.imd.domain.Papel;
import br.com.imd.repositories.PapelRepository;
import br.com.imd.repositories.UsuarioRepository;

@RestController
public class PapelController {
	
	@RequestMapping("/papeis")
	public List<Papel> getPapeis() {
		return PapelRepository.getPapeis();
	}
	
	@PostMapping("/papeis")
	public Papel addPapel(@RequestBody Papel papel) {
		return PapelRepository.addPapel(papel);
	}
	
}

package br.com.imd.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.domain.Usuario;
import br.com.imd.repositories.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@RequestMapping("/usuarios")
	public List<Usuario> getPapeis() {
		return UsuarioRepository.getUsuarios();
	}

}

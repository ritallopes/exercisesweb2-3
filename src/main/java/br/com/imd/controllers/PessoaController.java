package br.com.imd.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.domain.Pessoa;
import br.com.imd.repositories.PessoaRepository;

@RestController
public class PessoaController {

	@RequestMapping("/pessoas")
	public List<Pessoa> getPapeis() {
		return PessoaRepository.getPessoas();
	}
	
	@PostMapping("/pessoas")
	public Pessoa addPessoa(@RequestBody Pessoa pessoa) {
		return PessoaRepository.addPessoa(pessoa);
	}
}

package br.com.imd.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.domain.Pessoa;

public class PessoaRepository {
	
	public static List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public static List<Pessoa> getPessoas() {
		return pessoas;
	}

	public static Pessoa addPessoa(Pessoa pessoa) {
		if(pessoas.add(pessoa)) {
			return pessoa;
		} else {
			return null;
		}
		
		
	}

}

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
		if (pessoas.add(pessoa)) {
			return pessoa;
		} else {
			return null;
		}
	}

	public static Pessoa findByCpf(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(cpf))
				return pessoa;
		}
		return null;
	}

	public static Boolean removePessoa(String cpf) {
		Pessoa pessoa = findByCpf(cpf);
		if (pessoa.equals(null))
			return false;
		return pessoas.remove(pessoa);
	}

}

package br.com.imd.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.domain.Usuario;

public class UsuarioRepository {

	public static List<Usuario> usuarios = new ArrayList<Usuario>();

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static Usuario addUsuarios(Usuario usuario) {
		if (usuarios.add(usuario)) {
			return usuario;
		} else {
			return null;
		}
	}

	public static Usuario findByNome(String nome) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nome))
				return usuario;
		}
		return null;
	}

	public static Boolean removeUsuario(String nome) {
		Usuario usuario = findByNome(nome);
		if (usuario.equals(null))
			return false;
		return usuarios.remove(usuario);
	}
}

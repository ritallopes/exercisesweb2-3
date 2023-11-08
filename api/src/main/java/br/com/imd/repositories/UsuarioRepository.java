package br.com.imd.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.imd.domain.Usuario;


@Repository
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

	public static Usuario findByEmailAndPassword(String email, String password) {
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email) && usuario.getPassword().equals(password))
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

	public UserDetails findByLogin(String username) {
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(username))
				return usuario;
		}
		return null;
	}
}

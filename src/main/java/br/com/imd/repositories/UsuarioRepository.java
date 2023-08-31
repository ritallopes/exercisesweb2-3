package br.com.imd.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.domain.Usuario;

public class UsuarioRepository {

	public static List<Usuario> usuarios = new ArrayList<Usuario>();

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

}

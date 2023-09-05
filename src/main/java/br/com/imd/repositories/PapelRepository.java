package br.com.imd.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.domain.Papel;

public class PapelRepository {

	private static List<Papel> papeis = new ArrayList<Papel>();

	public static List<Papel> getPapeis() {
		return papeis;
	}

	public static Papel addPapel(Papel p) {
		if (papeis.add(p)) {
			return p;
		} else {
			return null;
		}
	}

	public static Papel findById(int id) {
		for (Papel papel : papeis) {
			if (papel.getId() == id)
				return papel;
		}
		return null;
	}

	public static Boolean removePapel(int id) {
		Papel papel = findById(id);
		if (papel.equals(null))
			return false;
		return papeis.remove(papel);
	}

}

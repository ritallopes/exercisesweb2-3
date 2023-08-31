package br.com.imd.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.domain.Papel;

public class PapelRepository {

	private static List<Papel> papeis = new ArrayList<Papel>();
	
	public static List<Papel> getPapeis(){	
		return papeis;
	}
	
	public static Papel addPapel(Papel p) {
		papeis.add(p);
		return p;
	}
	
	
	
	
	
}

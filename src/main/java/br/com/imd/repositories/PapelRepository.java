package br.com.imd.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.domain.Papel;

public class PapelRepository {

	private static List<Papel> papeis = new ArrayList<Papel>();
	
	
	public static List<Papel> getPapeis(){
	
		Papel p1 = new Papel();
		p1.setId(1);
		p1.setDescricao("Admin");
		
		
		Papel p2 = new Papel();
		p2.setId(2);
		p2.setDescricao("User");
				
		papeis.add(p1);
		papeis.add(p2);
		
		return papeis;
	}
	
	
	
	
	
}

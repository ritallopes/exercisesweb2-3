package br.com.imd.domain;

import java.util.Objects;

public class Pessoa extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	private String name;
	
	public Pessoa() {
		this.name= "";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(name, other.name) && Objects.equals(cpf, other.cpf);
	} 
}

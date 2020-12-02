package com.aleloprojeto.projetoalelo.domain;

import java.io.Serializable;

public class Categoria implements Serializable { //Serializable para converter em bytes
    private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;

	public Categoria() {
		
	}
	
    //Criando um construtor 
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
    
	//Criando o Getters e setters (Metodos de acessos para atributos)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
	//Criando hashCode e equals (Operação para comparar objetos por valor)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode()); //Usando apenas ID
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
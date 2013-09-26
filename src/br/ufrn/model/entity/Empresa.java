 package br.ufrn.model.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Empresa {
	


	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String nome;
	@Column(unique=true,nullable=false)
	private String cnpj;
	private String endereco;
	private String telefone;
	private String site;
	private String email;
	private String logo;
	
	@OneToMany
	private List<Linha> linhas ;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Linha> getLinhas() {
		return linhas;
	}
	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		//igual se tem o mesmo id e o mesmo cnpj
		return (this.getId().longValue() == ((Empresa)obj).getId().intValue()) && (this.getCnpj().equals(((Empresa)obj).getCnpj()));
	}	
	
	@Override
	public String toString() {
		return "\nid: "+id+"\ncnpj: "+cnpj+"\nnome: "+nome;
	}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		//TODO terminar de implementar o metodo clone
		Empresa clone = new Empresa();
		clone.setId(this.id);
		clone.setCnpj(this.cnpj);
		clone.setNome(this.nome);
		return clone;
	}
	/*
	public static void main(String args []){
		
		DAOEmpresa dao = new DAOEmpresa();
		Empresa emp = new Empresa();
		
		emp.setCnpj("234555665");
		emp.setNome("Santa maria");
		
		dao.save(emp);
		System.out.print("Salvo");
		
	}
	*/
	
}

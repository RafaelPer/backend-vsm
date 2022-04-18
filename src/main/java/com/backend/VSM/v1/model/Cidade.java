package com.backend.VSM.v1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable{
	
	private static final long serialVersionUID = 4491477985493351517L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CIDADE_ID_PK",unique = true, nullable = false)
	private Long cidadeIdPk;
	
	@Column(name="CIDADE_NOME", length = 60, nullable = false)
	private String cidadeNome;
	
	@Column(name="CIDADE_UF", length = 60, nullable = false)
	private String cidadeUf;
	
//	@OneToMany(mappedBy = "clienteEnderecoCidadeFk", orphanRemoval = false)
//	private List<Cliente> cidadeClientes;
	
	@Column(name="CIDADE_DESATIVADA",nullable = false, columnDefinition = "TINYINT")
	private boolean cidadeDesativada;
	
	public Cidade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cidade(Long cidadeIdPk, String cidadeNome, String cidadeUf, /*List<Cliente> cidadeClientes,*/
			boolean cidadeDesativada) {
		super();
		this.cidadeIdPk = cidadeIdPk;
		this.cidadeNome = cidadeNome;
		this.cidadeUf = cidadeUf;
//		this.cidadeClientes = cidadeClientes;
		this.cidadeDesativada = cidadeDesativada;
	}

	public Long getCidadeIdPk() {
		return cidadeIdPk;
	}

	public void setCidadeIdPk(Long cidadeIdPk) {
		this.cidadeIdPk = cidadeIdPk;
	}

	public String getCidadeNome() {
		return cidadeNome;
	}

	public void setCidadeNome(String cidadeNome) {
		this.cidadeNome = cidadeNome;
	}
	
	public String getCidadeUf() {
		return cidadeUf;
	}

	public void setCidadeUf(String cidadeUf) {
		this.cidadeUf = cidadeUf;
	}

//	public List<Cliente> getCidadeClientes() {
//		return cidadeClientes;
//	}
//
//	public void setCidadeClientes(List<Cliente> cidadeClientes) {
//		this.cidadeClientes = cidadeClientes;
//	}

	public boolean isCidadeDesativada() {
		return cidadeDesativada;
	}

	public void setCidadeDesativada(boolean cidadeDesativada) {
		this.cidadeDesativada = cidadeDesativada;
	}

}

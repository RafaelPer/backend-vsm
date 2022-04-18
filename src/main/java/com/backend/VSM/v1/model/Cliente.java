package com.backend.VSM.v1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = -1697760271570904388L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CLIENTE_ID_PK",unique = true, nullable = false)
	private Long clienteIdPk;
	
	@Column(name="CLIENTE_NOME", nullable = false, length = 60)
	private String clienteNome;
	
	@Column(name="CLIENTE_CPF_CNPJ", nullable = false, unique = true, length = 14)
	private String clienteCpfCnpj;
	
	@Column(name="CLIENTE_ENDERECO_LOGRADOURO", length = 60)
	private String clienteEnderecoLogradouro;
	
	@Column(name="CLIENTE_ENDERECO_NUMERO", length = 20)
	private String clienteEnderecoNumero;
	
	@Column(name="CLIENTE_ENDERECO_BAIRRO", length = 60)
	private String clienteEnderecoBairro;
	
	@Column(name="CLIENTE_ENDERECO_CEP", length = 8)
	private String clienteEnderecoCep;
	
	@ManyToOne
    @JoinColumn(name = "CLIENTE_ENDERECO_CIDADE_FK", nullable = true)
	//@ForeignKey(name = "CLIENTE_ENDERECO_CIDADE_FK")
	private Cidade clienteEnderecoCidadeFk;
	
	@Column(name="CLIENTE_TELEFONE", length = 11)
	private String clienteTelefone;
	
	@Column(name="CLIENTE_EMAIL", length = 60)
	private String clienteEmail;
	
	@Column(name="CLIENTE_DESATIVADO",nullable = false, columnDefinition = "TINYINT")
	private boolean clienteDesativado;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Long clienteIdPk, String clienteNome, String clienteCPFCNPJ, String clienteEnderecoLogradouro,
			String clienteEnderecoNumero, String clienteEnderecoBairro, String clienteEnderecoCep,
			Cidade clienteEnderecoCidadeFk, String clienteTelefone, String clienteEmail,
			boolean clienteDesativado) {
		super();
		this.clienteIdPk = clienteIdPk;
		this.clienteNome = clienteNome;
		this.clienteCpfCnpj = clienteCPFCNPJ;
		this.clienteEnderecoLogradouro = clienteEnderecoLogradouro;
		this.clienteEnderecoNumero = clienteEnderecoNumero;
		this.clienteEnderecoBairro = clienteEnderecoBairro;
		this.clienteEnderecoCep = clienteEnderecoCep;
		this.clienteEnderecoCidadeFk = clienteEnderecoCidadeFk;
		this.clienteTelefone = clienteTelefone;
		this.clienteEmail = clienteEmail;
		this.clienteDesativado = clienteDesativado;
	}

	public Long getClienteIdPk() {
		return clienteIdPk;
	}

	public void setClienteIdPk(Long clienteIdPk) {
		this.clienteIdPk = clienteIdPk;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getClienteCPFCNPJ() {
		return clienteCpfCnpj;
	}

	public void setClienteCPFCNPJ(String clienteCPFCNPJ) {
		this.clienteCpfCnpj = clienteCPFCNPJ;
	}

	public String getClienteEnderecoLogradouro() {
		return clienteEnderecoLogradouro;
	}

	public void setClienteEnderecoLogradouro(String clienteEnderecoLogradouro) {
		this.clienteEnderecoLogradouro = clienteEnderecoLogradouro;
	}

	public String getClienteEnderecoNumero() {
		return clienteEnderecoNumero;
	}

	public void setClienteEnderecoNumero(String clienteEnderecoNumero) {
		this.clienteEnderecoNumero = clienteEnderecoNumero;
	}

	public String getClienteEnderecoBairro() {
		return clienteEnderecoBairro;
	}

	public void setClienteEnderecoBairro(String clienteEnderecoBairro) {
		this.clienteEnderecoBairro = clienteEnderecoBairro;
	}

	public String getClienteEnderecoCep() {
		return clienteEnderecoCep;
	}

	public void setClienteEnderecoCep(String clienteEnderecoCep) {
		this.clienteEnderecoCep = clienteEnderecoCep;
	}

	public Cidade getClienteEnderecoCidadeFk() {
		return clienteEnderecoCidadeFk;
	}

	public void setClienteEnderecoCidadeFk(Cidade clienteEnderecoCidadeFk) {
		this.clienteEnderecoCidadeFk = clienteEnderecoCidadeFk;
	}

	public String getClienteTelefone() {
		return clienteTelefone;
	}

	public void setClienteTelefone(String clienteTelefone) {
		this.clienteTelefone = clienteTelefone;
	}
	
	public String getClienteEmail() {
		return clienteEmail;
	}

	public void setClienteEmail(String clienteEmail) {
		this.clienteEmail = clienteEmail;
	}

	public boolean isClienteDesativado() {
		return clienteDesativado;
	}

	public void setClienteDesativado(boolean clienteDesativado) {
		this.clienteDesativado = clienteDesativado;
	}
	
	
}

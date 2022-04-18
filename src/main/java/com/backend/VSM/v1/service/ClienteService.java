package com.backend.VSM.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.VSM.v1.model.Cidade;
import com.backend.VSM.v1.model.Cliente;
import com.backend.VSM.v1.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	public List<Cliente> getClientesAtivados() {
	    return clienteRepository.findAllByClienteAtivado();
	}

	public Cliente getClienteByIdAndClienteAtivado(Long id) {
		return clienteRepository.findByClienteIdAndClienteAtivado(id);
	}
	
	public Cliente getClienteByCpfCnpjAndClienteAtivado(String cpfCnpj) {
		System.out.println(cpfCnpj);
//		System.out.println(clienteRepository.findByClienteCpfCnpjAndClienteAtivado(cpfCnpj).getClienteIdPk());
		return clienteRepository.findByClienteCpfCnpjAndClienteAtivado(cpfCnpj);
	}
	
	public Cliente createCliente(Cliente cli) {
	    return clienteRepository.save(cli);
	}
	
	public Cliente updateClienteById(Long cliId, Cliente clienteBody) {
	    Cliente cli = clienteRepository.findById(cliId).get();
	    
	    System.out.println(cliId);
	    
		System.out.println(clienteBody.getClienteIdPk());
		System.out.println(clienteBody.getClienteNome());
		System.out.println(clienteBody.getClienteCPFCNPJ());
		System.out.println(clienteBody.getClienteEnderecoLogradouro());
		System.out.println(clienteBody.getClienteEnderecoNumero());
		System.out.println(clienteBody.getClienteEnderecoCep());
		System.out.println(clienteBody.getClienteEnderecoCidadeFk());
		System.out.println(clienteBody.getClienteTelefone());
		System.out.println(clienteBody.getClienteEmail());
		System.out.println(clienteBody.isClienteDesativado());
	    
		if(clienteBody.getClienteNome() != null) {
			cli.setClienteNome(clienteBody.getClienteNome());
		}
		if(clienteBody.getClienteCPFCNPJ() != null) {
			cli.setClienteCPFCNPJ(clienteBody.getClienteCPFCNPJ());
		}
		if(clienteBody.getClienteEnderecoLogradouro() != null) {
			cli.setClienteEnderecoLogradouro(clienteBody.getClienteEnderecoLogradouro());
		}
		if(clienteBody.getClienteEnderecoNumero() != null) {
			cli.setClienteEnderecoNumero(clienteBody.getClienteEnderecoNumero());
		}
		if(clienteBody.getClienteEnderecoBairro() != null) {
			cli.setClienteEnderecoBairro(clienteBody.getClienteEnderecoBairro());
		}
		if(clienteBody.getClienteEnderecoCep() != null) {
			cli.setClienteEnderecoCep(clienteBody.getClienteEnderecoCep());
		}
		if(clienteBody.getClienteEnderecoCidadeFk() != null) {
			cli.setClienteEnderecoCidadeFk(clienteBody.getClienteEnderecoCidadeFk());
		}
		if(clienteBody.getClienteTelefone() != null) {
			cli.setClienteTelefone(clienteBody.getClienteTelefone());
		}
		if(clienteBody.getClienteEmail() != null) {
			cli.setClienteEmail(clienteBody.getClienteEmail());
		}
		
//	    cli.setClienteNome(clienteBody.getClienteNome() == null?cli.getClienteNome():clienteBody.getClienteNome());
//	    cli.setClienteCPFCNPJ(clienteBody.getClienteCPFCNPJ() == null?cli.getClienteCPFCNPJ():clienteBody.getClienteCPFCNPJ());
//	    cli.setClienteEnderecoLogradouro(clienteBody.getClienteEnderecoLogradouro() == null?cli.getClienteEnderecoLogradouro():clienteBody.getClienteEnderecoLogradouro());
//	    cli.setClienteEnderecoNumero(clienteBody.getClienteEnderecoNumero() == null?cli.getClienteEnderecoNumero():clienteBody.getClienteEnderecoNumero());
//	    cli.setClienteEnderecoBairro(clienteBody.getClienteEnderecoBairro() == null?cli.getClienteEnderecoBairro():clienteBody.getClienteEnderecoBairro());
//	    cli.setClienteEnderecoCep(clienteBody.getClienteEnderecoCep() == null?cli.getClienteEnderecoCep():clienteBody.getClienteEnderecoCep());
//	    cli.setClienteEnderecoCidadeFk(clienteBody.getClienteEnderecoCidadeFk() == null?cli.getClienteEnderecoCidadeFk():clienteBody.getClienteEnderecoCidadeFk());
//	    cli.setClienteTelefone(clienteBody.getClienteTelefone() == null?cli.getClienteTelefone():clienteBody.getClienteTelefone());
	    cli.setClienteDesativado(clienteBody.isClienteDesativado());
	    
		System.out.println(cli.getClienteIdPk());
		System.out.println(cli.getClienteNome());
		System.out.println(cli.getClienteCPFCNPJ());
		System.out.println(cli.getClienteEnderecoLogradouro());
		System.out.println(cli.getClienteEnderecoNumero());
		System.out.println(cli.getClienteEnderecoCep());
		System.out.println(cli.getClienteEnderecoCidadeFk());
		System.out.println(cli.getClienteTelefone());
		System.out.println(cli.getClienteEmail());
		System.out.println(cli.isClienteDesativado());
	    
	    return clienteRepository.save(cli);                                
	}
	
	public Cliente alterStatusClienteById(Long cliId, boolean isDesactive) {
		Cliente cli = clienteRepository.findById(cliId).get();
        
        System.out.println(cliId);
        
    	System.out.println(cli.getClienteIdPk());
    	System.out.println(cli.getClienteNome());
    	System.out.println(cli.getClienteCPFCNPJ());
    	System.out.println(cli.getClienteEnderecoLogradouro());
    	System.out.println(cli.getClienteEnderecoNumero());
    	System.out.println(cli.getClienteEnderecoCep());
    	System.out.println(cli.getClienteEnderecoCidadeFk());
    	System.out.println(cli.getClienteTelefone());
    	System.out.println(cli.getClienteEmail());
    	System.out.println(cli.isClienteDesativado());
    	
    	System.out.println(isDesactive);
        
        cli.setClienteDesativado(isDesactive);
        
    	System.out.println(cli.getClienteIdPk());
    	System.out.println(cli.getClienteNome());
    	System.out.println(cli.getClienteCPFCNPJ());
    	System.out.println(cli.getClienteEnderecoLogradouro());
    	System.out.println(cli.getClienteEnderecoNumero());
    	System.out.println(cli.getClienteEnderecoCep());
    	System.out.println(cli.getClienteEnderecoCidadeFk());
    	System.out.println(cli.getClienteTelefone());
    	System.out.println(cli.getClienteEmail());
    	System.out.println(cli.isClienteDesativado());
        
        return clienteRepository.save(cli);                                
	}

}

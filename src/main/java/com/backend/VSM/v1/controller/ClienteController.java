package com.backend.VSM.v1.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.VSM.v1.model.Cliente;
import com.backend.VSM.v1.service.ClienteService;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    ClienteService cliService;
    
    @RequestMapping(value="/getAllClientes", method=RequestMethod.GET)
    public List<Cliente> buscarClientes(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Allow-Headers", "*");
        return cliService.getClientes();
    }
    
    @RequestMapping(value="/getAllClientesAtivados", method=RequestMethod.GET)
    public List<Cliente> buscarClientesAtivados(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Allow-Headers", "*");
        return cliService.getClientesAtivados();
    }
    
    @RequestMapping(value="/getClienteByIdAndClienteAtivado/{clientId}", method=RequestMethod.GET)
    public Cliente buscarClienteByIdAndClienteAtivado(@PathVariable(value = "clientId") Long id, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Allow-Headers", "*");
        return cliService.getClienteByIdAndClienteAtivado(id);
    }
    
    @RequestMapping(value="/getClienteByCpfCnpjAndClienteAtivado/{clienteCpfCnpj}", method=RequestMethod.GET)
    public Cliente buscarClienteByCpfCnpjAndClienteAtivado(@PathVariable(value = "clienteCpfCnpj") String cpfCnpj, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Allow-Headers", "*");
        System.out.println(cpfCnpj);
    	return cliService.getClienteByCpfCnpjAndClienteAtivado(cpfCnpj);
    }
    
    @RequestMapping(value="/createCliente", method=RequestMethod.POST)
    public Cliente criarCliente(@RequestBody Cliente cli, HttpServletResponse response) {
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
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Allow-Headers", "*");
        return cliService.createCliente(cli);
    }
    
    @RequestMapping(value="/updateClienteById/{cliId}", method=RequestMethod.PUT)
    public Cliente atualizarClienteById(@PathVariable(value = "cliId") Long id, @RequestBody Cliente clienteBody, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Allow-Headers", "*");
        return cliService.updateClienteById(id, clienteBody);
    }
    
    @RequestMapping(value="/alterStatusClienteById/{cliId}", method=RequestMethod.PUT)
    public Cliente alterarStatusClienteById(@PathVariable(value = "cliId") Long id, @RequestBody String body, HttpServletResponse response) {
    	System.out.println(body);
    	
    	Object obj = JSONValue.parse(body);
    	
    	System.out.println(obj);
    	
    	JSONObject jsonObject = (JSONObject) obj;
    	
    	System.out.println(jsonObject);
    	
    	boolean isDesactive = (boolean) jsonObject.get("isDesactive"); 
    	
    	System.out.println(isDesactive);
    	
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Allow-Headers", "*");
    	
    	return cliService.alterStatusClienteById(id, isDesactive);
        
    }
}

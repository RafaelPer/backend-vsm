package com.backend.VSM.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.VSM.v1.model.Cidade;
import com.backend.VSM.v1.service.CidadeService;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

@RestController()
@RequestMapping("/api")
public class CidadeController {
	@Autowired
	CidadeService cidService;
	
    @RequestMapping(value="/getAllCidades", method=RequestMethod.GET)
    public List<Cidade> buscarCidades(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,OPTIONS,PATCH,DELETE,POST,PUT");
        response.addHeader("Access-Control-Allow-Headers", "*");
        return cidService.getCidades();
    }
    
    @RequestMapping(value="/getAllCidadesAtivadas", method=RequestMethod.GET)
    public List<Cidade> buscarCidadesAtivadas(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,OPTIONS,PATCH,DELETE,POST,PUT");
        response.addHeader("Access-Control-Allow-Headers", "*");
        return cidService.getCidadesAtivadas();
    }
    
    @RequestMapping(value="/getCidadeByIdAndCidadeAtivada/{cidId}", method=RequestMethod.GET)
    public Cidade buscarCidadeByIdAndCidadeAtivado(@PathVariable(value = "cidId") Long id, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,OPTIONS,PATCH,DELETE,POST,PUT");
        response.addHeader("Access-Control-Allow-Headers", "*");
        return cidService.getCidadeByIdAndCidadeAtivada(id);
    }
    
    @RequestMapping(value="/createCidade", method=RequestMethod.POST)
    public Cidade criarCidade(@RequestBody Cidade cid, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,OPTIONS,PATCH,DELETE,POST,PUT");
        response.addHeader("Access-Control-Allow-Headers", "*");
    	
		System.out.println(cid.getCidadeIdPk());
		System.out.println(cid.getCidadeNome());
		System.out.println(cid.getCidadeUf());
		System.out.println(cid.isCidadeDesativada());
		
        return cidService.createCidade(cid);
    }
    
    @RequestMapping(value="/updateCidadeById/{cidId}", method=RequestMethod.PUT)
    public Cidade atualizarCidadeById(@PathVariable(value = "cidId") Long id, @RequestBody Cidade cidadeBody, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,OPTIONS,PATCH,DELETE,POST,PUT");
        response.addHeader("Access-Control-Allow-Headers", "*");
        return cidService.updateCidadeById(id, cidadeBody);
    }
    
    @RequestMapping(value="/alterStatusCidadeById/{cidId}", method=RequestMethod.PUT)
    public Cidade alterarStatusCidadeById(@PathVariable(value = "cidId") Long id, @RequestBody String body, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Credencials", "true");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,OPTIONS,PATCH,DELETE,POST,PUT");
        response.addHeader("Access-Control-Allow-Headers", "*");
    	System.out.println(body);
    	
    	Object obj = JSONValue.parse(body);
    	
    	System.out.println(obj);
    	
    	JSONObject jsonObject = (JSONObject) obj;
    	
    	System.out.println(jsonObject);
    	
    	boolean isDesactive = (boolean) jsonObject.get("isDesactive"); 
    	
    	System.out.println(isDesactive);
    	
    	return cidService.alterStatusCidadeById(id, isDesactive);
        
    }
    
}

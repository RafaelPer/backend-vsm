package com.backend.VSM.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.VSM.v1.model.Cidade;
import com.backend.VSM.v1.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	public List<Cidade> getCidades(){
		return cidadeRepository.findAll();
	}
	
	public List<Cidade> getCidadesAtivadas() {
	    return cidadeRepository.findAllByCidadeAtivada();
	}

	public Cidade getCidadeByIdAndCidadeAtivada(Long id) {
		return cidadeRepository.findByCidadeIdAndCidadeAtivada(id);
	}

	public Cidade createCidade(Cidade cid) {
	    return cidadeRepository.save(cid);
	}
	
	public Cidade updateCidadeById(Long cidId, Cidade cidadeBody) {
		Cidade cid = cidadeRepository.findById(cidId).get();
	    
	    System.out.println(cidId);
	    
		System.out.println(cidadeBody.getCidadeIdPk());
		System.out.println(cidadeBody.getCidadeNome());
		System.out.println(cidadeBody.getCidadeUf());
		System.out.println(cidadeBody.isCidadeDesativada());
	    
		if(cidadeBody.getCidadeNome() != null) {
			cid.setCidadeNome(cidadeBody.getCidadeNome());
		}
		if(cidadeBody.getCidadeUf() != null) {
			cid.setCidadeUf(cidadeBody.getCidadeUf());
		}
		
		cid.setCidadeDesativada(cidadeBody.isCidadeDesativada());
	    
		System.out.println(cid.getCidadeIdPk());
		System.out.println(cid.getCidadeNome());
		System.out.println(cid.getCidadeUf());
		System.out.println(cid.isCidadeDesativada());
	    
	    return cidadeRepository.save(cid);                                
	}
	
	public Cidade alterStatusCidadeById(Long cidId, boolean isDesactive) {
		Cidade cid = cidadeRepository.findById(cidId).get();
        
	    System.out.println(cidId);
	    
		System.out.println(cid.getCidadeIdPk());
		System.out.println(cid.getCidadeNome());
		System.out.println(cid.getCidadeUf());
		System.out.println(cid.isCidadeDesativada());
    	
    	System.out.println(isDesactive);
        
        cid.setCidadeDesativada(isDesactive);
        
		System.out.println(cid.getCidadeIdPk());
		System.out.println(cid.getCidadeNome());
		System.out.println(cid.getCidadeUf());
		System.out.println(cid.isCidadeDesativada());
        
        return cidadeRepository.save(cid);                                
	}
}

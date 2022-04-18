package com.backend.VSM.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.VSM.v1.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	@Query("SELECT ci FROM Cidade ci WHERE ci.cidadeIdPk = ?1 AND ci.cidadeDesativada = 0")
	Cidade findByCidadeIdAndCidadeAtivada(Long id);
	
	@Query("SELECT ci FROM Cidade ci WHERE ci.cidadeDesativada = 0")
	List<Cidade> findAllByCidadeAtivada();
}

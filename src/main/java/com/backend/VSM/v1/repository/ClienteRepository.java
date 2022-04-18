package com.backend.VSM.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.VSM.v1.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("SELECT c FROM Cliente c WHERE c.clienteCpfCnpj = ?1 AND c.clienteDesativado = 0")
	Cliente findByClienteCpfCnpjAndClienteAtivado(String cpfCnpj);
	
	@Query("SELECT c FROM Cliente c WHERE c.clienteIdPk = ?1 AND c.clienteDesativado = 0")
	Cliente findByClienteIdAndClienteAtivado(Long id);
	
	@Query("SELECT c FROM Cliente c WHERE c.clienteDesativado = 0")
	List<Cliente> findAllByClienteAtivado();
}

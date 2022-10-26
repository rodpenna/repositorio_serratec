package br.com.residencia.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.ecommerce.entity.Cliente;
import br.com.residencia.ecommerce.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
	public Endereco findByCliente(Cliente cliente);
}

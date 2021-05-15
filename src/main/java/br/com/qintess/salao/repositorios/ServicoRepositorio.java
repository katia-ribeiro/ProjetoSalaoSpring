package br.com.qintess.salao.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.qintess.salao.models.Servicos;

public interface ServicoRepositorio extends CrudRepository<Servicos, Long>{
	
Servicos findById(long id);
	
}

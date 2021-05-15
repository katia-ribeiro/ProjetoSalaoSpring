package br.com.qintess.salao.repositorios;


import org.springframework.data.repository.CrudRepository;

import br.com.qintess.salao.models.Agenda;

public interface AgendaRepositorio extends  CrudRepository<Agenda, Long>{
	
	Agenda findById(long id);
}

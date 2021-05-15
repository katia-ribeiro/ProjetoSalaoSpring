package br.com.qintess.salao.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.qintess.salao.models.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, String> {


}

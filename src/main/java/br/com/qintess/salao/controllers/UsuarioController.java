package br.com.qintess.salao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.qintess.salao.models.Usuario;
import br.com.qintess.salao.repositorios.UsuarioRepositorio;


@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepositorio ur;
	
	@RequestMapping(value="clientes/cadastroCliente",method= RequestMethod.GET)
	public String cadastroCliente() {
		return "views/clientes/cadastroCliente";
	}

	@RequestMapping(value="clientes/cadastroCliente",method= RequestMethod.POST)
	public String form(Usuario usuario) {	
	ur.save(usuario);
		return "redirect:cadastroCliente";
	}
	
	@RequestMapping(value="/listaClientes")
	public ModelAndView listCliente() {
		ModelAndView mv = new ModelAndView("views/clientes/listaClientes");
		Iterable<Usuario> usuarios = ur.findAll();
		mv.addObject("usuario", usuarios);
		return mv;
	}
//	@GetMapping ("/usuario")
//	public List<Usuario> getUsuarios(){
//		return repo.findAll();		
//
//	}
//	@GetMapping("/usuario/{id}")
//	public Usuario listaUsuario(@PathVariable(value="id") int id) {
//		return repo.findById(id);
//
//	}
//	@PostMapping("/usuario")
//	public Usuario criarUsuario(@RequestBody Usuario  usuario) {
//		return repo.save(usuario);
//	}
//	@DeleteMapping("/usuario")
//	public void deletaUsuario(@RequestBody Usuario  usuario) {
//		repo.delete(usuario);
//	}
//	@PutMapping("/usuario")
//	public Usuario atualizaUsuario(@RequestBody Usuario  usuario) {
//		return repo.save(usuario);
//	}
}

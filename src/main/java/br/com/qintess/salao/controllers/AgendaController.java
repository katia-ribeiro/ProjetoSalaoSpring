package br.com.qintess.salao.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.qintess.salao.models.Agenda;
import br.com.qintess.salao.models.Servicos;
import br.com.qintess.salao.models.Usuario;
import br.com.qintess.salao.repositorios.AgendaRepositorio;
import br.com.qintess.salao.repositorios.ServicoRepositorio;
import br.com.qintess.salao.repositorios.UsuarioRepositorio;

@Controller
public class AgendaController {


	@Autowired
	private AgendaRepositorio ar;

	@RequestMapping(value="/agendarAtendimento",method= RequestMethod.GET)
	public String form() {
		return "views/agenda/formAgenda";
	}
	@RequestMapping(value="/agendarAtendimento",method= RequestMethod.POST)
	public String form(Agenda agenda, Servicos ide , Usuario id) {
		agenda.getServicos().add(ide);
		agenda.setUsuario(id);
		
			System.out.println(ar.save(agenda));

		return "redirect:/agendarAtendimento";
	}

	@RequestMapping(value="/listaAgenda")
	public ModelAndView listServicos() {
		ModelAndView mv = new ModelAndView("views/agenda/listaAgenda");
		
		Iterable<Agenda>agenda = ar.findAll();		
		
	mv.addObject("agenda", agenda);	
		return mv;
}
}
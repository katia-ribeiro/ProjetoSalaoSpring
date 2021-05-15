package br.com.qintess.salao.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.qintess.salao.models.Agenda;
import br.com.qintess.salao.models.Servicos;
import br.com.qintess.salao.repositorios.ServicoRepositorio;

@Controller
public class ServicoController {

	@Autowired
	private ServicoRepositorio sr;

	@RequestMapping(value="/cadastrarServico",method= RequestMethod.GET)
	public String form() {
		return "views/servico/formServico";
	}

	@RequestMapping(value="/cadastrarServico",method= RequestMethod.POST)
	public String form(Servicos servico) {	
		
	sr.save(servico);
		return "redirect:cadastrarServico";
	}

	@RequestMapping(value="/servicos")
	public ModelAndView listServicos() {
		ModelAndView mv = new ModelAndView("views/servico/novoIndex");
		Iterable<Servicos> servicos = sr.findAll();
		mv.addObject("servicos", servicos);
		return mv;
	}
	
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public ModelAndView detalheServico(@PathVariable("id") long id) {		
		Servicos servicos= sr.findById(id);
		ModelAndView mv = new ModelAndView("views/servico/detalheServico");
		mv.addObject("servicos", servicos);
		System.out.println("servicos"+ servicos);
		return mv;
			
	}
	
}
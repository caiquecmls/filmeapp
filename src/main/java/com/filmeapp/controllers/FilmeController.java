package com.filmeapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.filmeapp.models.Filme;
import com.filmeapp.repository.FilmeRepository;

@Controller
public class FilmeController {
	
	@Autowired
	FilmeRepository filmeRepository;
	
	@RequestMapping(value = "/filme", method = RequestMethod.GET)
	public String showForm () {
		return "filme/formFilme.html";
	}
	
	@RequestMapping(value = "/filme", method = RequestMethod.POST)
	public String submit(Filme filme) {
		filmeRepository.save(filme);
		return "redirect:/filme";
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView movieList(Filme filme) {
		ModelAndView mv = new ModelAndView("/index");
		Iterable<Filme> filmes = filmeRepository.findAll();
		mv.addObject("filmes", filmes);
		return mv;
	}
	
	@GetMapping("/{id}/deletar")
	public String deleteFilme(@PathVariable Long id) {
		filmeRepository.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/atualizar")
	public ModelAndView alterarFilme(@PathVariable Long id, Filme filme) {
		Optional<Filme> filmeUpdate = filmeRepository.findById(id);
		return new ModelAndView("filme/updateFilme").addObject("filmeUpdate", filmeUpdate);
	}
	
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public String salvarUpdate(Filme filme, Long id) {
//		Filme filme = filmeRepository.(id);
//		filmeRepository.save(filme);
//		return "redirect:/filme";
//		
//	}
}

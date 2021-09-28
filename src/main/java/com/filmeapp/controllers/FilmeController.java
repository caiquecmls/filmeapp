package com.filmeapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}

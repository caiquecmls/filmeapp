package com.filmeapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.filmeapp.models.Filme;
import com.filmeapp.models.Usuario;
import com.filmeapp.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@RequestMapping(value = "/CadastrarUsuario", method = RequestMethod.GET)
	public String showForm () {
		return "filme/cadastrarUsuario.html";
	}
	
	@RequestMapping(value = "/salvarUsuario", method = RequestMethod.POST)
	public String submit(Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/CadastrarUsuario";
		
	}
	
	@RequestMapping(value = "/ListarUsuario", method = RequestMethod.GET)
	public ModelAndView userList(Usuario usuario) {
		ModelAndView mv = new ModelAndView("filme/listarUsuario");
		Iterable<Usuario> usuarios = usuarioRepository.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	

	@GetMapping("/{id}/atualizarUsuario")
	public ModelAndView alterarUsuario(@PathVariable Long id, Usuario usuario) {
		Optional<Usuario> editarUsuario = usuarioRepository.findById(id);
		return new ModelAndView("filme/editarUsuario").addObject("editarUsuario", editarUsuario);
	}

	
	@GetMapping("/{id}/deletarUsuario")
	public String deleteUsuario(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
		return "redirect:/ListarUsuario";
	}
	
	

}

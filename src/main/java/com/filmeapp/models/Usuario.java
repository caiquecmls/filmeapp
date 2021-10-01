package com.filmeapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.ImageIcon;

@Entity
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String user;
	private String email;
	private String senha;
	
	@Column(length = 80000)
	private String imgPerfil;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getImgPerfil() {
		
		return imgPerfil;
	}
	public void setImgPerfil(String imgPerfil) {
		this.imgPerfil = imgPerfil;
	}
	
	
	
	
	

}

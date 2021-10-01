package com.filmeapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.filmeapp.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}

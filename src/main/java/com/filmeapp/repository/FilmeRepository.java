package com.filmeapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.filmeapp.models.Filme;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Long>{
}

package com.example.ProyectoMovilesBBDD.modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovilRepository extends CrudRepository<Movil, Integer>{

}

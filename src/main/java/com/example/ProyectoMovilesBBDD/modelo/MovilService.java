package com.example.ProyectoMovilesBBDD.modelo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.ProyectoMovilesBBDD.control.ObjectMother;



@Service
public class MovilService {
	
	Set<Movil> movilesLista;
	ObjectMother objectMother = new ObjectMother();
	
	public MovilService(){
		
		movilesLista = new HashSet<Movil>();
		for (int i = 0; i < 500; i++) {
			movilesLista.add(objectMother.generarMovil());
		}
	}
	
	public HashSet<Movil> getMoviles(){
		return (HashSet<Movil>) this.movilesLista;
	}
	
	
	

}

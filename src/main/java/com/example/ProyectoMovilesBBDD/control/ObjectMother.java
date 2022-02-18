package com.example.ProyectoMovilesBBDD.control;

import com.example.ProyectoMovilesBBDD.modelo.Movil;
import com.example.ProyectoMovilesBBDD.modelo.MovilBuilder;



public class ObjectMother {
	
	MovilBuilder movilBuilder;
	
	public Movil generarMovil(){
		movilBuilder = new MovilBuilder();
		return movilBuilder.movilBuild();
	}
	
}

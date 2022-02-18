package com.example.ProyectoMovilesBBDD;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ProyectoMovilesBBDD.control.ObjectMother;
import com.example.ProyectoMovilesBBDD.modelo.Movil;
import com.example.ProyectoMovilesBBDD.modelo.MovilRepository;


@SpringBootTest
class ProyectoMovilesBBDDApplicationTests {
	
	static int contador=0;
	
	@Autowired
	MovilRepository movilRepository;

	@Test
	void contextLoads() {
		
		
		ObjectMother objectMother = new ObjectMother();
		Set<Movil> listaMoviles = new HashSet<>();
		
		for (int i = 0; i < 50; i++) {
			listaMoviles.add(objectMother.generarMovil());
		}
		
		listaMoviles.forEach((a)->{System.out.println((contador++) +" "+a.toString());});
		movilRepository.saveAll(listaMoviles);
	
	}

}

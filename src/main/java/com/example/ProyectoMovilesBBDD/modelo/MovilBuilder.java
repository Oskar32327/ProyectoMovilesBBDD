package com.example.ProyectoMovilesBBDD.modelo;

import java.io.Serializable;

import com.example.ProyectoMovilesBBDD.utiles.GenerarCadena;


public class MovilBuilder implements Serializable{
	
	private final int id;
	private final String marca;
	private final String modelo;
	private final Pantalla pantalla;
	private final Ram ram;
	private final Procesador procesador;
	private final Antutu antutu;
	private final Bateria bateria;
	private float precio;
	private static int contador=0;
	
	public MovilBuilder() {
		super();
		this.id = contador++;
		this.marca = GenerarCadena.generarPalabras(7);
		this.modelo = GenerarCadena.generarModelo(7);
		this.pantalla = new Pantalla();
		this.ram = new Ram();
		this.procesador = new Procesador();
		this.antutu = new Antutu(procesador,ram);
		this.bateria = new Bateria(pantalla, procesador,ram);
		this.precio = calcularPrecio();
	}
	
	private float calcularPrecio() {
		return this.pantalla.calcularPrecio()+ this.ram.calcularPrecio()+this.procesador.calcularPrecio()+this.bateria.calcularPrecio();
	}
	
	
	public Movil movilBuild() {
		return new Movil(this);
	}
	

	public int getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Pantalla getPantalla() {
		return pantalla;
	}

	public Ram getRam() {
		return ram;
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public Antutu getAntutu() {
		return antutu;
	}

	public Bateria getBateria() {
		return bateria;
	}

	public float getPrecio() {
		return precio;
	}
	
	
	
	
	
	
}

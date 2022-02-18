package com.example.ProyectoMovilesBBDD.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movil implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Embedded
	@Column(name = "pantalla", nullable = false)
	private Pantalla pantalla;
	
	@Embedded
	@Column(name = "ram" ,nullable = false)
	private Ram ram;
	
	@Embedded
	@Column(name = "procesador", nullable = false)
	private Procesador procesador;
	
	@Embedded
	@Column(name= "antutu", nullable = false)
	private Antutu antutu;
	
	@Embedded
	@Column(name= "bateria" , nullable = false)
	private Bateria bateria;
	
	@Column(name = "precio")
	private float precio;
	
	public Movil() {
		super();
	}
	
	
	public Movil(MovilBuilder builder) {
		super();
		this.id = builder.getId();
		this.marca = builder.getMarca();
		this.modelo = builder.getModelo();
		this.pantalla = builder.getPantalla();
		this.ram = builder.getRam();
		this.procesador = builder.getProcesador();
		this.antutu = builder.getAntutu();
		this.bateria = builder.getBateria();
		this.precio = builder.getPrecio();
	}

	
	public Movil(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Pantalla getPantalla() {
		return pantalla;
	}

	public void setPantalla(Pantalla pantalla) {
		this.pantalla = pantalla;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	public Antutu getAntutu() {
		return antutu;
	}

	public void setAntutu(Antutu antutu) {
		this.antutu = antutu;
	}

	public Bateria getBateria() {
		return bateria;
	}

	public void setBateria(Bateria bateria) {
		this.bateria = bateria;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	
	@Override
	public String toString() {
		return "Movil [Id:"+getId()+"Marca:" + marca.toString() + ", Modelo:" + modelo.toString() + ", Pantalla:" + pantalla.toString() + ", " + ram.toString()
				+ ", " + procesador.toString() + ", Antutu: " + antutu + ", " + bateria.toString() + ", Precio:" + precio
				+ "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movil other = (Movil) obj;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}
	
	
}

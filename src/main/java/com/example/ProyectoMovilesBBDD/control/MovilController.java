package com.example.ProyectoMovilesBBDD.control;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProyectoMovilesBBDD.modelo.Movil;
import com.example.ProyectoMovilesBBDD.modelo.MovilService;
import com.example.ProyectoMovilesBBDD.modelo.Response;


@RestController
@RequestMapping("moviles")
public class MovilController {

	
	@Autowired
	private MovilService movilService;
	
//	@GetMapping("home")
//	public HashSet<Movil> moviles() {
//		return this.movilService.getMoviles();
//	}
	
	@GetMapping("/list")
	public ResponseEntity<Response> movilesList(){
		return ResponseEntity.ok(
				Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("moviles recuperados")
				.Status(HttpStatus.OK)
				.Data(Map.of("moviles",this.movilService.getMoviles()))
				.build()
				);
		
	}
	@GetMapping("/{marca}")
	public ResponseEntity<Response> movilesListPorMarca(@PathVariable("marca") String marca){
		return ResponseEntity.ok(
				Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("moviles recuperados")
				.Status(HttpStatus.OK)
				.Data(Map.of("moviles",this.movilService.getMoviles().stream().filter(
						(Movil movil)-> movil.getMarca().startsWith(marca))
						.collect(Collectors.toList())))
				.build()
				);
		
	}
//	// HU1: Busqueda movil segun criterios:
//	/*
//	 * -marca
//	 * -bateria
//	 * -precio
//	 * -ram
//	 */
//	@GetMapping("/{marca}")
//	public List<Movil> buscarMovilMarca(@PathVariable("marca") String marca){
//		return this.movilService.getMoviles().stream().filter(
//				(Movil movil)-> movil.getMarca().startsWith(marca))
//				.collect(Collectors.toList());
//	}
	
	@GetMapping("/bateria/{bateria}")
	public List<Movil> buscarMovilBateria(@PathVariable("bateria") int bateria){
		return this.movilService.getMoviles().stream().filter(
				(Movil movil)-> movil.getBateria().getMwh()==bateria)
				.collect(Collectors.toList());
	}
	
	
	@GetMapping("/precio/{precio}")
	public List<Movil> buscarMovilPrecio(@PathVariable("precio") float precio){
		return this.movilService.getMoviles().stream().filter(
				(Movil movil)-> movil.getPrecio()==precio)
				.collect(Collectors.toList());
	}
	
	
	@GetMapping("/ram/{ram}")
	public List<Movil> buscarMovilRam(@PathVariable("ram") int ram){
		return this.movilService.getMoviles().stream().filter(
				(Movil movil)-> movil.getRam().getGb()==ram)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{marca}/{bateria}/{precio}/{ram}")
	public List<Movil> buscarMovilMarca(@PathVariable("marca") String marca, @PathVariable("bateria") int bateria,@PathVariable("precio") float precio,@PathVariable("ram") int ram){
		return this.movilService.getMoviles().stream().filter(
				(Movil movil)-> movil.getMarca().startsWith(marca) 
				&& movil.getBateria().getMwh()==bateria
				&& movil.getPrecio()==precio
				&& movil.getRam().getGb()==ram)
				.collect(Collectors.toList());
	}
	
	/*
	 * HU2: Comparar moviles
	 * Necesitamos dos moviles seleccionados para mostrar sus caracteristicas.
	 */
	@GetMapping("/{compararUno}/{compararDos}")
	public List<Movil> compararMoviles(@PathVariable("compararUno") String marcaUno, @PathVariable("compararDos") String marcaDos){
		List<Movil> dosMoviles = new ArrayList<Movil>();
		dosMoviles.add(this.movilService.getMoviles().stream().filter((a)-> a.getMarca().equals(marcaUno)).findFirst().get());
		dosMoviles.add(this.movilService.getMoviles().stream().filter((a)-> a.getMarca().equals(marcaDos)).findFirst().get());
		
		return dosMoviles;
	}
	
}

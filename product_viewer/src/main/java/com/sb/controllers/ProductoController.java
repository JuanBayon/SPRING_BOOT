package com.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sb.entities.Producto;
import com.sb.exceptions.ServicioException;
import com.sb.ln.interfaces.ProductoServicio;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoServicio servicio;
	
	@GetMapping
	public String listado(Model model) throws ServicioException {
		
		addAllModel(model);
		
		return "productos";
	}
	
	@GetMapping("/{id}")
	public String ver(Model model,@PathVariable Integer id) throws ServicioException {
		
		Producto producto = servicio.getOne(id);
		model.addAttribute("elemento", producto);
		
		return "producto";
	}
	
	
	@PostMapping
	public String crear(Model model, @RequestParam String nombre, @RequestParam Double precio) throws ServicioException {
		
		Producto producto = new Producto();
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		Producto productoSalvado = servicio.save(producto);
		model.addAttribute("elemento", productoSalvado);
		
		return "producto";
	}
	
	@GetMapping("/d/{id}")
	public String borrar(Model model, @PathVariable Integer id) throws ServicioException {
		
		Producto producto = servicio.getOne(id);
		servicio.delete(producto);
		addAllModel(model);
		
		return "productos";
	}

	@ExceptionHandler(value=ServicioException.class)
	public String handler(Exception e, Model model) {
		model.addAttribute("error", e);
		return "productos";
	}

	private void addAllModel(Model model) throws ServicioException {
		Iterable<Producto> productos = servicio.getAll();
		model.addAttribute("listado",productos);
	}

}

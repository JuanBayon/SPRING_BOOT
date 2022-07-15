package com.sb.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sb.entities.Producto;
import com.sb.exceptions.RestException;
import com.sb.exceptions.ServicioException;
import com.sb.ln.interfaces.ProductoServicio;

@RestController
@RequestMapping("/rest")
public class ProductoRestController {
	
	@Autowired
	ProductoServicio servicio;

	@GetMapping
	public List<Producto> get() throws RestException {
		List<Producto> list;
		try {
			list = (List<Producto>) servicio.getAll();
		} catch (ServicioException e) {
			throw new RestException(e.getMessage());
		}
		return list;
	}
	
	@GetMapping("/{id}")
	public Producto getUsuario(@PathVariable Integer id) throws RestException {
		Producto producto;
		try {
			producto = servicio.getOne(id);
		} catch (ServicioException e) {
			throw new RestException(e.getMessage());
		}
		return producto;
	}
	
	@PostMapping
	public void crear(@RequestBody Producto producto) throws RestException {
		try {
			servicio.save(producto);
		} catch (ServicioException e) {
			throw new RestException(e.getMessage());
		}
	}
	
	@DeleteMapping
	public void borrar(@RequestParam Integer id) throws RestException {
		try {
			servicio.delete(servicio.getOne(id));
		} catch (ServicioException e) {
			throw new RestException(e.getMessage());
		}
	}
	
	@ExceptionHandler(value=RestException.class)
	public ResponseEntity<Object> handleRest(RestException e) {
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("error", e.getMessage());
	    return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
	}

}

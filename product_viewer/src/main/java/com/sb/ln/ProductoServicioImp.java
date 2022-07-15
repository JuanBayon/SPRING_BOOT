package com.sb.ln;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.entities.Producto;
import com.sb.exceptions.ServicioException;
import com.sb.ln.interfaces.ProductoServicio;
import com.sb.repositories.ProductoRepositorio;

@Service
public class ProductoServicioImp implements ProductoServicio{
	
	@Autowired
	ProductoRepositorio repositorio;
	

	@Override
	public Iterable<Producto> getAll() throws ServicioException {
		
		Iterable<Producto> productos;
		try {
			productos = repositorio.findAll();
		} catch (Exception e) {
			throw new ServicioException(e.getMessage());
		}
		
		return productos;
	}


	@Override
	public Producto getOne(Integer id) throws ServicioException {
		Producto producto;
		try {
			producto = repositorio.findById(id).get();
		} catch (Exception e) {
			throw new ServicioException(e.getMessage());
		}		
		return producto;
	}


	@Override
	public Producto save(Producto producto) throws ServicioException {
		Producto productoSalvado;
		try {
			productoSalvado = repositorio.save(producto);
		} catch (Exception e) {
			throw new ServicioException(e.getMessage());
		}
		
		return productoSalvado;
		
	}


	@Override
	public void delete(Producto producto) throws ServicioException {
		try {
			repositorio.delete(producto);
		} catch (Exception e) {
			throw new ServicioException(e.getMessage());
		}
		
	}

}

package com.sb.ln.interfaces;

import com.sb.entities.Producto;
import com.sb.exceptions.ServicioException;

public interface ProductoServicio {

	public Iterable<Producto> getAll() throws ServicioException;

	public Producto getOne(Integer id) throws ServicioException;

	public Producto save(Producto producto) throws ServicioException;

	public void delete(Producto producto) throws ServicioException;

}

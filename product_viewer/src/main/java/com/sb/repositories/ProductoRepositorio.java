package com.sb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.entities.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository< Producto, Integer>{

}

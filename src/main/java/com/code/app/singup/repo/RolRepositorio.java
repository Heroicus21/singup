package com.code.app.singup.repo;

import java.util.Optional;

import com.code.app.singup.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositorio extends JpaRepository<Rol, Long>{

	public Optional<Rol> findByNombre(String nombre);
	
}

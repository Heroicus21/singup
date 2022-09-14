package com.code.app.singup.repo;

import com.code.app.singup.model.Usuario;
import com.code.app.singup.model.UsuarioHistorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UsuarioHistorialRepository extends JpaRepository<UsuarioHistorial,Long> {

}

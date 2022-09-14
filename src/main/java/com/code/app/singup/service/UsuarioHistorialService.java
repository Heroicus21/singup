package com.code.app.singup.service;

import com.code.app.singup.model.Usuario;
import com.code.app.singup.model.UsuarioHistorial;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;


public interface UsuarioHistorialService {

    void guardarHistorial(Usuario usuario, String method);
    Page<UsuarioHistorial> verHistorialDeUsuario(Pageable pageable) throws Exception;

}

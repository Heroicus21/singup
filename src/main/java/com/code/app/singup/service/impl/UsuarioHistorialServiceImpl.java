package com.code.app.singup.service.impl;

import com.code.app.singup.model.Usuario;
import com.code.app.singup.model.UsuarioHistorial;
import com.code.app.singup.repo.UsuarioHistorialRepository;
import com.code.app.singup.service.UsuarioHistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.Date;


@Service
public class UsuarioHistorialServiceImpl implements UsuarioHistorialService {


    @Autowired
    private UsuarioHistorialRepository usuarioHistorialRepository;

    @Override
    public void guardarHistorial(Usuario usuario, String method) {

        UsuarioHistorial usuarioHistorial= UsuarioHistorial.builder()
                                                            .fecha(new Date())
                                                            .usuario(usuario)
                                                            .method(method).build();
        usuarioHistorialRepository.save(usuarioHistorial);

    }

    @Override
    public Page<UsuarioHistorial> verHistorialDeUsuario(Pageable pageable)throws Exception {
        try {
                Page<UsuarioHistorial> usuarioHistorials=usuarioHistorialRepository.findAll(pageable);
                return usuarioHistorials;
        }catch (Exception e ){
            throw new Exception("Ocurrio un error");
        }
    }

}

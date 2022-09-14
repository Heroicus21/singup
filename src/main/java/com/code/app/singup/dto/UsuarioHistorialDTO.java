package com.code.app.singup.dto;

import com.code.app.singup.model.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
public class UsuarioHistorialDTO {

    private Pageable pageable;
    private String usuario;
}

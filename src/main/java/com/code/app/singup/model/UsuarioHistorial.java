package com.code.app.singup.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "historial_usuario")
public class UsuarioHistorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = true, updatable = true)
    private Usuario usuario;

    private String method;
    private Date fecha;


    public UsuarioHistorial() {
    }

    public UsuarioHistorial(long id, Usuario usuario, String method, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.method = method;
        this.fecha = fecha;
    }
}

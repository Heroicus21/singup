package com.code.app.singup.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistroDTO {

    private String nombre;
    private String username;
    private String email;
    private String password;
    private String rol;

}
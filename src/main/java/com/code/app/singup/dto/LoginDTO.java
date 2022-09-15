package com.code.app.singup.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    private String usernameOrEmail;
    private String password;

}

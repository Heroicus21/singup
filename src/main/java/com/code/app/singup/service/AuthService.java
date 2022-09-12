package com.code.app.singup.service;

import com.code.app.singup.dto.LoginDTO;
import com.code.app.singup.dto.RegistroDTO;

public interface AuthService {
    LoginDTO alta(RegistroDTO registroDTO);
    LoginDTO login(LoginDTO loginDTO);
}

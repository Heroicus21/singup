package com.code.app.singup.controller;

import com.code.app.singup.dto.LoginDTO;
import com.code.app.singup.dto.RegistroDTO;
import com.code.app.singup.service.AuthService;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/auth")
public class UserController {
    @Autowired
    AuthService authenticateService;

    @PostMapping(value ="/alta")
    public ResponseEntity<LoginDTO> alta(@RequestBody RegistroDTO dto){
        LoginDTO loginDTO=authenticateService.alta(dto);
        return ResponseEntity.ok(loginDTO);
    }

    @PostMapping(value ="/login")
    public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO dto) throws AuthenticationException {
        LoginDTO loginDTO=authenticateService.login(dto);
        return ResponseEntity.ok(loginDTO);
    }
}

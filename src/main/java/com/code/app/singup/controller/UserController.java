package com.code.app.singup.controller;

import com.code.app.singup.dto.LoginDTO;
import com.code.app.singup.dto.RegistroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/auth")
public class UserController {

    @PostMapping(value ="/alta")
    public ResponseEntity<LoginDTO> prueba(@RequestBody RegistroDTO dto){

        LoginDTO loginDTO= new LoginDTO();
        return ResponseEntity.ok(loginDTO);
    }
}

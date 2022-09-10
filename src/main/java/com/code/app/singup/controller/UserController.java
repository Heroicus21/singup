package com.code.app.singup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/api")
public class UserController {

    @GetMapping(value ="/pr")
    public String Prueba(){
        return "Funciona";
    }
}

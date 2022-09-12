package com.code.app.singup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api-rest")
public class ApiController {

    @GetMapping( value="/{num1}/{num2}")
    public String apiRest(@PathVariable (name ="num1") int num1, @PathVariable (name="num2") int num2){

        int result= num1+num2;
        return "El porcentaje es: "+result;

    }
}

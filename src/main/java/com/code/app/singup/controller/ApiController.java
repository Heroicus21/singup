package com.code.app.singup.controller;

import com.code.app.singup.dto.ApiRestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api-rest")
public class ApiController {

    @PostMapping(value="/")
    public String apiRest(@RequestBody ApiRestDTO apiRestDTO){

        int result= apiRestDTO.getNum1()+apiRestDTO.getNum2();
        return "El porcentaje es: %"+result;

    }
}

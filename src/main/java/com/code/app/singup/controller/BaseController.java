package com.code.app.singup.controller;

import com.code.app.singup.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    protected ResponseEntity processEception(Exception e){return ResponseEntity.internalServerError().build();}

    public ResponseDTO response200Ok(Object data){ return response(data,null);}

    public ResponseDTO response(Object data, String message){
        ResponseDTO response= ResponseDTO.builder()
                .data(data)
                .message(message)
                .success(true)
                .code(HttpStatus.OK.value())
                .build();
        return response;
    }

    public ResponseDTO fail(String message){
        ResponseDTO response= ResponseDTO.builder()
                .message(message)
                .success(false)
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
        return response;
    }
}

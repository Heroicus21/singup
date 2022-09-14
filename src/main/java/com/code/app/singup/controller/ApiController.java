package com.code.app.singup.controller;

import com.code.app.singup.dto.ApiRestDTO;
import com.code.app.singup.dto.UsuarioHistorialDTO;
import com.code.app.singup.model.UsuarioHistorial;
import com.code.app.singup.service.ApiService;
import com.code.app.singup.service.UsuarioHistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api-rest")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private UsuarioHistorialService usuarioHistorialService;

    /**
     *
     * @param apiRestDTO
     * @return
     */
    @PreAuthorize("hasRole('USER')")
    @PostMapping(value="/")
    public ResponseEntity<String> apiRest(@RequestBody ApiRestDTO apiRestDTO){

        String result= apiService.apiService(apiRestDTO);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value="/historial/{page}")
    public Page<UsuarioHistorial> verHistorial(@PathVariable Integer page) throws Exception {

        try{
            return  usuarioHistorialService.verHistorialDeUsuario(PageRequest.of(page,5));
        }catch (Exception e){
            throw new Exception("Ocurrio un error");

        }
    }

}

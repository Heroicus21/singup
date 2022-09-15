package com.code.app.singup.controller;

import com.code.app.singup.dto.ApiRestDTO;
import com.code.app.singup.dto.ResponseDTO;
import com.code.app.singup.model.UsuarioHistorial;
import com.code.app.singup.service.ApiService;
import com.code.app.singup.service.UsuarioHistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api-rest")
public class ApiController extends BaseController{

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
    public ResponseDTO<String> apiRest(@RequestBody ApiRestDTO apiRestDTO){
        try {
            String result= apiService.apiService(apiRestDTO);
            return  response200Ok(result);
        } catch (Exception e ){
            return fail(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value="/historial/{page}")
    public ResponseDTO<Page<UsuarioHistorial>> verHistorial(@PathVariable Integer page) throws Exception {
        try {
            Page<UsuarioHistorial> result= usuarioHistorialService.verHistorialDeUsuario(PageRequest.of(page,5));
            return  response200Ok(result);
        } catch (Exception e ){
            return fail(e.getMessage());
        }
    }

}

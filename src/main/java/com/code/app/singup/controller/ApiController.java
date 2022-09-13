package com.code.app.singup.controller;

import com.code.app.singup.dto.ApiRestDTO;
import com.code.app.singup.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api-rest")
public class ApiController {

    @Autowired
    private ApiService apiService;
    /**
     *
     * @param apiRestDTO
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value="/")
    public ResponseEntity<String> apiRest(@RequestBody ApiRestDTO apiRestDTO){

        String result= apiService.apiService(apiRestDTO);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}

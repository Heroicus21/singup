package com.code.app.singup.controller;

import com.code.app.singup.dto.LoginDTO;
import com.code.app.singup.dto.RegistroDTO;
import com.code.app.singup.dto.ResponseDTO;
import com.code.app.singup.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RequestMapping(value ="/auth")
public class UserController extends BaseController{
    @Autowired
    AuthService authenticateService;

    /**
     *
     * @param dto
     * @return
     * @throws Exception
     */
    @PostMapping(value ="/alta")
    public ResponseDTO<LoginDTO> alta(@RequestBody RegistroDTO dto)throws Exception{
        try {
            LoginDTO loginDTO=authenticateService.alta(dto);
            return response200Ok(loginDTO);
        }catch (Exception e ){
            return fail(e.getMessage());
        }
    }

    /**
     *
     * @param dto
     * @return
     * @throws Exception
     */
    @PostMapping(value ="/login")
    public ResponseDTO<LoginDTO> login(@RequestBody LoginDTO dto) throws Exception {
        try {
            LoginDTO loginDTO=authenticateService.login(dto);
            return response(loginDTO,"Usuario activo");
        }catch (Exception e ){
            return fail(e.getMessage());
        }
    }
}

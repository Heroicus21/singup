package com.code.app.singup;

import com.code.app.singup.dto.ApiRestDTO;
import com.code.app.singup.model.Rol;
import com.code.app.singup.repo.RolRepositorio;
import com.code.app.singup.repo.UsuarioRepository;
import com.code.app.singup.service.ApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class ApiRestTest {

    @Mock
    private ApiService apiService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private RolRepositorio rolRepository;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        ApiRestDTO apiRestDTO= new ApiRestDTO();
        apiRestDTO.setNum1(5);
        apiRestDTO.setNum2(5);
    }

    @Test
    void insertRol(){
        Rol rolUser = Rol.builder().nombre("USER").build();
        Rol rolAdmin= Rol.builder().nombre("ADMIN").build();
        when(rolRepository.save(rolUser)).thenReturn(Rol.builder().id(1L).nombre("ADMIN").build());
        assertNotNull(rolRepository.findByNombre("ADMIN"));
    }

    @Test
    void apiRestRun(){
        ApiRestDTO apiRestDTO= new ApiRestDTO();
        apiRestDTO.setNum1(5);
        apiRestDTO.setNum2(5);

        when(apiService.apiService(apiRestDTO)).thenReturn("El retorno es : %"+ 11);
        assertNotNull(apiService.apiService(apiRestDTO));
    }

}

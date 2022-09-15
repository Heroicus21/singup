package com.code.app.singup.service.impl;

import com.code.app.singup.dto.LoginDTO;
import com.code.app.singup.dto.RegistroDTO;
import com.code.app.singup.model.Rol;
import com.code.app.singup.model.Usuario;
import com.code.app.singup.repo.RolRepositorio;
import com.code.app.singup.repo.UsuarioRepository;
import com.code.app.singup.service.AuthService;
import com.sun.jdi.event.ExceptionEvent;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private RolRepositorio rolRepositorio;

    /**
     *
     * @param registroDTO
     * @return
     * @throws Exception
     */
    @Override
    public LoginDTO alta(RegistroDTO registroDTO) throws Exception{
        try {
            Optional<Rol> rol= rolRepositorio.findByNombre(registroDTO.getRol());
            Set<Rol> rolSet= new HashSet<>();
            PasswordEncoder encoder= new BCryptPasswordEncoder();

            if (rol.isEmpty()) throw new Exception("Se debe de elegir al menos un rol");
            rolSet.add(rol.get());

            Usuario usuario=  Usuario.builder()
                    .password(encoder.encode(registroDTO.getPassword()))
                    .email(registroDTO.getEmail())
                    .username(registroDTO.getUsername())
                    .nombre(registroDTO.getNombre())
                    .intentos(0)
                    .roles(rolSet).build();

            Usuario result=repository.save(usuario);
            LoginDTO loginDTO= LoginDTO.builder()
                    .usernameOrEmail(result.getUsername())
                    .build();

            return loginDTO;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    /**
     *
     *
     * @param loginDTO
     * @return
     * @throws Exception
     */
    @Override
    public LoginDTO login(LoginDTO loginDTO) throws Exception {
    try {
            Optional<Usuario> usuario=repository.findByUsernameOrEmail(loginDTO.getUsernameOrEmail(), loginDTO.getUsernameOrEmail());
            Usuario result=usuario.get();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (!encoder.matches(loginDTO.getPassword(), result.getPassword())){
                throw new AuthenticationException("La contraseña no coincide");
            }

        LoginDTO resultDTO= new LoginDTO();
            resultDTO.setUsernameOrEmail(result.getUsername());
            resultDTO.setPassword(result.getPassword());

            return resultDTO;

        }catch (Exception event){
            throw new Exception("Ocurrio un error");
    }

    }


}

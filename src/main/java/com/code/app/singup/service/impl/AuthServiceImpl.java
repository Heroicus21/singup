package com.code.app.singup.service.impl;

import com.code.app.singup.dto.LoginDTO;
import com.code.app.singup.dto.RegistroDTO;
import com.code.app.singup.model.Rol;
import com.code.app.singup.model.Usuario;
import com.code.app.singup.repo.RolRepositorio;
import com.code.app.singup.repo.UsuarioRepository;
import com.code.app.singup.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AuthServiceImpl implements AuthService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private RolRepositorio rolRepositorio;


    @Override
    public LoginDTO alta(RegistroDTO registroDTO) {
        PasswordEncoder encoder= new BCryptPasswordEncoder();
        Usuario usuario= new Usuario();
        usuario.setPassword(encoder.encode(registroDTO.getPassword()));
        usuario.setEmail(registroDTO.getEmail());
        usuario.setNombre(registroDTO.getNombre());
        Optional<Rol> rol= rolRepositorio.findByNombre("USER");
        Set<Rol> rolSet= new HashSet<>();
        rolSet.add(rol.get());
        usuario.setRoles(rolSet);
        Usuario result=repository.save(usuario);
        LoginDTO loginDTO= new LoginDTO();
        loginDTO.setPassword(result.getPassword());
        loginDTO.setUsernameOrEmail(usuario.getUsername());

        return loginDTO;
    }

    @Override
    public LoginDTO login(LoginDTO loginDTO) {

        Optional<Usuario> usuario=repository.findByUsernameOrEmail(loginDTO.getUsernameOrEmail(), loginDTO.getUsernameOrEmail());
        Usuario result=usuario.get();

        LoginDTO resultDTO= new LoginDTO();

        resultDTO.setUsernameOrEmail(result.getUsername());
        resultDTO.setPassword(result.getPassword());
        return null;
    }


}

package com.code.app.singup.repo;


import com.code.app.singup.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {


    public Optional<Usuario> findByEmail(String email);
    public Optional<Usuario> findByUsernameOrEmail(String username,String email);

    public Optional<Usuario> findByUsername(String username);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);

}

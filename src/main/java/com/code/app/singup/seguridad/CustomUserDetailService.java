package com.code.app.singup.seguridad;

import com.code.app.singup.model.Rol;
import com.code.app.singup.model.Usuario;
import com.code.app.singup.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repoUser;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Usuario usuario= repoUser.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con ese Username o email"));
        return new User(usuario.getEmail(),usuario.getPassword(),mapearRoles(usuario.getRoles()));
    }


    private Collection<? extends GrantedAuthority> mapearRoles(Set<Rol> roles){
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
    }
}

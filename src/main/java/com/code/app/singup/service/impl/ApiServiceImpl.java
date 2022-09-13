package com.code.app.singup.service.impl;

import com.code.app.singup.dto.ApiRestDTO;
import com.code.app.singup.dto.PokemonDTO;
import com.code.app.singup.model.Usuario;
import com.code.app.singup.repo.UsuarioRepository;
import com.code.app.singup.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    private UsuarioRepository repoUsuario;
    @Override
    public String apiService(ApiRestDTO dto) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        Optional<Usuario> usuarioOP = null;
        try {
            usuarioOP = repoUsuario.findByUsernameOrEmail(username, username);

            int randomNum = ThreadLocalRandom.current().nextInt(1, 150);
            String url = "https://pokeapi.co/api/v2/move/" + randomNum + "/";
            RestTemplate restTemplate = new RestTemplate();
            PokemonDTO pokemonQueTomaElPorcentaje = restTemplate.getForObject(url, PokemonDTO.class);

            if (usuarioOP.get().getIntentos() > 3) throw new Exception("El usuario no tiene mas intentos disponibles");

            int suma = (dto.getNum1() + dto.getNum2()) + pokemonQueTomaElPorcentaje.getPower();

            String s = "El porcentage es : %" + suma;
            return s;
        } catch (RestClientException e) {
            usuarioOP.get().setIntentos(usuarioOP.get().getIntentos() + 1);
            repoUsuario.save(usuarioOP.get());
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

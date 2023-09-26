package com.example.apicadastrotodostec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByCemail(String cemail);
    Optional<Usuario> findByCusername(String cusername);
    Optional<Usuario> findByCsenha(String csenha);

    List<Usuario> findAllByCusername(String cusername);
    List<Usuario> findAllByCtelefone(String ctelefone);


}

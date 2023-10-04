package com.example.apicadastrotodostec.Repository;

import com.example.apicadastrotodostec.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByCemail(String cemail);
    Optional<Usuario> findByCusername(String cusername);
    Optional<Usuario> findByCsenha(String csenha);
    List<Usuario> findAllByCtelefone(String ctelefone);


}

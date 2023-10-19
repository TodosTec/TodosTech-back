package com.example.apicadastrotodostec.Repository;

import com.example.apicadastrotodostec.Entity.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
}

package com.example.apicadastrotodostec.Repository;

import com.example.apicadastrotodostec.Entity.Historico;
import com.example.apicadastrotodostec.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}

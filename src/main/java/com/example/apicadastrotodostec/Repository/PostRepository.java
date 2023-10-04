package com.example.apicadastrotodostec.Repository;

import com.example.apicadastrotodostec.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p, u.cusername, u.cnome, u.clinksite FROM Post p, Usuario u WHERE u.clinksite IS NOT NULL AND u.ncdusuario = p.ncdusuario")
    List<Post> findAllByLinkExistente();
}// Trazer posts pagos

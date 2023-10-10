package com.example.apicadastrotodostec.Repository;

import com.example.apicadastrotodostec.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p, u.cusername, u.cnome, u.clinksite FROM Post p, Usuario u WHERE u.clinksite IS NULL AND u.ncdusuario = p.ncdusuario ORDER BY RANDOM() LIMIT 9")
    List<Post> findAllByLinkExistente();

    @Query("SELECT p, u.cusername, u.cnome, u.clinksite FROM Post p, Usuario u WHERE u.clinksite IS NOT NULL AND u.ncdusuario = p.ncdusuario ORDER BY RANDOM() LIMIT 1")
    Post findOneByLinkExistente();

    @Query(value = "SELECT p, u.clinksite FROM Post p, Usuario u  WHERE u.ncdusuario = p.ncdusuario AND u.clinksite IS NOT NULL ORDER BY RANDOM() LIMIT 1")
    Optional<Post> findRandomPostsWithClinksite();

}
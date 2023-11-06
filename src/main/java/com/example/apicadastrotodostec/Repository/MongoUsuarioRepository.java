package com.example.apicadastrotodostec.Repository;

import com.example.apicadastrotodostec.Entity.Usuario;
import com.example.apicadastrotodostec.Entity.UsuarioMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoUsuarioRepository extends MongoRepository<UsuarioMongo, String> {
}

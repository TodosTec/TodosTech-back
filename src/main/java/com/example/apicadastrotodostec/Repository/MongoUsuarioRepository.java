package com.example.apicadastrotodostec.Repository;

import com.example.apicadastrotodostec.Entity.users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoUsuarioRepository extends MongoRepository<users, String> {
}

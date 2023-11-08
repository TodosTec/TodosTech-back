package com.example.apicadastrotodostec.Repository;

import com.example.apicadastrotodostec.Entity.messages;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagensRepository extends MongoRepository<messages, String> {
}

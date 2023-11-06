package com.example.apicadastrotodostec.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "usuario")
@Getter
@Setter
@AllArgsConstructor
public class UsuarioMongo {

    private String cnome;


}

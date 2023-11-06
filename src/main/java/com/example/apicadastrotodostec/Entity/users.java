package com.example.apicadastrotodostec.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "users")
@Getter
@Setter
@AllArgsConstructor
public class users {

    private String cusername;


}

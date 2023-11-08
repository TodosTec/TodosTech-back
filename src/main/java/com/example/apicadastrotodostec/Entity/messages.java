package com.example.apicadastrotodostec.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
public class messages {

    private String nomeChat;
    private String username;
    private String message;

}

package com.example.apicadastrotodostec.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ncdusuario;
    private String cnome;
    private String cusername;
    private String csenha;
    private String ctelefone;
    private String cemail;
    private String ncontaativa = "1";
    private Long ncdpronome;
    private Long ncdgenero;
    private Long ncdsexualidade;
    private String cdescricao;
    private String clinksite;
    private String clinkfoto;
    // link do site
}
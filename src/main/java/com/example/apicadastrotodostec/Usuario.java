package com.example.apicadastrotodostec;
import jakarta.persistence.*;
import lombok.*;

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
    private long ncdusuario;
    private String cnome;
    private String cusername;
    private String csenha;
    private String ctelefone;
    private String cemail;
    @Transient
    private String ncontaativa;
    private long ncdpronome;
    private long ncdgenero;
    private long ncdsexualidade;
    private String cdescricao;
}
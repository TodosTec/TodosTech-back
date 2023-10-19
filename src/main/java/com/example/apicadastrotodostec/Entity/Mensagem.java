package com.example.apicadastrotodostec.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ncdmensagem;
    private String ctexto;
    private Long ncdusuariorecebe;
    private Long ncdusuario;


    @ManyToOne
    @JoinColumn(name = "ncdusuario", referencedColumnName = "ncdusuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ncdusuariorecebe", referencedColumnName = "ncdusuario", insertable = false, updatable = false)
    private Usuario usuario1;
}

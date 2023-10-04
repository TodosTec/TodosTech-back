package com.example.apicadastrotodostec.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ncdpost;
    private String ctexto;
    private Long ncdusuario;

    @ManyToOne
    @JoinColumn(name = "ncdusuario", referencedColumnName = "ncdusuario", insertable = false, updatable = false)
    private Usuario usuario;

}

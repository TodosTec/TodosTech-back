package com.example.apicadastrotodostec.DTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UsuarioLoginDTO {
    @Id
    private String cusername;
    private String csenha;

}
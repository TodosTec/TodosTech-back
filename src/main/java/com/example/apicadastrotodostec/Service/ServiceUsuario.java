package com.example.apicadastrotodostec.Service;


import com.example.apicadastrotodostec.Entity.Usuario;
import com.example.apicadastrotodostec.Entity.UsuarioMongo;
import com.example.apicadastrotodostec.Repository.MongoUsuarioRepository;
import com.example.apicadastrotodostec.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ServiceUsuario {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    MongoUsuarioRepository mongoUsuarioRepository;

    UsuarioMongo usuarioMongo;
    public boolean inserirUsuarios(Usuario usuario){

        usuarioMongo = new UsuarioMongo(usuario.getCnome().toString());

        usuarioRepository.save(usuario);
        mongoUsuarioRepository.save(usuarioMongo);
        return true;
    }
}

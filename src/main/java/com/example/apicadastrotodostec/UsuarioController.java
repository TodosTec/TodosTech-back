package com.example.apicadastrotodostec;
// Api referente ao Cadastro

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //trabalha com JSON
@CrossOrigin
@RequestMapping("/api/todostec")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    @GetMapping("/selecionar")
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }
    @GetMapping("/selecionar/email/{cemail}")
    public String listarUsuarioPorEmail(@PathVariable String cemail){
        List<Usuario> res = usuarioRepository.findAllByCemail(cemail);
        if(res.size() != 0) {
            return "Email existe";
        } else {
            return "Email liberado";
        }
    }
//
    @GetMapping("/selecionar/telefone/{ctelefone}")
    public String listarUsuarioPorTelefone(@PathVariable String ctelefone){
        List<Usuario> res = usuarioRepository.findAllByCtelefone(ctelefone);
        if(res.size() != 0) {
            return "Telefone existe";
        } else {
            return "Telefone liberado";
        }
    }

    @GetMapping("/selecionar/username/{cusername}")
    public String listarUsuarioPorUsername(@PathVariable String cusername){
        List<Usuario> res = usuarioRepository.findAllByCusername(cusername);
        if (res.size() != 0) {
            return "Username existe";
        } else {
            return "Username liberado";
        }
    }


    @PostMapping("/selecionar/login")
    public String encontrarUsername(@RequestBody UsuarioLoginDTO usuarioLogin){
        Optional<Usuario> usuarioExistente = usuarioRepository.findByCusername(usuarioLogin.getCusername());
        if(usuarioExistente.isPresent()){
            if(usuarioExistente.get().getCsenha().equals(usuarioLogin.getCsenha())) {
                return "Logado";
            } else {
                return "Senha incorreta";
            }
        } else{
            return "Nome de usuário inexistente";
        }
    }

    @PostMapping("/inserir")
    public boolean inserirUsuarios(@RequestBody Usuario usuario)
    {
        usuario.setNcontaativa("1");
        usuarioRepository.save(usuario);
        return true;
    }
}
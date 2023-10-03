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
    public ResponseEntity<RespostaJSON> listarUsuarioPorEmail(@PathVariable String cemail){
        List<Usuario> res = usuarioRepository.findAllByCemail(cemail);
        if(res.size() != 0) {
            RespostaJSON resposta = new RespostaJSON("Email existe", "sucesso");
            return ResponseEntity.ok(resposta);
        } else {
            RespostaJSON resposta = new RespostaJSON("Email liberado", "sucesso");
            return ResponseEntity.ok(resposta);
        }
    }
    //
    @GetMapping("/selecionar/telefone/{ctelefone}")
    public ResponseEntity<RespostaJSON> listarUsuarioPorTelefone(@PathVariable String ctelefone) {
        List<Usuario> res = usuarioRepository.findAllByCtelefone(ctelefone);
        if (res.size() != 0) {
            RespostaJSON resposta = new RespostaJSON("Telefone existe", "sucesso");
            return ResponseEntity.ok(resposta);
        } else {
            RespostaJSON resposta = new RespostaJSON("Telefone liberado", "sucesso");
            return ResponseEntity.ok(resposta);
        }
    }


    @GetMapping("/selecionar/username/{cusername}")
    public ResponseEntity<RespostaJSON> listarUsuarioPorUsername(@PathVariable String cusername){
        List<Usuario> res = usuarioRepository.findAllByCusername(cusername);
        if (res.size() != 0) {
            RespostaJSON resposta = new RespostaJSON("Username existe", "sucesso");
            return ResponseEntity.ok(resposta);
        } else {
            RespostaJSON resposta = new RespostaJSON("Username liberado", "sucesso");
            return ResponseEntity.ok(resposta);
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
        usuarioRepository.save(usuario);
        return true;
    }
}
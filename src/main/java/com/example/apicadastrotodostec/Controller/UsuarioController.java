package com.example.apicadastrotodostec.Controller;
// Api referente ao Cadastro


import com.example.apicadastrotodostec.Repository.UsuarioRepository;
import com.example.apicadastrotodostec.DTO.RespostaJSON;
import com.example.apicadastrotodostec.Entity.Usuario;
import com.example.apicadastrotodostec.DTO.UsuarioLoginDTO;
import com.example.apicadastrotodostec.Service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController //trabalha com JSON
@CrossOrigin
@RequestMapping("/api/todostec")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private ServiceUsuario serviceUsuario;
    private static String CHAT_ENGINE_PROJECT_ID = "00082846-ba28-48e2-919e-ccba46a41346";
    private static String CHAT_ENGINE_PRIVATE_KEY = "8a875301-c34d-4df0-b73d-27d61ad95e81";
    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    @GetMapping("/selecionar")
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }
    @GetMapping("/selecionar/username/{cusername}")
    public Optional<Usuario> trazerUsuario(@PathVariable String cusername){
        return usuarioRepository.findByCusername(cusername);
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


    @GetMapping("/selecionar/verificarUsername/{cusername}")
    public ResponseEntity<RespostaJSON> listarUsuarioPorUsername(@PathVariable String cusername){
        Optional<Usuario> res = usuarioRepository.findByCusername(cusername);
        if (res.isPresent()) {
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
                return usuarioExistente.toString();
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
            if(ObjectUtils.isEmpty(usuario.getClinkfoto())){
                usuario.setClinkfoto("https://icons-for-free.com/iconfiles/png/512/city+citycons+corporate+icon-1320136424674449796.png");

            }
            serviceUsuario.inserirUsuarios(usuario);
            return true;
        }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado){
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if(usuarioExistente.isPresent()){
            Usuario usuario = usuarioExistente.get();
            usuario.setCnome(usuarioAtualizado.getCnome());
            usuario.setCusername(usuarioAtualizado.getCusername());
            usuario.setCsenha(usuarioAtualizado.getCsenha());
            usuario.setCtelefone(usuarioAtualizado.getCtelefone());
            usuario.setCemail(usuarioAtualizado.getCemail());
            usuario.setNcdpronome(usuarioAtualizado.getNcdpronome());
            usuario.setNcdgenero(usuarioAtualizado.getNcdgenero());
            usuario.setNcdsexualidade(usuarioAtualizado.getNcdsexualidade());
            usuario.setCdescricao(usuarioAtualizado.getCdescricao());
            usuario.setClinkfoto(usuarioAtualizado.getClinkfoto());
            usuario.setClinksite(usuarioAtualizado.getClinksite());
            usuarioRepository.save(usuario);
            return ResponseEntity.ok("Usuario atualizado com sucesso.");

        } else{
            return ResponseEntity.notFound().build();
        }
    }


}
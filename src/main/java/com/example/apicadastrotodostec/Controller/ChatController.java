package com.example.apicadastrotodostec.Controller;

import com.example.apicadastrotodostec.Entity.messages;
import com.example.apicadastrotodostec.Entity.users;
import com.example.apicadastrotodostec.Repository.MensagensRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/todostec/chat")
public class ChatController {

    private final MensagensRepository mensagensRepository;

    public ChatController(MensagensRepository mensagensRepository) {
        this.mensagensRepository = mensagensRepository;
    }

    @GetMapping("/findall/mongo")
    public List<messages> findAllMongo(){
        return mensagensRepository.findAll();
    }
}

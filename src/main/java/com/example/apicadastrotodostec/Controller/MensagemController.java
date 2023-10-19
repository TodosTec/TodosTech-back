package com.example.apicadastrotodostec.Controller;

import com.example.apicadastrotodostec.Entity.Mensagem;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/todostec/mensagem")
public class MensagemController {
    @MessageMapping("/chatMessage")
    @SendTo("/canal")
    public Mensagem sendMessage(Mensagem message){
        return message;
    }
}

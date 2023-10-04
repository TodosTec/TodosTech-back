package com.example.apicadastrotodostec.Controller;

import com.example.apicadastrotodostec.Entity.Post;
import com.example.apicadastrotodostec.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/todostec/post")
public class PostController {
    private final PostRepository postRepository;
    @Autowired
    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @GetMapping("/selecionar")
    public List<Post> listarPosts(){
        return postRepository.findAll();
    }

    @GetMapping("/selecionar/site")
    public List<Post> listarPostsPorLinkSite() {
        return postRepository.findAllByLinkExistente();
    }

@PostMapping("/inserir")
    public boolean inserirPosts(@RequestBody Post post)
    {
        postRepository.save(post);
        return true;
    }
}

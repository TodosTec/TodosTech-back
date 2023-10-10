package com.example.apicadastrotodostec.Controller;

import com.example.apicadastrotodostec.Entity.Post;
import com.example.apicadastrotodostec.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List
            <Post> listarPosts(){
        return postRepository.findAll();
    }

    ArrayList<Long> postsUsados = new ArrayList<>();

    @GetMapping("/selecionar/random")
    public ArrayList<Post> listarPostsAleatoriosComClinksite() {
        ArrayList<Post> posts = new ArrayList<>();
        ArrayList<Post> postsLink = new ArrayList<>(postRepository.findAllByLinkExistente());
        Post featuredPost = postRepository.findRandomPostsWithClinksite().orElse(postRepository.findOneByLinkExistente());
        int nMaximo = postRepository.findAll().size()   ;
        int numeroaleatorio = new java.util.Random().nextInt((9 - 0) + 1) + 0;
        if (featuredPost != null) {
            postsLink.add(numeroaleatorio, featuredPost);
        }
        if(postsUsados.size() > nMaximo - 3) {
                postsUsados = new ArrayList<>();
        }

        postsLink.stream().forEach(post -> {
        if (!postsUsados.contains(post.getNcdpost())) {
            postsUsados.add(post.getNcdpost());
            posts.add(post);
        }
         });
            return posts;
    }





    @PostMapping("/inserir")
    public boolean inserirPosts(@RequestBody Post post)
    {
        postRepository.save(post);
        return true;
    }
}

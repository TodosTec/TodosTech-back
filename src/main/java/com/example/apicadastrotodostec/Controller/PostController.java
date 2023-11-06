package com.example.apicadastrotodostec.Controller;

import com.example.apicadastrotodostec.Entity.Historico;
import com.example.apicadastrotodostec.Entity.Post;
import com.example.apicadastrotodostec.Repository.HistoricoRepository;
import com.example.apicadastrotodostec.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    HistoricoRepository historicoRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/selecionar")
    public List
            <Post> listarPosts() {
        return postRepository.findAll();
    }

    ArrayList<Post> postsUsados = new ArrayList<>();

    @GetMapping("/selecionar/random")
    public ArrayList<Post> listarPostsAleatoriosComClinksite() {
        ArrayList<Post> postsToAdd = new ArrayList<>();
        ArrayList<Post> allPosts = new ArrayList<>(postRepository.findAll());
        int nMax = allPosts.size();
        if(nMax == postsUsados.size()){
            postsUsados = new ArrayList<>();
        }
        while(postsToAdd.size() < 10 && nMax != postsUsados.size()){
            ArrayList<Post> posts = new ArrayList<>(postRepository.findAllWithoutLinkExistente());
            Post featuredPost = postRepository.findRandomPostsWithClinksite().orElse(null);

            if (featuredPost != null) {
                if (!isPostAlreadyUsed(featuredPost)) {
                    System.out.println("Post Pago Adicionado!");
                    posts.add(featuredPost);
                } else {
                    System.out.println("Post Pago repetido, cancela.");
                }
            }

            for (Post post : posts) {
                if (!isPostAlreadyUsed(post)) {
                    System.out.println("Novo post adicionado aos usados: " + post.getNcdpost());
                    postsUsados.add(post);
                    postsToAdd.add(post);
                } else {
                    System.out.println("Post já foi usado: " + post.getNcdpost());
                }
            }
        }

        return postsToAdd;
    }

    private boolean isPostAlreadyUsed(Post post) {
        System.out.println("entrou");
        for (Post postUsado : postsUsados) {
            if (postUsado.getNcdpost().equals(post.getNcdpost())) {
                return true;
            }
        }
        return false;
    }





    @GetMapping("/selecionar/{cusername}")
    public Optional<List<Post>> listarPostsComUsername(@PathVariable String cusername) {

        return postRepository.findAllPostsByUsername(postRepository.findIdUsuarioByUsername(cusername));
    }


    @PostMapping("/inserir")
    public boolean inserirPosts(@RequestBody Post post) {
        postRepository.save(post);
        return true;
    }

    @GetMapping("/find/posts/{ncdUsuario}")
    public Page<Post> findPostNotView(@PathVariable Long ncdUsuario) {
        try {
            Pageable pageable1 = PageRequest.of(0, 10);

            Page<Post> postPage = postRepository.findPostNotView(ncdUsuario,pageable1);

            List<Post> postList = postPage.getContent();


            List<Historico> historicoList = new ArrayList<>();

            for (Post post : postList) {

                Historico historico = new Historico();
                historico.setNcdusuario(ncdUsuario);
                historico.setNcdpost(post.getNcdpost());

                historicoList.add(historico);
            }

            historicoRepository.saveAll(historicoList);

            return postPage;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocorreu um erro ao processar a solicitação.");
        }
    }


}

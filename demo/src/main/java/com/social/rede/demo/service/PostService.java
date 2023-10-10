package com.social.rede.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.rede.demo.model.Post;
import com.social.rede.demo.repository.PostRepo;

@Service
public class PostService {
    
    @Autowired
    private PostRepo postRepository;

    public void criarPost(Post post) {
        List<String> repostas = new ArrayList<>();
        post.setRespostas(repostas);
        postRepository.save(post);
    }

    public void comentar(String comentario, String idPost) {
        Post post = postRepository.findById(idPost).orElse(null);
        if(post != null) {
            post.getRespostas().add(comentario);
            postRepository.save(post);
        }
    }

    public Post buscarPost(String idPost) {
        return postRepository.findById(idPost).orElse(null);
    }

    public List<Post> listarPosts() {
        return postRepository.findAll();
    }

    public Boolean deletarPost(String idPost) {
        if(postRepository.existsById(idPost)) {
            postRepository.deleteById(idPost);
            return true;
        }
        return false;
    }

}


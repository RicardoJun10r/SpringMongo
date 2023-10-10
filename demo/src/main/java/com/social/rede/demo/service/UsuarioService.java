package com.social.rede.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.rede.demo.model.Post;
import com.social.rede.demo.model.Usuario;
import com.social.rede.demo.repository.UsuarioRepo;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepo usuarioRepository;

    public void criarUsuario(Usuario usuario) {
        List<Post> posts = new ArrayList<>();
        List<Usuario> amigos = new ArrayList<>();
        usuario.setAmigos(amigos);
        usuario.setPosts(posts);
        usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuario(String email) {
        return usuarioRepository.findById(email).orElse(null);
    }

    public void deletarUsuario(String email) {
        usuarioRepository.deleteById(email);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void adicionarPost(String email, Post post) {
        Usuario usuario = buscarUsuario(email);
        if(usuario != null) {
            List<String> respostas = new ArrayList<>();
            post.setRespostas(respostas);
            if(post.getEhPrivado() == null) post.setEhPrivado(false);
            post.setId(UUID.randomUUID().toString());
            usuario.getPosts().add(post);
            usuarioRepository.save(usuario);
        }
    }

    public void comentar(String comentario, String email, String iDpost){
        Usuario usuario = buscarUsuario(email);
        if(usuario != null) {
            usuario.getPosts().forEach(p -> {
                if(p.getId().equals(iDpost)){
                    p.getRespostas().add(comentario);
                }
            });
            usuarioRepository.save(usuario);
        }
    }

}
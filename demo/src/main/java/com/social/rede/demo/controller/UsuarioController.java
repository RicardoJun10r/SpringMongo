package com.social.rede.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.rede.demo.model.Post;
import com.social.rede.demo.model.Usuario;
import com.social.rede.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private postService postService;

    @PostMapping
    public void save(@RequestBody Usuario usuario) {
        usuarioService.criarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{email}")
    public Usuario buscar(@PathVariable String email) {
        return usuarioService.buscarUsuario(email);
    }

    @DeleteMapping("/{email}")
    public void remove(@PathVariable String email) {
        usuarioService.deletarUsuario(email);
    }

    @PostMapping("/post/{email}")
    public void criarPost(@PathVariable String email, @RequestBody Post post) {
        usuarioService.adicionarPost(email, post);
    }

    @DeleteMapping("/post/{idPost}")
    public void deletarPost(@PathVariable String idPost) {
        postService.deletarPost(idPost);
    }

    @GetMapping("/post/{idPost}")
    public Post buscarPost(@PathVariable String idPost) {
        return postService.buscarPost(idPost);
    }

    @GetMapping("/post")
    public List<Post> listarTodosPosts() {
        return postService.listarPosts();
    }

    @PostMapping("/post/{email}/{idPost}")
    public void comentar(@PathVariable String email, @PathVariable String idPost, @RequestBody ComentarDTO comentario) {
        String res = comentario.email() + "\n" + comentario.comentario();
        usuarioService.comentar(res, email, idPost);
    }

}
package com.social.rede.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.social.rede.demo.model.Usuario;

public interface UsuarioRepo extends MongoRepository<Usuario, String> {

}

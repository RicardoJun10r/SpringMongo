package com.social.rede.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.social.rede.demo.model.Post;

public interface PostRepo extends MongoRepository<Post, String> {

}

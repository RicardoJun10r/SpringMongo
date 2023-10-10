package com.social.rede.demo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "posts")
public class Post implements Serializable {
    private String id;
    private String mensagem;
    private List<String> respostas;
    private Boolean ehPrivado;
}

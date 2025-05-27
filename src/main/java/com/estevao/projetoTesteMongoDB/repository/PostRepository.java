package com.estevao.projetoTesteMongoDB.repository;

import com.estevao.projetoTesteMongoDB.models.entities.Post;
import com.estevao.projetoTesteMongoDB.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {
}

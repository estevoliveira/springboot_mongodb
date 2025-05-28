package com.estevao.projetoTesteMongoDB.repository;

import com.estevao.projetoTesteMongoDB.models.entities.Post;
import com.estevao.projetoTesteMongoDB.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.Instant;
import java.util.List;

public interface PostRepository extends MongoRepository<Post,String> {

    List<Post> findByTitleContainingIgnoreCase(String title);

    @Query("{ $and: [ { moment: {$gte: ?1} }, {moment: {$lte: ?2} } , { $or: [ { 'title': {$regex: ?0,$options: 'i' }},{'body': { $regex: ?0,$options: 'i'}},{'comments.text': { $regex: ?0, $options: 'i' }} ] }]}")
    List<Post> fullSearch(String text, Instant start, Instant end);
}

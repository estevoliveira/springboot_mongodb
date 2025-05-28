package com.estevao.projetoTesteMongoDB.service;

import com.estevao.projetoTesteMongoDB.models.dto.PostDTO;
import com.estevao.projetoTesteMongoDB.models.entities.Post;
import com.estevao.projetoTesteMongoDB.repository.PostRepository;
import com.estevao.projetoTesteMongoDB.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDTO findById(String id){
        Optional<Post> optional = postRepository.findById(id);
        Post p = optional.orElseThrow(
                ()-> new NotFoundException("Not found Post Id!")
        );
        return new PostDTO(p);
    }

    public List<PostDTO> findPostByTitle(String title){
        return postRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(PostDTO::new)
                .toList();
    }

    public List<PostDTO> fullSearch(String text,String start , String end){
        Instant startDate = converteMoment(start,Instant.ofEpochMilli(0L));
        Instant endDate = converteMoment(end,Instant.now());
        return postRepository.fullSearch(text,startDate,endDate)
                .stream()
                .map(PostDTO::new)
                .toList();
    }

    private Instant converteMoment(String moment,Instant option){
        try{
            return Instant.parse(moment);
        }catch (DateTimeParseException e) {
            return option;
        }
    }
}

package com.estevao.projetoTesteMongoDB.controllers;

import com.estevao.projetoTesteMongoDB.models.dto.PostDTO;
import com.estevao.projetoTesteMongoDB.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        return ResponseEntity.ok(postService.findById(id));
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<PostDTO>> findPostsByTitle(@RequestParam(value = "text",defaultValue = "")String title){
        return ResponseEntity.ok(postService.findPostByTitle(title));
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<PostDTO>> full(
            @RequestParam(value = "text",defaultValue = "") String text,
            @RequestParam(value = "start",defaultValue = "") String start,
            @RequestParam(value = "end",defaultValue = "") String end
    ){
        return ResponseEntity.ok(postService.fullSearch(
                text, start, end));
    }
}

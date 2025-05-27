package com.estevao.projetoTesteMongoDB.controllers;

import com.estevao.projetoTesteMongoDB.models.dto.UserDTO;
import com.estevao.projetoTesteMongoDB.service.UserServide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserServide userServide;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> list = userServide.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable String id){
        UserDTO dto = userServide.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}

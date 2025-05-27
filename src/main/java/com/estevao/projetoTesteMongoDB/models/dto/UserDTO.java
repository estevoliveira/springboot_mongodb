package com.estevao.projetoTesteMongoDB.models.dto;

import com.estevao.projetoTesteMongoDB.models.entities.Post;
import com.estevao.projetoTesteMongoDB.models.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private String id;
    private String name,email;

    //private List<String> posts = new ArrayList<>();


    public UserDTO() {

    }

    public UserDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

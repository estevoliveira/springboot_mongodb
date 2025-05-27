package com.estevao.projetoTesteMongoDB.service;

import com.estevao.projetoTesteMongoDB.models.dto.UserDTO;
import com.estevao.projetoTesteMongoDB.models.entities.User;
import com.estevao.projetoTesteMongoDB.repository.UserRepository;
import com.estevao.projetoTesteMongoDB.service.exception.NotFoundUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServide {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll(){
        List<User> userList = userRepository.findAll();
        return userList
                .stream()
                .map(UserDTO::new)
                .toList();
    }

    public UserDTO findById(String id){
        Optional<User> optionalUser = userRepository.findById(id);
        User u = optionalUser.orElseThrow(
                ()-> new NotFoundUserException("Not found User!")
        );
        return new UserDTO(u);

    }

}

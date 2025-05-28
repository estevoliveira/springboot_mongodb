package com.estevao.projetoTesteMongoDB.service;

import com.estevao.projetoTesteMongoDB.models.dto.PostDTO;
import com.estevao.projetoTesteMongoDB.models.dto.UserDTO;
import com.estevao.projetoTesteMongoDB.models.entities.User;
import com.estevao.projetoTesteMongoDB.repository.UserRepository;
import com.estevao.projetoTesteMongoDB.service.exception.NotFoundException;
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
        User u = checkUserExist(id);
        return new UserDTO(u);

    }

    public UserDTO insertUser(UserDTO dto){
        User u = new User();
        u.setEmail(dto.getEmail());
        u.setName(dto.getName());
        u = userRepository.insert(u);
        return new UserDTO(u);
    }

    public UserDTO update(String id, UserDTO dto){
        User u = checkUserExist(id);
        u.setName(dto.getName());
        u.setEmail(dto.getEmail());
        u= userRepository.save(u);
        return new UserDTO(u);
    }

    public void remove(String id){
        User u = checkUserExist(id);
        userRepository.delete(u);
    }
    public List<PostDTO> getPostsByUser(String id){
        User u = checkUserExist(id);
        return u.getPosts()
                .stream()
                .map(PostDTO::new)
                .toList();
    }

    private User checkUserExist(String id){
        Optional<User> optionalUser = userRepository.findById(id);
        User u = optionalUser.orElseThrow(
                ()-> new NotFoundException("Not found User!")
        );
        return u;
    }
}

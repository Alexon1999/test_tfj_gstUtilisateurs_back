package com.tfj.gestionutilisateurs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// partie logique métier (Business Logic)
// Service Layer

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        /*return List.of(
                new User(1L, "Uthayakumar", "Alexon", "alexon@gmail.com", "admin123",22 )
        );*/
        return userRepository.findAll();
    }


    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("Email existe déjà");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(User user) {
        boolean exists = userRepository.existsById(user.getId());
        if(!exists){
            throw new IllegalStateException("Utilisateur avec l'Id " + user.getId() +" n'existe pas.");
        }
        // User userFounded = userRepository.findById(user.getId()).orElseThrow(() -> new IllegalStateException("Utilisateur avec l'Id " + user.getId() +" n'existe pas."));
        // TODO: Validation pour les champs

        userRepository.save(user);
    }
}

// https://medium.com/analytics-vidhya/spring-boot-accessing-data-with-jpa-hibernate-and-postgresql-af68386363a4
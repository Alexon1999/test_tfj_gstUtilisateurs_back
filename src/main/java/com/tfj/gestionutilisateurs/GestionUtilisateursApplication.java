package com.tfj.gestionutilisateurs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tfj.gestionutilisateurs.user.User;

import java.util.List;

@SpringBootApplication
@RestController
public class GestionUtilisateursApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionUtilisateursApplication.class, args);
    }

    // definir les endpoints

    // http://localhost:8080
    @GetMapping
    public String hello(){
        System.out.println(GestionUtilisateursApplication.class);
        return "Hello World";
    }

    // http://localhost:8080/users
    /*@GetMapping("/users")
    public List<User> getUsers(){
        return List.of(
              new User(1L, "Uthayakumar", "Alexon", "alexon@gmail.com", "admin123",22 )
        );
    }*/
}
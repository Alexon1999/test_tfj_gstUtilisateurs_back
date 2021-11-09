package com.tfj.gestionutilisateurs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping(path="api/user")
public class UserController {

    private final UserService userService;

    // Dependency Injection : pour connecter avec d'autre classes, interfaces. en mode Independant
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // http://localhost:8080/api/user
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        // System.out.println(user);
        userService.addNewUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }
}

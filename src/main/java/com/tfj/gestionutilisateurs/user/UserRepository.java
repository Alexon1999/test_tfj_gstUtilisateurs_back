package com.tfj.gestionutilisateurs.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Repository = c'est une interface qui est responsable de l'accès aux données (communiquer avec la bdd)
// Data Access Layer

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // jpql: Java Persistence Query Language

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserByEmail(String email);

    boolean existsUserByEmail(String email);
}

package com.codegym.repository;

import com.codegym.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
//    @Query(value = "select * from user where username = :username", nativeQuery = true)
//    Optional<User> findByUsername(@Param("username") String username);
    Optional<User> findByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findById(Integer id);
    Boolean existsByUsername(String username);
}

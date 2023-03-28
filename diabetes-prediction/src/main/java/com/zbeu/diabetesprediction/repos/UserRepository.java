package com.zbeu.diabetesprediction.repos;

import com.zbeu.diabetesprediction.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author HAKAN YIGIT
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    boolean existsUserByUsername(String username);

    boolean existsUserByEmail(String email);

}

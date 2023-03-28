package com.zbeu.diabetesprediction.repos;

import com.zbeu.diabetesprediction.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author HAKAN YIGIT
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String role);

}

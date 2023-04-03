package com.zbeu.diabetesprediction.repos;

import com.zbeu.diabetesprediction.model.entity.BloodSugar;
import com.zbeu.diabetesprediction.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

@Repository
public interface BloodSugarRepository extends JpaRepository<BloodSugar, Long> {

    List<BloodSugar> findAllByUser(User user);

}

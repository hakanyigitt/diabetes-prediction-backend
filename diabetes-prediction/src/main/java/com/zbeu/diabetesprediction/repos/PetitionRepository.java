package com.zbeu.diabetesprediction.repos;

import com.zbeu.diabetesprediction.model.entity.Petition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

@Repository
public interface PetitionRepository extends JpaRepository<Petition, Long> {

    List<Petition> findAllByStatus(boolean status);

}

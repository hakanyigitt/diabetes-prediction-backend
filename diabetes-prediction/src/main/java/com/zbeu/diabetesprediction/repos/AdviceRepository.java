package com.zbeu.diabetesprediction.repos;

import com.zbeu.diabetesprediction.entities.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HAKAN YIGIT
 */

@Repository
public interface AdviceRepository extends JpaRepository<Advice, Long> {

}

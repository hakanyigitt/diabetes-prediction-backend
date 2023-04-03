package com.zbeu.diabetesprediction.repos;

import com.zbeu.diabetesprediction.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HAKAN YIGIT
 */

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}

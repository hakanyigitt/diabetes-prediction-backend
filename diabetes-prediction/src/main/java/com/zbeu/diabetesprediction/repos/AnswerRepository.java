package com.zbeu.diabetesprediction.repos;

import com.zbeu.diabetesprediction.model.entity.Answer;
import com.zbeu.diabetesprediction.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Transactional
    List<Answer> findAnswersByUser(User user);

}

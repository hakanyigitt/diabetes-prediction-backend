package com.zbeu.diabetesprediction.services;

import com.zbeu.diabetesprediction.dto.request.QuestionRequest;
import com.zbeu.diabetesprediction.dto.response.QuestionResponse;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

public interface QuestionService {

    List<QuestionResponse> getAll();

    QuestionResponse getQuestionById(Long id);

    void create(QuestionRequest questionRequest);

    void delete(Long id);

    void update(Long id, QuestionRequest questionRequest);

}

package com.zbeu.diabetesprediction.services;

import com.zbeu.diabetesprediction.dto.request.AnswerRequest;
import com.zbeu.diabetesprediction.dto.response.AnswerResponse;
import com.zbeu.diabetesprediction.model.entity.Answer;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

public interface AnswerService {

    List<AnswerResponse> getAll();

    AnswerResponse getById(Long id);

    List<AnswerResponse> getAllByUserId(Long userId);

    void create(AnswerRequest answerRequest);

    void delete(Long id);

    void update(Long id, AnswerRequest answerRequest);

}
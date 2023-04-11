package com.zbeu.diabetesprediction.mapper;

import com.zbeu.diabetesprediction.dto.response.QuestionResponse;
import com.zbeu.diabetesprediction.model.entity.Question;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

/**
 * @author HAKAN YIGIT
 */

@RequiredArgsConstructor
@Component
public class QuestionMapper {

    public QuestionResponse questionToQuestionResponse(Question question){
        final var questionResponse = new QuestionResponse();
        questionResponse.setId(question.getId());
        questionResponse.setQuestion(question.getQuestion());
        questionResponse.setDescription(question.getDescription());
        return questionResponse;
    }

}

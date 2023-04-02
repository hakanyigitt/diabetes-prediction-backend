package com.zbeu.diabetesprediction.mapper;

import com.zbeu.diabetesprediction.dto.response.QuestionResponse;
import com.zbeu.diabetesprediction.entities.Question;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

/**
 * @author HAKAN YIGIT
 */

@RequiredArgsConstructor
@Component
public class QuestionMapper {

    public QuestionResponse QuestionToQuestionResponse(Question question){
        final var questionResponse = new QuestionResponse();
        questionResponse.setQuestion(question.getQuestion());
        questionResponse.setDescription(question.getDescription());
        return questionResponse;
    }

}

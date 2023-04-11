package com.zbeu.diabetesprediction.mapper;

import com.zbeu.diabetesprediction.dto.response.AnswerResponse;
import com.zbeu.diabetesprediction.model.entity.Answer;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

/**
 * @author HAKAN YIGIT
 */

@RequiredArgsConstructor
@Component
public class AnswerMapper {

    public AnswerResponse answerToAnswerResponse(Answer answer){
        final var answerResponse = new AnswerResponse();
        answerResponse.setId(answer.getId());
        answerResponse.setFullName(answer.getUser().getFirstName() + " " + answer.getUser().getLastName());
        answerResponse.setQuestion(answer.getQuestion().getQuestion());
        answerResponse.setReply(answer.getReply().name());
        return answerResponse;
    }

}

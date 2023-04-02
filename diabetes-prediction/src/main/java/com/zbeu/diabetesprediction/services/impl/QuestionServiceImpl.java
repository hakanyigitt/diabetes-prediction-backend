package com.zbeu.diabetesprediction.services.impl;

import com.zbeu.diabetesprediction.common.constant.ExceptionMessages;
import com.zbeu.diabetesprediction.dto.request.QuestionRequest;
import com.zbeu.diabetesprediction.dto.response.QuestionResponse;
import com.zbeu.diabetesprediction.entities.Question;
import com.zbeu.diabetesprediction.exception.CustomException;
import com.zbeu.diabetesprediction.mapper.QuestionMapper;
import com.zbeu.diabetesprediction.repos.QuestionRepository;
import com.zbeu.diabetesprediction.services.QuestionService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author HAKAN YIGIT
 */

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Override
    public List<QuestionResponse> getAll() {
        return questionRepository.findAll()
                .stream()
                .map(question -> new QuestionResponse(question.getQuestion(), question.getDescription()))
                .toList();
    }

    @Override
    public QuestionResponse getQuestionById(Long id) {
        final var  question = findQuestionById(id);
        final QuestionResponse questionResponse = questionMapper.QuestionToQuestionResponse(question);
        return questionResponse;
    }

    @Override
    public void create(QuestionRequest questionRequest) {
        final String question = questionRequest.getQuestion();
        final String description = questionRequest.getDescription();

        Question questionObject = new Question();
        questionObject.setQuestion(question);
        questionObject.setDescription(description);
        questionRepository.save(questionObject);
    }

    @Override
    public void delete(Long id) {
        Question question = findQuestionById(id);
        questionRepository.delete(question);
    }

    @Override
    public void update(Long id, QuestionRequest questionRequest) {
        Question question = findQuestionById(id);
        question.setQuestion(questionRequest.getQuestion());
        question.setDescription(questionRequest.getDescription());
        questionRepository.save(question);
    }

    private Question findQuestionById(Long id){
        final Question question = questionRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionMessages.QUESTION_NOT_FOUND, HttpStatus.NOT_FOUND));
        return question;
    }


}

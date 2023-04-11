package com.zbeu.diabetesprediction.services.impl;

import com.zbeu.diabetesprediction.common.constant.ExceptionMessages;
import com.zbeu.diabetesprediction.dto.request.AnswerRequest;
import com.zbeu.diabetesprediction.dto.response.AnswerResponse;
import com.zbeu.diabetesprediction.exception.CustomException;
import com.zbeu.diabetesprediction.mapper.AnswerMapper;
import com.zbeu.diabetesprediction.model.entity.Answer;
import com.zbeu.diabetesprediction.model.entity.Question;
import com.zbeu.diabetesprediction.model.entity.User;
import com.zbeu.diabetesprediction.model.enums.Reply;
import com.zbeu.diabetesprediction.repos.AnswerRepository;
import com.zbeu.diabetesprediction.repos.QuestionRepository;
import com.zbeu.diabetesprediction.repos.UserRepository;
import com.zbeu.diabetesprediction.services.AnswerService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerMapper answerMapper;

    @Override
    public List<AnswerResponse> getAll() {
        return answerRepository.findAll()
                .stream()
                .map(answer -> new AnswerResponse(answer.getId(), answer.getUser().getFirstName() + " " + answer.getUser().getLastName(), answer.getQuestion().getQuestion(), answer.getReply().name()))
                .toList();
    }

    @Override
    public AnswerResponse getById(Long id) {
        final var answer = findAnswerById(id);
        final AnswerResponse answerResponse = answerMapper.answerToAnswerResponse(answer);
        return answerResponse;
    }

    @Override
    public List<AnswerResponse> getAllByUserId(Long userId) {
        final User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ExceptionMessages.USER_NOT_FOUND, HttpStatus.NOT_FOUND));
        return answerRepository.findAnswersByUser(user)
                .stream()
                .map(answer -> new AnswerResponse(answer.getId(), answer.getUser().getFirstName() + " " + answer.getUser().getLastName(), answer.getQuestion().getQuestion(), answer.getReply().name()))
                .toList();
    }

    @Override
    public void create(AnswerRequest answerRequest) {
        final Reply reply = answerRequest.getReply();
        final User user = userRepository.findById(answerRequest.getUserId())
                .orElseThrow(() ->new CustomException(ExceptionMessages.USER_NOT_FOUND, HttpStatus.NOT_FOUND));
        final Question question = questionRepository.findById(answerRequest.getQuestionId())
                .orElseThrow(() ->new CustomException(ExceptionMessages.QUESTION_NOT_FOUND, HttpStatus.NOT_FOUND));

        Answer answer = new Answer();
        answer.setReply(reply);
        answer.setUser(user);
        answer.setQuestion(question);
        answerRepository.save(answer);
    }

    @Override
    public void delete(Long id) {
        Answer answer = findAnswerById(id);
        answerRepository.delete(answer);
    }

    @Override
    public void update(Long id, AnswerRequest answerRequest) {
        final var user = userRepository.findById(answerRequest.getUserId())
                .orElseThrow(()-> new CustomException(ExceptionMessages.USER_NOT_FOUND, HttpStatus.NOT_FOUND));

        final var question = questionRepository.findById(answerRequest.getQuestionId())
                .orElseThrow(()-> new CustomException(ExceptionMessages.QUESTION_NOT_FOUND, HttpStatus.NOT_FOUND));

        Answer answer = findAnswerById(id);
        answer.setReply(answerRequest.getReply());
        answer.setUser(user);
        answer.setQuestion(question);
        answerRepository.save(answer);
    }

    private Answer findAnswerById(Long id){
        final Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionMessages.ANSWER_NOT_FOUND, HttpStatus.NOT_FOUND));
        return answer;
    }

}

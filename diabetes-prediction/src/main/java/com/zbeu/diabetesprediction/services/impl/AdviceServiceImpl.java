package com.zbeu.diabetesprediction.services.impl;

import com.zbeu.diabetesprediction.common.constant.ExceptionMessages;
import com.zbeu.diabetesprediction.dto.request.AdviceCreateRequest;
import com.zbeu.diabetesprediction.dto.request.AdviceUpdateRequest;
import com.zbeu.diabetesprediction.dto.response.AdviceResponse;
import com.zbeu.diabetesprediction.model.entity.Advice;
import com.zbeu.diabetesprediction.exception.CustomException;
import com.zbeu.diabetesprediction.mapper.AdviceMapper;
import com.zbeu.diabetesprediction.repos.AdviceRepository;
import com.zbeu.diabetesprediction.services.AdviceService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

@Service
@RequiredArgsConstructor
public class AdviceServiceImpl implements AdviceService {

    private final AdviceRepository adviceRepository;
    private final AdviceMapper adviceMapper;

    @Override
    public List<AdviceResponse> getAll() {
        return adviceRepository.findAll()
                .stream()
                .map(advice -> new AdviceResponse(advice.getId(), advice.getTitle(), advice.getDescription()))
                .toList();
    }

    @Override
    public AdviceResponse getById(Long id) {
        final var advice = findAdviceById(id);
        final AdviceResponse adviceResponse = adviceMapper.adviceToAdviceResponse(advice);
        return adviceResponse;
    }

    @Override
    public void create(AdviceCreateRequest adviceCreateRequest) {
        final String title = adviceCreateRequest.getTitle();
        final String description = adviceCreateRequest.getDescription();

        Advice advice = new Advice();
        advice.setTitle(title);
        advice.setDescription(description);
        adviceRepository.save(advice);
    }

    @Override
    public void delete(Long id) {
        Advice advice = findAdviceById(id);
        adviceRepository.deleteById(advice.getId());
    }

    @Override
    public void update(Long id, AdviceUpdateRequest adviceUpdateRequest) {
        Advice advice = findAdviceById(id);
        advice.setTitle(adviceUpdateRequest.getTitle());
        advice.setDescription(adviceUpdateRequest.getDescription());
        adviceRepository.save(advice);
    }

    private Advice findAdviceById(long id){
        final Advice advice = adviceRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionMessages.ADVICE_NOT_FOUND, HttpStatus.NOT_FOUND));
        return advice;
    }
}

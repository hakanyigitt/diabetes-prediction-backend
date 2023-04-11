package com.zbeu.diabetesprediction.mapper;

import com.zbeu.diabetesprediction.dto.response.AdviceResponse;
import com.zbeu.diabetesprediction.model.entity.Advice;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

/**
 * @author HAKAN YIGIT
 */

@RequiredArgsConstructor
@Component
public class AdviceMapper {

    public AdviceResponse adviceToAdviceResponse(Advice advice){
        final var adviceResponse = new AdviceResponse();
        adviceResponse.setId(advice.getId());
        adviceResponse.setTitle(advice.getTitle());
        adviceResponse.setDescription(advice.getDescription());
        return adviceResponse;
    }

}

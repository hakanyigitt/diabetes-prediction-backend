package com.zbeu.diabetesprediction.mapper;

import com.zbeu.diabetesprediction.dto.response.AdviceResponse;
import com.zbeu.diabetesprediction.entities.Advice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdviceMapper {

    public AdviceResponse AdviceToAdviceResponse(Advice advice){
        final var adviceResponse = new AdviceResponse();
        adviceResponse.setTitle(advice.getTitle());
        adviceResponse.setDescription(advice.getDescription());
        return adviceResponse;
    }

}

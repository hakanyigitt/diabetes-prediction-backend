package com.zbeu.diabetesprediction.mapper;

import com.zbeu.diabetesprediction.dto.response.BloodSugarResponse;
import com.zbeu.diabetesprediction.model.entity.BloodSugar;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author HAKAN YIGIT
 */

@RequiredArgsConstructor
@Component
public class BloodSugarMapper {

    public BloodSugarResponse bloodSugarToBloodSugarResponse(BloodSugar bloodSugar){
        final var bloodSugarResponse = new BloodSugarResponse();
        bloodSugarResponse.setId(bloodSugar.getId());
        bloodSugarResponse.setValue(bloodSugar.getValue());
        bloodSugarResponse.setDate(bloodSugar.getDate());
        bloodSugarResponse.setTimeType(bloodSugar.getTimeType());
        return bloodSugarResponse;
    }

}

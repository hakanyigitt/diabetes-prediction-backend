package com.zbeu.diabetesprediction.services.impl;

import com.zbeu.diabetesprediction.common.constant.ExceptionMessages;
import com.zbeu.diabetesprediction.dto.request.BloodSugarCreateRequest;
import com.zbeu.diabetesprediction.dto.request.BloodSugarUpdateRequest;
import com.zbeu.diabetesprediction.dto.response.BloodSugarResponse;
import com.zbeu.diabetesprediction.exception.CustomException;
import com.zbeu.diabetesprediction.mapper.BloodSugarMapper;
import com.zbeu.diabetesprediction.model.entity.BloodSugar;
import com.zbeu.diabetesprediction.model.entity.User;
import com.zbeu.diabetesprediction.model.enums.TimeType;
import com.zbeu.diabetesprediction.repos.BloodSugarRepository;
import com.zbeu.diabetesprediction.repos.UserRepository;
import com.zbeu.diabetesprediction.services.BloodSugarService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author HAKAN YIGIT
 */

@Service
@RequiredArgsConstructor
public class BloodSugarServiceImpl implements BloodSugarService {

    private final BloodSugarRepository bloodSugarRepository;
    private final UserRepository userRepository;
    private final BloodSugarMapper bloodSugarMapper;


    @Override
    public List<BloodSugarResponse> getAllByUsername(String username) {
        final User user = findUserByUsername(username);
        return bloodSugarRepository.findAllByUser(user)
                .stream()
                .map(bloodSugar -> new BloodSugarResponse(bloodSugar.getValue(), bloodSugar.getDate(), bloodSugar.getTimeType()))
                .toList();
    }

    @Override
    public BloodSugarResponse getById(Long id) {
        final var bloodSugar = findBloodSugarById(id);
        final BloodSugarResponse bloodSugarResponse = bloodSugarMapper.BloodSugarToBloodSugarResponse(bloodSugar);
        return bloodSugarResponse;
    }

    @Override
    public void create(BloodSugarCreateRequest bloodSugarCreateRequest) {
        final float value = bloodSugarCreateRequest.getValue();
        final LocalDate date = bloodSugarCreateRequest.getDate() == null ? LocalDate.now() : bloodSugarCreateRequest.getDate();
        final TimeType timeType = bloodSugarCreateRequest.getTimeType();
        final User user = findUserByUsername(bloodSugarCreateRequest.getUsername());

        BloodSugar bloodSugar = new BloodSugar();
        bloodSugar.setValue(value);
        bloodSugar.setDate(date);
        bloodSugar.setTimeType(timeType);
        bloodSugar.setUser(user);
        bloodSugarRepository.save(bloodSugar);
    }

    @Override
    public void delete(Long id) {
        BloodSugar bloodSugar = findBloodSugarById(id);
        bloodSugarRepository.delete(bloodSugar);
    }

    @Override
    public void update(Long id, BloodSugarUpdateRequest bloodSugarUpdateRequest) {
        BloodSugar bloodSugar = findBloodSugarById(id);
        bloodSugar.setValue(bloodSugarUpdateRequest.getValue());
        bloodSugar.setTimeType(bloodSugarUpdateRequest.getTimeType());
        bloodSugarRepository.save(bloodSugar);
    }

    private BloodSugar findBloodSugarById(Long id){
        final BloodSugar bloodSugar = bloodSugarRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionMessages.BLOOD_SUGAR_NOT_FOUND, HttpStatus.NOT_FOUND));
        return bloodSugar;
    }

    private User findUserByUsername(String username){
        final User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(ExceptionMessages.USER_NOT_FOUND, HttpStatus.NOT_FOUND));
        return user;
    }

}

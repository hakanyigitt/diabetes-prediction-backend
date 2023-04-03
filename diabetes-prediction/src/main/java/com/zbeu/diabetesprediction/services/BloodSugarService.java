package com.zbeu.diabetesprediction.services;

import com.zbeu.diabetesprediction.dto.request.BloodSugarCreateRequest;
import com.zbeu.diabetesprediction.dto.request.BloodSugarUpdateRequest;
import com.zbeu.diabetesprediction.dto.response.BloodSugarResponse;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

public interface BloodSugarService {

    List<BloodSugarResponse> getAllByUsername(String username);

    BloodSugarResponse getById(Long id);

    void create(BloodSugarCreateRequest bloodSugarCreateRequest);

    void delete(Long id);

    void update(Long id, BloodSugarUpdateRequest bloodSugarUpdateRequest);

}

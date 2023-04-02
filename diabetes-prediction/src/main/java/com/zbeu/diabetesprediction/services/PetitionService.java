package com.zbeu.diabetesprediction.services;

import com.zbeu.diabetesprediction.dto.request.PetitionRequest;
import com.zbeu.diabetesprediction.dto.response.PetitionResponse;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

public interface PetitionService {

    List<PetitionResponse> getAll();

    List<PetitionResponse> getAllByStatus(boolean status);

    void create(PetitionRequest petitionRequest);

    void delete(Long id);

}

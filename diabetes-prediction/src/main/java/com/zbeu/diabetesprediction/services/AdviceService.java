package com.zbeu.diabetesprediction.services;

import com.zbeu.diabetesprediction.dto.request.AdviceCreateRequest;
import com.zbeu.diabetesprediction.dto.request.AdviceUpdateRequest;
import com.zbeu.diabetesprediction.dto.response.AdviceResponse;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

public interface AdviceService {

    List<AdviceResponse> getAll();

    AdviceResponse getById(Long id);

    void create(AdviceCreateRequest adviceCreateRequest);

    void delete(Long id);

    void update(Long id, AdviceUpdateRequest adviceUpdateRequest);

}

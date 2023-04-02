package com.zbeu.diabetesprediction.services.impl;

import com.zbeu.diabetesprediction.common.constant.ExceptionMessages;
import com.zbeu.diabetesprediction.dto.request.PetitionRequest;
import com.zbeu.diabetesprediction.dto.response.PetitionResponse;
import com.zbeu.diabetesprediction.entities.Petition;
import com.zbeu.diabetesprediction.exception.CustomException;
import com.zbeu.diabetesprediction.repos.PetitionRepository;
import com.zbeu.diabetesprediction.services.PetitionService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

@Service
@RequiredArgsConstructor
public class PetitionServiceImpl implements PetitionService {

    private final PetitionRepository petitionRepository;

    @Override
    public List<PetitionResponse> getAll() {
        return petitionRepository.findAll()
                .stream()
                .map(petition -> new PetitionResponse(petition.getDescription(), petition.getEmail()))
                .toList();
    }

    @Transactional
    @Override
    public List<PetitionResponse> getAllByStatus(boolean status) {
        return petitionRepository.findAllByStatus(status)
                .stream()
                .map(petition -> new PetitionResponse(petition.getDescription(), petition.getEmail()))
                .toList();
    }

    @Override
    public void create(PetitionRequest petitionRequest) {
        final String description = petitionRequest.getDescription();
        final String email = petitionRequest.getEmail();

        Petition petition = new Petition();
        petition.setDescription(description);
        petition.setEmail(email);
        petition.setStatus(true);
        petitionRepository.save(petition);
    }

    @Override
    public void delete(Long id) {
        Petition petition = findPetitionById(id);
        petitionRepository.delete(petition);
    }

    private Petition findPetitionById(Long id){
        final Petition petition = petitionRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionMessages.PETITION_NOT_FOUND, HttpStatus.NOT_FOUND));
        return petition;
    }
}

package com.zbeu.diabetesprediction.controllers;

import com.zbeu.diabetesprediction.common.GenericResponse;
import com.zbeu.diabetesprediction.common.annotation.ApiController;
import com.zbeu.diabetesprediction.common.constant.GenericMessages;
import com.zbeu.diabetesprediction.common.constant.SwaggerMessages;
import com.zbeu.diabetesprediction.dto.request.PetitionRequest;
import com.zbeu.diabetesprediction.dto.response.PetitionResponse;
import com.zbeu.diabetesprediction.services.PetitionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

@ApiController
@RequiredArgsConstructor
@RequestMapping(value = "petitions")
public class PetitionController {

    private final PetitionService petitionService;

    @ApiOperation(value = "Get all")
    @GetMapping("getAll")
    public ResponseEntity<List<PetitionResponse>> getAll(){
        return ResponseEntity.ok(petitionService.getAll());
    }

    @ApiOperation(value = "Get all by status")
    @GetMapping("getAllByStatus")
    public ResponseEntity<List<PetitionResponse>> getAllByStatus(@RequestParam boolean status){
        return ResponseEntity.ok(petitionService.getAllByStatus(status));
    }

    @ApiOperation(value = "Create")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFUL_CREATE_PETITION)
    })
    @PostMapping("create")
    public ResponseEntity<?> create(@ApiParam(value = "Petition Request")
                                    @RequestBody PetitionRequest petitionRequest){
        petitionService.create(petitionRequest);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_CREATED));
    }

    @ApiOperation("Delete")
    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        petitionService.delete(id);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_DELETED));
    }

}

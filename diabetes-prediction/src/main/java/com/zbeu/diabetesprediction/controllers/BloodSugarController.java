package com.zbeu.diabetesprediction.controllers;

import com.zbeu.diabetesprediction.common.GenericResponse;
import com.zbeu.diabetesprediction.common.annotation.ApiController;
import com.zbeu.diabetesprediction.common.constant.GenericMessages;
import com.zbeu.diabetesprediction.common.constant.SwaggerMessages;
import com.zbeu.diabetesprediction.dto.request.BloodSugarCreateRequest;
import com.zbeu.diabetesprediction.dto.request.BloodSugarUpdateRequest;
import com.zbeu.diabetesprediction.dto.response.BloodSugarResponse;
import com.zbeu.diabetesprediction.services.BloodSugarService;

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
@RequestMapping("bloodSugars")
public class BloodSugarController {

    private final BloodSugarService bloodSugarService;

    @ApiOperation(value = "Get all by username")
    @GetMapping("getAllByUsername")
    public ResponseEntity<List<BloodSugarResponse>> getAllByUsername(@RequestParam(value = "username") String username){
        return ResponseEntity.ok(bloodSugarService.getAllByUsername(username));
    }

    @ApiOperation(value = "Get by id")
    @GetMapping("getById")
    public ResponseEntity<BloodSugarResponse> getById(@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(bloodSugarService.getById(id));
    }

    @ApiOperation(value = "Create")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFUL_CREATE_BLOOD_SUGAR)
    })
    @PostMapping("create")
    public ResponseEntity<?> create(@ApiParam(value = "Blood Sugar Create Request", required = true)
                                    @RequestBody BloodSugarCreateRequest bloodSugarCreateRequest){
        bloodSugarService.create(bloodSugarCreateRequest);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_CREATED));
    }

    @ApiOperation(value = "Delete")
    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        bloodSugarService.delete(id);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_DELETED));
    }

    @ApiOperation(value = "Update")
    @PutMapping("update")
    public ResponseEntity<?> update(@RequestParam(value = "id") Long id, @ApiParam(value = "Blood Sugar Create") @RequestBody BloodSugarUpdateRequest bloodSugarUpdateRequest){
        bloodSugarService.update(id, bloodSugarUpdateRequest);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_UPDATED));
    }

}

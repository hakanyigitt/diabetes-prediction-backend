package com.zbeu.diabetesprediction.controllers;

import com.zbeu.diabetesprediction.common.GenericResponse;
import com.zbeu.diabetesprediction.common.annotation.ApiController;
import com.zbeu.diabetesprediction.common.constant.GenericMessages;
import com.zbeu.diabetesprediction.common.constant.SwaggerMessages;
import com.zbeu.diabetesprediction.dto.request.AdviceCreateRequest;
import com.zbeu.diabetesprediction.dto.request.AdviceUpdateRequest;
import com.zbeu.diabetesprediction.dto.response.AdviceResponse;
import com.zbeu.diabetesprediction.services.AdviceService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HAKAN YIGIT
 */

@ApiController
@RequiredArgsConstructor
@RequestMapping(value = "advices")
public class AdviceController {

    private final AdviceService adviceService;

    @ApiOperation(value = "Get all")
    @GetMapping("getAll")
    public ResponseEntity<List<AdviceResponse>> getAll(){
        return ResponseEntity.ok(adviceService.getAll());
    }

    @ApiOperation(value = "Get by id")
    @GetMapping("getById")
    public ResponseEntity<AdviceResponse> getById(@RequestParam Long id){
        return ResponseEntity.ok(adviceService.getById(id));
    }

    @ApiOperation(value = "Create")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFUL_CREATE_ADVICE)
    })
    @PostMapping("create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@ApiParam(value = "Advice Create Request", required = true)
                                    @RequestBody AdviceCreateRequest adviceCreateRequest){
        adviceService.create(adviceCreateRequest);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_CREATED));
    }

    @ApiOperation(value = "Delete")
    @DeleteMapping("delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        adviceService.delete(id);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_DELETED));
    }

    @ApiOperation(value = "Update")
    @PutMapping("update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestParam Long id, @ApiParam(value = "Advice Update Request") @RequestBody AdviceUpdateRequest adviceUpdateRequest){
        adviceService.update(id, adviceUpdateRequest);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_UPDATED));
    }

}

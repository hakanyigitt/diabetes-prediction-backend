package com.zbeu.diabetesprediction.controllers;

import com.zbeu.diabetesprediction.common.GenericResponse;
import com.zbeu.diabetesprediction.common.annotation.ApiController;
import com.zbeu.diabetesprediction.common.constant.GenericMessages;
import com.zbeu.diabetesprediction.common.constant.SwaggerMessages;
import com.zbeu.diabetesprediction.dto.request.AnswerRequest;
import com.zbeu.diabetesprediction.dto.response.AnswerResponse;
import com.zbeu.diabetesprediction.services.AnswerService;

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
@RequestMapping(value = "answers")
public class AnswerController {

    private final AnswerService answerService;

    @ApiOperation(value = "Get all")
    @GetMapping("getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AnswerResponse>> getAll(){
        return ResponseEntity.ok(answerService.getAll());
    }

    @ApiOperation(value = "Get by id")
    @GetMapping("getById")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AnswerResponse> getById(@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(answerService.getById(id));
    }

    @ApiOperation(value = "Get all by user id")
    @GetMapping("getAllByUserId")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<AnswerResponse>> getAllByUserId(@RequestParam(value = "userId") Long userId){
        return ResponseEntity.ok(answerService.getAllByUserId(userId));
    }

    @ApiOperation("Create")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFUL_CREATE_ANSWER)
    })
    @PostMapping("create")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> create(@ApiParam(value = "Answer", required = true)
                                    @RequestBody AnswerRequest answerRequest){
        answerService.create(answerRequest);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_CREATED));
    }

    @ApiOperation(value = "Delete")
    @DeleteMapping("delete")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        answerService.delete(id);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_DELETED));
    }

    @ApiOperation(value = "Update")
    @PutMapping("update")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestParam Long id, @ApiParam(value = "Answer")
                                    @RequestBody AnswerRequest answerRequest){
        answerService.update(id, answerRequest);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_UPDATED));
    }

}

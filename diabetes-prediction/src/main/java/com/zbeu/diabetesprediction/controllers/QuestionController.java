package com.zbeu.diabetesprediction.controllers;

import com.zbeu.diabetesprediction.common.GenericResponse;
import com.zbeu.diabetesprediction.common.annotation.ApiController;
import com.zbeu.diabetesprediction.common.constant.GenericMessages;
import com.zbeu.diabetesprediction.common.constant.SwaggerMessages;
import com.zbeu.diabetesprediction.dto.request.QuestionRequest;
import com.zbeu.diabetesprediction.dto.response.QuestionResponse;
import com.zbeu.diabetesprediction.services.QuestionService;

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
@RequestMapping("questions")
public class QuestionController {

    private final QuestionService questionService;

    @ApiOperation(value = "Get all")
    @GetMapping("getAll")
    public ResponseEntity<List<QuestionResponse>> getAll(){
        return ResponseEntity.ok(questionService.getAll());
    }

    @ApiOperation(value = "Get question by id")
    @GetMapping("getQuestionById")
    public ResponseEntity<QuestionResponse> getQuestionById(@RequestParam Long id){
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    @ApiOperation(value = "Create")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFUL_CREATE_QUESTON)
    })
    @PostMapping("create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@ApiParam(value = "Question Request", required = true)
                                    @RequestBody QuestionRequest questionRequest){
        questionService.create(questionRequest);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_CREATED));
    }

    @ApiOperation("Delete")
    @DeleteMapping("delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        questionService.delete(id);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_DELETED));
    }

    @ApiOperation("Update")
    @PutMapping("update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestParam Long id, @ApiParam(value = "Question Request") @RequestBody QuestionRequest questionRequest){
        questionService.update(id, questionRequest);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_UPDATED));
    }

}

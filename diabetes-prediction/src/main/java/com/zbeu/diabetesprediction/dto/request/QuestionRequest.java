package com.zbeu.diabetesprediction.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HAKAN YIGIT
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Question Request")
public final class QuestionRequest {

    @ApiModelProperty(value = "Question")
    private String question;

    @ApiModelProperty(value = "Description")
    private String description;

}

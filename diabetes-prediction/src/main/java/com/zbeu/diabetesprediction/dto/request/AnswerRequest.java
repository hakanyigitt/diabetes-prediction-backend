package com.zbeu.diabetesprediction.dto.request;

import com.zbeu.diabetesprediction.model.enums.Reply;

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
@ApiModel(value = "Advice Request")
public final class AnswerRequest {

    @ApiModelProperty(value = "Reply")
    private Reply reply;

    @ApiModelProperty(value = "UserId")
    private Long userId;

    @ApiModelProperty(value = "QuestionId")
    private Long questionId;

}

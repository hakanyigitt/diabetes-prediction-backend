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
@ApiModel(value = "Advice Update Request")
public final class AdviceUpdateRequest {

    @ApiModelProperty(value = "Title")
    private String title;

    @ApiModelProperty(value = "Description")
    private String description;

}

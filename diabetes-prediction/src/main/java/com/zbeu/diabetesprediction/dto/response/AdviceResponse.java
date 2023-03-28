package com.zbeu.diabetesprediction.dto.response;

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
@ApiModel(value = "Advice Response")
public final class AdviceResponse {

    @ApiModelProperty(value = "Title")
    private String title;

    @ApiModelProperty(value = "Description")
    private String description;

}

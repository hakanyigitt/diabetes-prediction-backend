package com.zbeu.diabetesprediction.dto.request;

import com.zbeu.diabetesprediction.model.enums.TimeType;

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
@ApiModel(value = "Blood Sugar Update Request")
public final class BloodSugarUpdateRequest {

    @ApiModelProperty(value = "Value")
    private float value;

    @ApiModelProperty(value = "Time type")
    private TimeType timeType;

}

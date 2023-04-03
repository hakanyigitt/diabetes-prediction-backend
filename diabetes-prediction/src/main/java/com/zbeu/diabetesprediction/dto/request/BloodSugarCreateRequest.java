package com.zbeu.diabetesprediction.dto.request;

import com.zbeu.diabetesprediction.model.enums.TimeType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author HAKAN YIGIT
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Blood Sugar Create Request")
public final class BloodSugarCreateRequest {

    @ApiModelProperty(value = "Value")
    private float value;

    @ApiModelProperty(value = "Date")
    private LocalDate date;

    @ApiModelProperty(value = "Time type")
    private TimeType timeType;

    @ApiModelProperty(value = "Username")
    private String username;

}

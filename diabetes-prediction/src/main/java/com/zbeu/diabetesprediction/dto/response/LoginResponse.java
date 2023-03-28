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
@ApiModel(value = "Login Response")
public final class LoginResponse {

    @ApiModelProperty(value = "Token")
    private String token;

}

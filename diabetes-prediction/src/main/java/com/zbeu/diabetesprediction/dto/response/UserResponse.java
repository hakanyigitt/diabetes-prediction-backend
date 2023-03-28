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
@ApiModel(value = "User Response")
public final class UserResponse {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "User name")
    private String username;

    @ApiModelProperty(value = "Role name")
    private String role;

}

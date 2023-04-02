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
@ApiModel(value = "Petition Request")
public final class PetitionRequest {

    @ApiModelProperty(value = "Description")
    private String description;

    @ApiModelProperty(value = "Email")
    private String email;

}

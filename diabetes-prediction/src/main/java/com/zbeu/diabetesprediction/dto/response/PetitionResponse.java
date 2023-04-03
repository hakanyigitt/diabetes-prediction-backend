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
@ApiModel(value = "Petition Response")
public final class PetitionResponse {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "Description")
    private String description;

    @ApiModelProperty(value = "Email")
    private String email;

}

package com.zbeu.diabetesprediction.dto.request;

import com.zbeu.diabetesprediction.common.validator.UniqueEmail;
import com.zbeu.diabetesprediction.common.validator.UniqueUsername;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author HAKAN YIGIT
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Sign Up Request")
public final class SignUpRequest {

    @NotBlank(message = "{backend.constraints.username.NotBlank.message}")
    @Size(min = 3, max = 50, message = "{backend.constraints.username.Size.message}")
    @UniqueUsername
    @ApiModelProperty(value = "User name", required = true)
    private String username;

    @NotBlank(message = "{backend.constraints.firstName.NotBlank.message}")
    @Size(min = 3, max = 50, message = "{backend.constraints.firstName.Size.message}")
    @ApiModelProperty(value = "First name", required = true)
    private String firstName;

    @NotBlank(message = "{backend.constraints.lastName.NotBlank.message}")
    @Size(min = 2, max = 50, message = "{backend.constraints.lastName.Size.message}")
    @ApiModelProperty(value = "Last name", required = true)
    private String lastName;

    @NotBlank(message = "{backend.constraints.password.NotBlank.message}")
    @Size(min = 3, max = 32, message = "{backend.constraints.password.Size.message}")
    @ApiModelProperty(value = "Password", required = true)
    private String password;

    @NotBlank(message = "{backend.constraints.email.NotBlank.message}")
    @Size(min = 4, max = 50, message = "{backend.constraints.email.Size.message}")
    @UniqueEmail
    @ApiModelProperty(value = "email", required = true)
    private String email;

    @NotBlank(message = "{backend.constraints.role.NotBlank.message}")
    @Size(min = 2, max = 32, message = "{backend.constraints.role.Size.message}")
    @ApiModelProperty(value = "Role name", required = true)
    private String role;

}

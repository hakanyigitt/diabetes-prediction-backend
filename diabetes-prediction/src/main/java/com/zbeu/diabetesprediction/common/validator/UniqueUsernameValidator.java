package com.zbeu.diabetesprediction.common.validator;

import com.zbeu.diabetesprediction.services.UserService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author HAKAN YIGIT
 */

@RequiredArgsConstructor
public final class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userService.existsUserByUsername(username);
    }

}

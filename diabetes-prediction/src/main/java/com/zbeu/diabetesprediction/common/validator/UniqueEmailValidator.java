package com.zbeu.diabetesprediction.common.validator;

import com.zbeu.diabetesprediction.services.UserService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author HAKAN YIGIT
 */

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userService.existsUserByEmail(email);
    }
}

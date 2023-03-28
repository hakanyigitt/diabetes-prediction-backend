package com.zbeu.diabetesprediction.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author HAKAN YIGIT
 */

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {UniqueUsernameValidator.class})
public @interface UniqueUsername {

    String message() default "{backend.constraints.UniqueUsername.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

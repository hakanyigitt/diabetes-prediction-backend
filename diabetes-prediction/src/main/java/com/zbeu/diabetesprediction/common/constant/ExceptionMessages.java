package com.zbeu.diabetesprediction.common.constant;

/**
 * @author HAKAN YIGIT
 */

public final class ExceptionMessages {

    private static final String UTILITY_CLASS = "Utility Class";

    private ExceptionMessages() {
        throw new IllegalArgumentException(UTILITY_CLASS);
    }

    public static final String EXPIRED_OR_INVALID_JWT_TOKEN = "Expired or invalid JWT token";

    public static final String INVALID_USERNAME_OR_PASSWORD_SUPPLIED = "Invalid username/password supplied";

    public static final String USER_NOT_FOUND = "User Not Found !";

    public static final String ROLE_NOT_FOUND = "Role Not Found !";

    public static final String ADVICE_NOT_FOUND = "Advice Not Found !";

    public static final String PETITION_NOT_FOUND = "Petition Not Found !";

    public static final String QUESTION_NOT_FOUND = "Question Not Found !";

    public static final String BLOOD_SUGAR_NOT_FOUND = "Blood Sugar Not Found !";

}

package com.zbeu.diabetesprediction.common.constant;

/**
 * Swagger Api Response Messages
 *
 * @author HAKAN YIGIT
 */

public final class SwaggerMessages {
    private static final String UTILITY_CLASS = "Utility Class";

    private SwaggerMessages() {
        throw new IllegalArgumentException(UTILITY_CLASS);
    }

    public static final String SUCCESSFUL_LOGIN = "Successful login.";

    public static final String UNSUCCESSFUL_LOGIN = "Unsuccessful login.";

    public static final String FORBIDDEN = "Accessing the resource you were trying to reach is forbidden.";

    public static final String SUCCESSFUL_SIGNUP = "Successful sign up.";

    public static final String UNSUCCESSFUL_SIGNUP = "Unsuccessful sign up.";

    public static final String SUCCESSFUL_CREATE_ADVICE = "Successful create advice.";

    public static final String SUCCESSFUL_CREATE_PETITION = "Successful create petition.";

    public static final String SUCCESSFUL_CREATE_QUESTON = "Successful create question.";

    public static final String SUCCESSFUL_CREATE_BLOOD_SUGAR = "Successful create blood sugar.";

    public static final String SUCCESSFUL_CREATE_ANSWER = "Successful create answer";

}

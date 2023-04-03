package com.zbeu.diabetesprediction.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author HAKAN YIGIT
 */

@Getter
@AllArgsConstructor
public enum TimeType {
    MORNING_HUNGRY,
    MORNING_FULL,
    NOON_HUNGRY,
    NOON_FULL,
    EVENING_HUNGRY,
    EVENING_FULL
}

package org.sample.parkinglot.enums;

import java.time.DayOfWeek;

public enum ParkingDay {
    WEEK_DAY, WEEK_END;

    public static ParkingDay from(DayOfWeek dayOfWeek) {
        return (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY)
                ? WEEK_END
                : WEEK_DAY;
    }
}

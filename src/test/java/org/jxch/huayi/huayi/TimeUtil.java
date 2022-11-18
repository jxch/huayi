package org.jxch.huayi.huayi;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class TimeUtil {

    public static void sleep(@NotNull TimeUnit timeUnit, long number) {
        try {
            timeUnit.sleep(number);
        } catch (InterruptedException ignored) {
        }
    }

}

package org.luv2code.framework.utils;

import java.time.Duration;

public enum WaitTimeUtil {

    VERY_SHORT(Duration.ofMillis(500)),
    SHORT_ONE(Duration.ofSeconds(1)),
    SHORT_TWO(Duration.ofSeconds(2)),
    SHORT(Duration.ofSeconds(5)),
    MEDIUM(Duration.ofSeconds(10)),
    MEDIUM_15(Duration.ofSeconds(15)),
    LONG(Duration.ofSeconds(30)),
    EXTRA_LONG(Duration.ofSeconds(60)),
    PAGE_LOAD(Duration.ofSeconds(20)),
    EXPLICIT_WAIT(Duration.ofSeconds(60));

    private final Duration duration;

    WaitTimeUtil(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }

    public long getSeconds() {
        return duration.getSeconds();
    }

    public long getMillis() {
        return duration.toMillis();
    }

}

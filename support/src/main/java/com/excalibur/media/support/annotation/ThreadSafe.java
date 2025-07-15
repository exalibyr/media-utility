package com.excalibur.media.support.annotation;

import java.lang.annotation.*;

/**
 * @apiNote - specify that class is thread safe for concurrent use
 * */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ThreadSafe {
}

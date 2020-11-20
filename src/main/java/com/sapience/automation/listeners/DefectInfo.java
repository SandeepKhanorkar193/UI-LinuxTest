package com.sapience.automation.listeners;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author kohitij_das
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface DefectInfo {

    String jirId() default "";

    String stepName() default "";
}
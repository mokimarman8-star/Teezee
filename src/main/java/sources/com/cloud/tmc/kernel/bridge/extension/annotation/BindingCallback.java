package com.cloud.tmc.kernel.bridge.extension.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Bindable
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public @interface BindingCallback {
    boolean isSticky() default false;
}

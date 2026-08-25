package com.google.gson;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface ExclusionStrategy {
    boolean shouldSkipClass(Class<?> cls);

    boolean shouldSkipField(FieldAttributes fieldAttributes);
}

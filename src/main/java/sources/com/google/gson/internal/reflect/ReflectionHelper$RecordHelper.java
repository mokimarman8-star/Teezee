package com.google.gson.internal.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class ReflectionHelper$RecordHelper {
    private ReflectionHelper$RecordHelper() {
    }

    public abstract Method getAccessor(Class<?> cls, Field field);

    abstract <T> Constructor<T> getCanonicalRecordConstructor(Class<T> cls);

    abstract String[] getRecordComponentNames(Class<?> cls);

    abstract boolean isRecord(Class<?> cls);
}

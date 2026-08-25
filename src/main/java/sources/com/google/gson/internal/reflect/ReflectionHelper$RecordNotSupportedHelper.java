package com.google.gson.internal.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class ReflectionHelper$RecordNotSupportedHelper extends ReflectionHelper$RecordHelper {
    private ReflectionHelper$RecordNotSupportedHelper() {
        super();
    }

    @Override // com.google.gson.internal.reflect.ReflectionHelper$RecordHelper
    public Method getAccessor(Class<?> cls, Field field) {
        throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
    }

    @Override // com.google.gson.internal.reflect.ReflectionHelper$RecordHelper
    <T> Constructor<T> getCanonicalRecordConstructor(Class<T> cls) {
        throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
    }

    @Override // com.google.gson.internal.reflect.ReflectionHelper$RecordHelper
    String[] getRecordComponentNames(Class<?> cls) {
        throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
    }

    @Override // com.google.gson.internal.reflect.ReflectionHelper$RecordHelper
    boolean isRecord(Class<?> cls) {
        return false;
    }
}

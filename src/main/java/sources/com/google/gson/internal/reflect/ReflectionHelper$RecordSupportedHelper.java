package com.google.gson.internal.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class ReflectionHelper$RecordSupportedHelper extends ReflectionHelper$RecordHelper {
    private final Method getName;
    private final Method getRecordComponents;
    private final Method getType;
    private final Method isRecord;

    private ReflectionHelper$RecordSupportedHelper() throws NoSuchMethodException {
        super();
        this.isRecord = Class.class.getMethod("isRecord", null);
        Method method = Class.class.getMethod("getRecordComponents", null);
        this.getRecordComponents = method;
        Class<?> componentType = method.getReturnType().getComponentType();
        this.getName = componentType.getMethod("getName", null);
        this.getType = componentType.getMethod("getType", null);
    }

    @Override // com.google.gson.internal.reflect.ReflectionHelper$RecordHelper
    public Method getAccessor(Class<?> cls, Field field) {
        try {
            return cls.getMethod(field.getName(), null);
        } catch (ReflectiveOperationException e) {
            throw ReflectionHelper.access$300(e);
        }
    }

    @Override // com.google.gson.internal.reflect.ReflectionHelper$RecordHelper
    public <T> Constructor<T> getCanonicalRecordConstructor(Class<T> cls) {
        try {
            Object[] objArr = (Object[]) this.getRecordComponents.invoke(cls, null);
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                clsArr[i] = (Class) this.getType.invoke(objArr[i], null);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (ReflectiveOperationException e) {
            throw ReflectionHelper.access$300(e);
        }
    }

    @Override // com.google.gson.internal.reflect.ReflectionHelper$RecordHelper
    String[] getRecordComponentNames(Class<?> cls) {
        try {
            Object[] objArr = (Object[]) this.getRecordComponents.invoke(cls, null);
            String[] strArr = new String[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                strArr[i] = (String) this.getName.invoke(objArr[i], null);
            }
            return strArr;
        } catch (ReflectiveOperationException e) {
            throw ReflectionHelper.access$300(e);
        }
    }

    @Override // com.google.gson.internal.reflect.ReflectionHelper$RecordHelper
    boolean isRecord(Class<?> cls) {
        try {
            return ((Boolean) this.isRecord.invoke(cls, null)).booleanValue();
        } catch (ReflectiveOperationException e) {
            throw ReflectionHelper.access$300(e);
        }
    }
}

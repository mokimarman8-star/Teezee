package com.google.gson.internal.bind;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class ReflectiveTypeAdapterFactory$RecordAdapter<T> extends ReflectiveTypeAdapterFactory.Adapter<T, Object[]> {
    static final Map<Class<?>, Object> PRIMITIVE_DEFAULTS = primitiveDefaults();
    private final Map<String, Integer> componentIndices;
    private final Constructor<T> constructor;
    private final Object[] constructorArgsDefaults;

    ReflectiveTypeAdapterFactory$RecordAdapter(Class<T> cls, Map<String, ReflectiveTypeAdapterFactory.BoundField> map, boolean z) {
        super(map);
        this.componentIndices = new HashMap();
        Constructor<T> canonicalRecordConstructor = ReflectionHelper.getCanonicalRecordConstructor(cls);
        this.constructor = canonicalRecordConstructor;
        if (z) {
            ReflectiveTypeAdapterFactory.access$000((Object) null, canonicalRecordConstructor);
        } else {
            ReflectionHelper.makeAccessible(canonicalRecordConstructor);
        }
        String[] recordComponentNames = ReflectionHelper.getRecordComponentNames(cls);
        for (int i = 0; i < recordComponentNames.length; i++) {
            this.componentIndices.put(recordComponentNames[i], Integer.valueOf(i));
        }
        Class<?>[] parameterTypes = this.constructor.getParameterTypes();
        this.constructorArgsDefaults = new Object[parameterTypes.length];
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            this.constructorArgsDefaults[i2] = PRIMITIVE_DEFAULTS.get(parameterTypes[i2]);
        }
    }

    private static Map<Class<?>, Object> primitiveDefaults() {
        HashMap hashMap = new HashMap();
        hashMap.put(Byte.TYPE, (byte) 0);
        hashMap.put(Short.TYPE, (short) 0);
        hashMap.put(Integer.TYPE, 0);
        hashMap.put(Long.TYPE, 0L);
        hashMap.put(Float.TYPE, Float.valueOf(0.0f));
        hashMap.put(Double.TYPE, Double.valueOf(0.0d));
        hashMap.put(Character.TYPE, (char) 0);
        hashMap.put(Boolean.TYPE, Boolean.FALSE);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] createAccumulator() {
        return (Object[]) this.constructorArgsDefaults.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T finalize(Object[] objArr) {
        try {
            return this.constructor.newInstance(objArr);
        } catch (IllegalAccessException e) {
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InstantiationException e3) {
            e = e3;
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e4.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readField(Object[] objArr, JsonReader jsonReader, ReflectiveTypeAdapterFactory.BoundField boundField) throws IOException {
        Integer num = this.componentIndices.get(boundField.fieldName);
        if (num != null) {
            boundField.readIntoArray(jsonReader, num.intValue(), objArr);
            return;
        }
        throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' for field with name '" + boundField.fieldName + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
    }
}

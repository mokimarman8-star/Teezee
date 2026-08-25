package com.google.gson.internal.bind;

import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class ReflectiveTypeAdapterFactory$FieldReflectionAdapter<T> extends ReflectiveTypeAdapterFactory.Adapter<T, T> {
    private final ObjectConstructor<T> constructor;

    ReflectiveTypeAdapterFactory$FieldReflectionAdapter(ObjectConstructor<T> objectConstructor, Map<String, ReflectiveTypeAdapterFactory.BoundField> map) {
        super(map);
        this.constructor = objectConstructor;
    }

    T createAccumulator() {
        return (T) this.constructor.construct();
    }

    T finalize(T t) {
        return t;
    }

    void readField(T t, JsonReader jsonReader, ReflectiveTypeAdapterFactory.BoundField boundField) throws IllegalAccessException, IOException {
        boundField.readIntoField(jsonReader, t);
    }
}

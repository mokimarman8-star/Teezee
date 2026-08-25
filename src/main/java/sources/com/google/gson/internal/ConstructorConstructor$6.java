package com.google.gson.internal;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class ConstructorConstructor$6<T> implements ObjectConstructor<T> {
    final /* synthetic */ Type val$type;

    ConstructorConstructor$6(Type type) {
        this.val$type = type;
    }

    public T construct() {
        Type type = this.val$type;
        if (!(type instanceof ParameterizedType)) {
            throw new JsonIOException("Invalid EnumMap type: " + this.val$type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return (T) new EnumMap((Class) type2);
        }
        throw new JsonIOException("Invalid EnumMap type: " + this.val$type.toString());
    }
}

package com.alibaba.fastjson.util;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class GenericArrayTypeImpl implements GenericArrayType {
    private final Type a;

    public GenericArrayTypeImpl(Type type) {
        this.a = type;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GenericArrayType) {
            return this.a.equals(((GenericArrayType) obj).getGenericComponentType());
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        Type genericComponentType = getGenericComponentType();
        StringBuilder sb = new StringBuilder();
        if (genericComponentType instanceof Class) {
            sb.append(((Class) genericComponentType).getName());
        } else {
            sb.append(genericComponentType.toString());
        }
        sb.append("[]");
        return sb.toString();
    }
}

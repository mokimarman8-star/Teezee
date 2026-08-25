package com.alibaba.fastjson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ParameterizedTypeImpl implements ParameterizedType {
    private final Type[] a;
    private final Type b;
    private final Type c;

    public ParameterizedTypeImpl(Type[] typeArr, Type type, Type type2) {
        this.a = typeArr;
        this.b = type;
        this.c = type2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParameterizedTypeImpl parameterizedTypeImpl = (ParameterizedTypeImpl) obj;
        if (!Arrays.equals(this.a, parameterizedTypeImpl.a)) {
            return false;
        }
        Type type = this.b;
        if (type == null ? parameterizedTypeImpl.b != null : !type.equals(parameterizedTypeImpl.b)) {
            return false;
        }
        Type type2 = this.c;
        Type type3 = parameterizedTypeImpl.c;
        return type2 != null ? type2.equals(type3) : type3 == null;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.c;
    }

    public int hashCode() {
        Type[] typeArr = this.a;
        int hashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.b;
        int hashCode2 = (hashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.c;
        return hashCode2 + (type2 != null ? type2.hashCode() : 0);
    }
}

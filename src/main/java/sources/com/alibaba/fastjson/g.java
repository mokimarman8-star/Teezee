package com.alibaba.fastjson;

import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class g {

    /* renamed from: b, reason: collision with root package name */
    static ConcurrentMap f14725b = new ConcurrentHashMap(16, 0.75f, 1);

    /* renamed from: c, reason: collision with root package name */
    public static final Type f14726c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    protected final Type f14727a;

    static class a extends g {
        a() {
        }
    }

    protected g() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type type2 = (Type) f14725b.get(type);
        if (type2 == null) {
            f14725b.putIfAbsent(type, type);
            type2 = (Type) f14725b.get(type);
        }
        this.f14727a = type2;
    }

    public static Type b(ParameterizedTypeImpl parameterizedTypeImpl) {
        Type type = (Type) f14725b.get(parameterizedTypeImpl);
        if (type != null) {
            return type;
        }
        f14725b.putIfAbsent(parameterizedTypeImpl, parameterizedTypeImpl);
        return (Type) f14725b.get(parameterizedTypeImpl);
    }

    public Type a() {
        return this.f14727a;
    }
}

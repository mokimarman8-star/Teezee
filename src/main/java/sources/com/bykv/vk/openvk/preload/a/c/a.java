package com.bykv.vk.openvk.preload.a.c;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class a<T> {
    private Class<? super T> a;
    private Type b;
    private int c;

    protected a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        Type a = com.bykv.vk.openvk.preload.a.b.a.a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        this.b = a;
        this.a = (Class<? super T>) com.bykv.vk.openvk.preload.a.b.a.b(a);
        this.c = this.b.hashCode();
    }

    private a(Type type) {
        Type a = com.bykv.vk.openvk.preload.a.b.a.a((Type) com.bykv.vk.openvk.preload.falconx.a.a.a(type));
        this.b = a;
        this.a = (Class<? super T>) com.bykv.vk.openvk.preload.a.b.a.b(a);
        this.c = this.b.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public final Class<? super T> a() {
        return this.a;
    }

    public final Type b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && com.bykv.vk.openvk.preload.a.b.a.a(this.b, ((a) obj).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return com.bykv.vk.openvk.preload.a.b.a.c(this.b);
    }
}

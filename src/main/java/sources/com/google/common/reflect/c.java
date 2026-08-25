package com.google.common.reflect;

import com.google.common.base.m;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class c {
    c() {
    }

    final Type capture() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        m.j(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}

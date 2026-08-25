package com.google.gson.internal;

import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class UnsafeAllocator$3 extends UnsafeAllocator {
    final /* synthetic */ Method val$newInstance;

    UnsafeAllocator$3(Method method) {
        this.val$newInstance = method;
    }

    public <T> T newInstance(Class<T> cls) throws Exception {
        UnsafeAllocator.access$000(cls);
        return (T) this.val$newInstance.invoke(null, cls, Object.class);
    }
}

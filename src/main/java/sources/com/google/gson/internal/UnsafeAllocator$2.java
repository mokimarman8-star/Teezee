package com.google.gson.internal;

import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class UnsafeAllocator$2 extends UnsafeAllocator {
    final /* synthetic */ int val$constructorId;
    final /* synthetic */ Method val$newInstance;

    UnsafeAllocator$2(Method method, int i) {
        this.val$newInstance = method;
        this.val$constructorId = i;
    }

    public <T> T newInstance(Class<T> cls) throws Exception {
        UnsafeAllocator.access$000(cls);
        return (T) this.val$newInstance.invoke(null, cls, Integer.valueOf(this.val$constructorId));
    }
}

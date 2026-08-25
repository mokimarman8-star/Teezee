package com.google.gson.internal;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class UnsafeAllocator$4 extends UnsafeAllocator {
    UnsafeAllocator$4() {
    }

    public <T> T newInstance(Class<T> cls) {
        throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
    }
}

package com.google.gson.internal;

import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class ConstructorConstructor$14<T> implements ObjectConstructor<T> {
    ConstructorConstructor$14() {
    }

    public T construct() {
        return (T) new ConcurrentSkipListMap();
    }
}

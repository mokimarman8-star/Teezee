package com.google.gson.internal;

import java.util.ArrayDeque;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class ConstructorConstructor$12<T> implements ObjectConstructor<T> {
    ConstructorConstructor$12() {
    }

    public T construct() {
        return (T) new ArrayDeque();
    }
}

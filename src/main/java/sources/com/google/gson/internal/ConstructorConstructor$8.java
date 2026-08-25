package com.google.gson.internal;

import com.google.gson.JsonIOException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class ConstructorConstructor$8<T> implements ObjectConstructor<T> {
    final /* synthetic */ String val$exceptionMessage;

    ConstructorConstructor$8(String str) {
        this.val$exceptionMessage = str;
    }

    public T construct() {
        throw new JsonIOException(this.val$exceptionMessage);
    }
}

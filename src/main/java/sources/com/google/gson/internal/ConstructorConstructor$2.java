package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class ConstructorConstructor$2<T> implements ObjectConstructor<T> {
    final /* synthetic */ ConstructorConstructor this$0;
    final /* synthetic */ InstanceCreator val$rawTypeCreator;
    final /* synthetic */ Type val$type;

    ConstructorConstructor$2(ConstructorConstructor constructorConstructor, InstanceCreator instanceCreator, Type type) {
        this.this$0 = constructorConstructor;
        this.val$rawTypeCreator = instanceCreator;
        this.val$type = type;
    }

    public T construct() {
        return (T) this.val$rawTypeCreator.createInstance(this.val$type);
    }
}

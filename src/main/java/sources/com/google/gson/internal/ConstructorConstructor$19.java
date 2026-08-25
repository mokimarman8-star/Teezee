package com.google.gson.internal;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class ConstructorConstructor$19<T> implements ObjectConstructor<T> {
    final /* synthetic */ ConstructorConstructor this$0;
    final /* synthetic */ Class val$rawType;

    ConstructorConstructor$19(ConstructorConstructor constructorConstructor, Class cls) {
        this.this$0 = constructorConstructor;
        this.val$rawType = cls;
    }

    public T construct() {
        try {
            return (T) UnsafeAllocator.INSTANCE.newInstance(this.val$rawType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create instance of " + this.val$rawType + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
        }
    }
}

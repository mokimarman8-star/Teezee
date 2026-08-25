package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface InstanceCreator<T> {
    T createInstance(Type type);
}

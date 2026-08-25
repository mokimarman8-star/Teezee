package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class SerializationDelegatingTypeAdapter<T> extends TypeAdapter<T> {
    public abstract TypeAdapter<T> getSerializationDelegate();
}

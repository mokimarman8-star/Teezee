package com.google.gson;

import com.google.gson.reflect.TypeToken;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}

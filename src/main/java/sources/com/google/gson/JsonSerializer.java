package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext);
}

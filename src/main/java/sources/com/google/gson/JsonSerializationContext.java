package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface JsonSerializationContext {
    JsonElement serialize(Object obj);

    JsonElement serialize(Object obj, Type type);
}

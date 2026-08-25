package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface JsonDeserializer<T> {
    T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
}

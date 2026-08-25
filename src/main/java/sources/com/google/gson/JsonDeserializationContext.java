package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface JsonDeserializationContext {
    <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException;
}

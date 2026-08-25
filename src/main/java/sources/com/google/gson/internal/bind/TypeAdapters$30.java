package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class TypeAdapters$30 implements TypeAdapterFactory {
    final /* synthetic */ TypeToken val$type;
    final /* synthetic */ TypeAdapter val$typeAdapter;

    TypeAdapters$30(TypeToken typeToken, TypeAdapter typeAdapter) {
        this.val$type = typeToken;
        this.val$typeAdapter = typeAdapter;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (typeToken.equals(this.val$type)) {
            return this.val$typeAdapter;
        }
        return null;
    }
}

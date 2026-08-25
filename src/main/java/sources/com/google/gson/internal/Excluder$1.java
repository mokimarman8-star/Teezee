package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class Excluder$1<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final /* synthetic */ Excluder this$0;
    final /* synthetic */ Gson val$gson;
    final /* synthetic */ boolean val$skipDeserialize;
    final /* synthetic */ boolean val$skipSerialize;
    final /* synthetic */ TypeToken val$type;

    Excluder$1(Excluder excluder, boolean z, boolean z2, Gson gson, TypeToken typeToken) {
        this.this$0 = excluder;
        this.val$skipDeserialize = z;
        this.val$skipSerialize = z2;
        this.val$gson = gson;
        this.val$type = typeToken;
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.val$gson.getDelegateAdapter(this.this$0, this.val$type);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public T read(JsonReader jsonReader) throws IOException {
        if (!this.val$skipDeserialize) {
            return (T) delegate().read(jsonReader);
        }
        jsonReader.skipValue();
        return null;
    }

    public void write(JsonWriter jsonWriter, T t) throws IOException {
        if (this.val$skipSerialize) {
            jsonWriter.nullValue();
        } else {
            delegate().write(jsonWriter, t);
        }
    }
}

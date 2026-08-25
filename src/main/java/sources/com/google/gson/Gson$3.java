package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class Gson$3 extends TypeAdapter<Number> {
    Gson$3() {
    }

    /* renamed from: read, reason: merged with bridge method [inline-methods] */
    public Number m49read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) {
            return Long.valueOf(jsonReader.nextLong());
        }
        jsonReader.nextNull();
        return null;
    }

    public void write(JsonWriter jsonWriter, Number number) throws IOException {
        if (number == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(number.toString());
        }
    }
}

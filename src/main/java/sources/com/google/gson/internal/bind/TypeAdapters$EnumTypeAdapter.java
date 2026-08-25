package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.Enum;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class TypeAdapters$EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
    private final Map<String, T> nameToConstant = new HashMap();
    private final Map<String, T> stringToConstant = new HashMap();
    private final Map<T, String> constantToName = new HashMap();

    public TypeAdapters$EnumTypeAdapter(final Class<T> cls) {
        try {
            for (Field field : (Field[]) AccessController.doPrivileged(new PrivilegedAction<Field[]>() { // from class: com.google.gson.internal.bind.TypeAdapters$EnumTypeAdapter.1
                @Override // java.security.PrivilegedAction
                public Field[] run() {
                    Field[] declaredFields = cls.getDeclaredFields();
                    ArrayList arrayList = new ArrayList(declaredFields.length);
                    for (Field field2 : declaredFields) {
                        if (field2.isEnumConstant()) {
                            arrayList.add(field2);
                        }
                    }
                    Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                    AccessibleObject.setAccessible(fieldArr, true);
                    return fieldArr;
                }
            })) {
                Enum r4 = (Enum) field.get(null);
                String name = r4.name();
                String str = r4.toString();
                SerializedName annotation = field.getAnnotation(SerializedName.class);
                if (annotation != null) {
                    name = annotation.value();
                    for (String str2 : annotation.alternate()) {
                        this.nameToConstant.put(str2, r4);
                    }
                }
                this.nameToConstant.put(name, r4);
                this.stringToConstant.put(str, r4);
                this.constantToName.put(r4, name);
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: read, reason: merged with bridge method [inline-methods] */
    public T m52read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        T t = this.nameToConstant.get(nextString);
        return t == null ? this.stringToConstant.get(nextString) : t;
    }

    public void write(JsonWriter jsonWriter, T t) throws IOException {
        jsonWriter.value(t == null ? null : this.constantToName.get(t));
    }
}

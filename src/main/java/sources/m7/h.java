package m7;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class h extends TypeAdapter {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.BEGIN_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static String a(JsonReader jsonReader) {
        try {
            return new Gson().toJson(JsonParser.parseReader(jsonReader));
        } catch (Exception unused) {
            return null;
        }
    }

    public String read(JsonReader jsonReader) {
        if (jsonReader == null) {
            return null;
        }
        int i = a.a[jsonReader.peek().ordinal()];
        if (i == 1 || i == 2) {
            return jsonReader.nextString();
        }
        if (i == 3) {
            return Boolean.toString(jsonReader.nextBoolean());
        }
        if (i == 4) {
            return a(jsonReader);
        }
        jsonReader.skipValue();
        return null;
    }

    public void write(JsonWriter jsonWriter, String str) {
        jsonWriter.value(str);
    }
}

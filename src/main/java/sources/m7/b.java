package m7;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class b extends TypeAdapter {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: read, reason: merged with bridge method [inline-methods] */
    public Boolean m82read(JsonReader jsonReader) {
        if (jsonReader == null) {
            return null;
        }
        int i = a.a[jsonReader.peek().ordinal()];
        if (i == 1) {
            return Boolean.valueOf(jsonReader.nextBoolean());
        }
        if (i == 2) {
            return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
        }
        if (i == 3) {
            return Boolean.valueOf(jsonReader.nextInt() != 0);
        }
        jsonReader.skipValue();
        return null;
    }

    public void write(JsonWriter jsonWriter, Boolean bool) {
        jsonWriter.value(bool);
    }
}

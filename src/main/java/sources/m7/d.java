package m7;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class d extends TypeAdapter {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Float f) {
        jsonWriter.value(f);
    }

    /* renamed from: read, reason: merged with bridge method [inline-methods] */
    public Float m84read(JsonReader jsonReader) {
        if (jsonReader == null) {
            return null;
        }
        int i = a.a[jsonReader.peek().ordinal()];
        if (i == 1) {
            return Float.valueOf((float) jsonReader.nextDouble());
        }
        if (i != 2) {
            jsonReader.skipValue();
            return null;
        }
        String nextString = jsonReader.nextString();
        if (TextUtils.isEmpty(nextString)) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(nextString));
        } catch (Exception e) {
            Log.getStackTraceString(e);
            return null;
        }
    }
}

package m7;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.math.BigDecimal;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class a extends TypeAdapter {

    /* renamed from: m7.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0149a {
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

    public BigDecimal read(JsonReader jsonReader) {
        if (jsonReader == null) {
            return null;
        }
        int i = C0149a.a[jsonReader.peek().ordinal()];
        if (i != 1 && i != 2) {
            jsonReader.skipValue();
            return null;
        }
        String nextString = jsonReader.nextString();
        if (TextUtils.isEmpty(nextString)) {
            return null;
        }
        try {
            return new BigDecimal(nextString);
        } catch (Exception e) {
            Log.getStackTraceString(e);
            return null;
        }
    }

    public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) {
        jsonWriter.value(bigDecimal);
    }
}

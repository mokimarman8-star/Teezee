package m7;

import android.text.TextUtils;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.math.BigDecimal;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class g extends TypeAdapter {

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
    public Long read(JsonReader jsonReader) {
        if (jsonReader == null) {
            return null;
        }
        int i = a.a[jsonReader.peek().ordinal()];
        if (i == 1) {
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException unused) {
                return Long.valueOf(new BigDecimal(jsonReader.nextString()).longValue());
            }
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
            try {
                return Long.valueOf(Long.parseLong(nextString));
            } catch (Exception unused2) {
                return null;
            }
        } catch (NumberFormatException unused3) {
            return Long.valueOf(new BigDecimal(nextString).longValue());
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Long l) {
        jsonWriter.value(l);
    }
}

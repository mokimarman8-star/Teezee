package m7;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.math.BigDecimal;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class f extends TypeAdapter {

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
    public Integer read(JsonReader jsonReader) {
        if (jsonReader == null) {
            return null;
        }
        int i = a.a[jsonReader.peek().ordinal()];
        if (i == 1) {
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException unused) {
                return Integer.valueOf((int) jsonReader.nextDouble());
            }
        }
        if (i != 2) {
            jsonReader.skipValue();
            return null;
        }
        String nextString = jsonReader.nextString();
        if (nextString != null && !"".equals(nextString)) {
            try {
                try {
                    return Integer.valueOf(Integer.parseInt(nextString));
                } catch (NumberFormatException unused2) {
                    return Integer.valueOf((int) new BigDecimal(nextString).floatValue());
                }
            } catch (Exception unused3) {
            }
        }
        return null;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Integer num) {
        jsonWriter.value(num);
    }
}

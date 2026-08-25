package w4;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader$a f18202a = JsonReader$a.a("x", "y");

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18203a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f18203a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18203a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18203a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF a(JsonReader jsonReader, float f5) {
        jsonReader.d();
        float o5 = (float) jsonReader.o();
        float o6 = (float) jsonReader.o();
        while (jsonReader.t() != JsonReader.Token.END_ARRAY) {
            jsonReader.x();
        }
        jsonReader.k();
        return new PointF(o5 * f5, o6 * f5);
    }

    private static PointF b(JsonReader jsonReader, float f5) {
        float o5 = (float) jsonReader.o();
        float o6 = (float) jsonReader.o();
        while (jsonReader.m()) {
            jsonReader.x();
        }
        return new PointF(o5 * f5, o6 * f5);
    }

    private static PointF c(JsonReader jsonReader, float f5) {
        jsonReader.h();
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (jsonReader.m()) {
            int v5 = jsonReader.v(f18202a);
            if (v5 == 0) {
                f6 = g(jsonReader);
            } else if (v5 != 1) {
                jsonReader.w();
                jsonReader.x();
            } else {
                f7 = g(jsonReader);
            }
        }
        jsonReader.l();
        return new PointF(f6 * f5, f7 * f5);
    }

    static int d(JsonReader jsonReader) {
        jsonReader.d();
        int o5 = (int) (jsonReader.o() * 255.0d);
        int o6 = (int) (jsonReader.o() * 255.0d);
        int o7 = (int) (jsonReader.o() * 255.0d);
        while (jsonReader.m()) {
            jsonReader.x();
        }
        jsonReader.k();
        return Color.argb(255, o5, o6, o7);
    }

    static PointF e(JsonReader jsonReader, float f5) {
        int i5 = a.f18203a[jsonReader.t().ordinal()];
        if (i5 == 1) {
            return b(jsonReader, f5);
        }
        if (i5 == 2) {
            return a(jsonReader, f5);
        }
        if (i5 == 3) {
            return c(jsonReader, f5);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.t());
    }

    static List f(JsonReader jsonReader, float f5) {
        ArrayList arrayList = new ArrayList();
        jsonReader.d();
        while (jsonReader.t() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.d();
            arrayList.add(e(jsonReader, f5));
            jsonReader.k();
        }
        jsonReader.k();
        return arrayList;
    }

    static float g(JsonReader jsonReader) {
        JsonReader.Token t5 = jsonReader.t();
        int i5 = a.f18203a[t5.ordinal()];
        if (i5 == 1) {
            return (float) jsonReader.o();
        }
        if (i5 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + t5);
        }
        jsonReader.d();
        float o5 = (float) jsonReader.o();
        while (jsonReader.m()) {
            jsonReader.x();
        }
        jsonReader.k();
        return o5;
    }
}

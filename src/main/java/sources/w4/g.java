package w4;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class g implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final g f18166a = new g();

    private g() {
    }

    @Override // w4.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f5) {
        boolean z5 = jsonReader.t() == JsonReader.Token.BEGIN_ARRAY;
        if (z5) {
            jsonReader.d();
        }
        double o5 = jsonReader.o();
        double o6 = jsonReader.o();
        double o7 = jsonReader.o();
        double o8 = jsonReader.t() == JsonReader.Token.NUMBER ? jsonReader.o() : 1.0d;
        if (z5) {
            jsonReader.k();
        }
        if (o5 <= 1.0d && o6 <= 1.0d && o7 <= 1.0d) {
            o5 *= 255.0d;
            o6 *= 255.0d;
            o7 *= 255.0d;
            if (o8 <= 1.0d) {
                o8 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) o8, (int) o5, (int) o6, (int) o7));
    }
}

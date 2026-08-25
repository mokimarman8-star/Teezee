package w4;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader$a f18194a = JsonReader$a.a("fFamily", "fName", "fStyle", "ascent");

    static r4.b a(JsonReader jsonReader) {
        jsonReader.h();
        String str = null;
        String str2 = null;
        float f5 = 0.0f;
        String str3 = null;
        while (jsonReader.m()) {
            int v5 = jsonReader.v(f18194a);
            if (v5 == 0) {
                str = jsonReader.r();
            } else if (v5 == 1) {
                str3 = jsonReader.r();
            } else if (v5 == 2) {
                str2 = jsonReader.r();
            } else if (v5 != 3) {
                jsonReader.w();
                jsonReader.x();
            } else {
                f5 = (float) jsonReader.o();
            }
        }
        jsonReader.l();
        return new r4.b(str, str3, str2, f5);
    }
}

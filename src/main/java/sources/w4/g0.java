package w4;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class g0 implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final g0 f18167a = new g0();

    private g0() {
    }

    @Override // w4.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public y4.d a(JsonReader jsonReader, float f5) {
        boolean z5 = jsonReader.t() == JsonReader.Token.BEGIN_ARRAY;
        if (z5) {
            jsonReader.d();
        }
        float o5 = (float) jsonReader.o();
        float o6 = (float) jsonReader.o();
        while (jsonReader.m()) {
            jsonReader.x();
        }
        if (z5) {
            jsonReader.k();
        }
        return new y4.d((o5 / 100.0f) * f5, (o6 / 100.0f) * f5);
    }
}

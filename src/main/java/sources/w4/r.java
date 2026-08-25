package w4;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class r implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final r f18201a = new r();

    private r() {
    }

    @Override // w4.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f5) {
        return Integer.valueOf(Math.round(s.g(jsonReader) * f5));
    }
}

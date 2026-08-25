package w4;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class b0 implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f18156a = new b0();

    private b0() {
    }

    @Override // w4.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(JsonReader jsonReader, float f5) {
        JsonReader.Token t5 = jsonReader.t();
        if (t5 != JsonReader.Token.BEGIN_ARRAY && t5 != JsonReader.Token.BEGIN_OBJECT) {
            if (t5 == JsonReader.Token.NUMBER) {
                PointF pointF = new PointF(((float) jsonReader.o()) * f5, ((float) jsonReader.o()) * f5);
                while (jsonReader.m()) {
                    jsonReader.x();
                }
                return pointF;
            }
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + t5);
        }
        return s.e(jsonReader, f5);
    }
}

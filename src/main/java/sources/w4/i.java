package w4;

import android.graphics.PointF;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class i implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i f18171a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final JsonReader$a f18172b = JsonReader$a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    private i() {
    }

    @Override // w4.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public DocumentData a(JsonReader jsonReader, float f5) {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.h();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z5 = true;
        while (jsonReader.m()) {
            switch (jsonReader.v(f18172b)) {
                case 0:
                    str = jsonReader.r();
                    break;
                case 1:
                    str2 = jsonReader.r();
                    break;
                case 2:
                    f6 = (float) jsonReader.o();
                    break;
                case 3:
                    int p5 = jsonReader.p();
                    justification2 = DocumentData.Justification.CENTER;
                    if (p5 <= justification2.ordinal() && p5 >= 0) {
                        justification2 = DocumentData.Justification.values()[p5];
                        break;
                    }
                    break;
                case 4:
                    i5 = jsonReader.p();
                    break;
                case 5:
                    f7 = (float) jsonReader.o();
                    break;
                case 6:
                    f8 = (float) jsonReader.o();
                    break;
                case 7:
                    i6 = s.d(jsonReader);
                    break;
                case 8:
                    i7 = s.d(jsonReader);
                    break;
                case 9:
                    f9 = (float) jsonReader.o();
                    break;
                case 10:
                    z5 = jsonReader.n();
                    break;
                case 11:
                    jsonReader.d();
                    PointF pointF3 = new PointF(((float) jsonReader.o()) * f5, ((float) jsonReader.o()) * f5);
                    jsonReader.k();
                    pointF = pointF3;
                    break;
                case 12:
                    jsonReader.d();
                    PointF pointF4 = new PointF(((float) jsonReader.o()) * f5, ((float) jsonReader.o()) * f5);
                    jsonReader.k();
                    pointF2 = pointF4;
                    break;
                default:
                    jsonReader.w();
                    jsonReader.x();
                    break;
            }
        }
        jsonReader.l();
        return new DocumentData(str, str2, f6, justification2, i5, f7, f8, i6, i7, f9, z5, pointF, pointF2);
    }
}

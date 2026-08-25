package androidx.media3.exoplayer.video.spherical;

import android.opengl.Matrix;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.o0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f11920a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f11921b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private final o0 f11922c = new o0();

    /* renamed from: d, reason: collision with root package name */
    private boolean f11923d;

    public static void a(float[] fArr, float[] fArr2) {
        GlUtil.k(fArr);
        float f5 = fArr2[10];
        float f6 = fArr2[8];
        float sqrt = (float) Math.sqrt((f5 * f5) + (f6 * f6));
        float f7 = fArr2[10];
        fArr[0] = f7 / sqrt;
        float f8 = fArr2[8];
        fArr[2] = f8 / sqrt;
        fArr[8] = (-f8) / sqrt;
        fArr[10] = f7 / sqrt;
    }

    private static void b(float[] fArr, float[] fArr2) {
        float f5 = fArr2[0];
        float f6 = -fArr2[1];
        float f7 = -fArr2[2];
        float length = Matrix.length(f5, f6, f7);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f5 / length, f6 / length, f7 / length);
        } else {
            GlUtil.k(fArr);
        }
    }

    public boolean c(float[] fArr, long j5) {
        float[] fArr2 = (float[]) this.f11922c.j(j5);
        if (fArr2 == null) {
            return false;
        }
        b(this.f11921b, fArr2);
        if (!this.f11923d) {
            a(this.f11920a, this.f11921b);
            this.f11923d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f11920a, 0, this.f11921b, 0);
        return true;
    }

    public void d() {
        this.f11922c.c();
        this.f11923d = false;
    }

    public void e(long j5, float[] fArr) {
        this.f11922c.a(j5, fArr);
    }
}

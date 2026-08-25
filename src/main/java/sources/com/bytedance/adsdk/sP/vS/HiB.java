package com.bytedance.adsdk.sP.vS;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.sP.TKC.sP.sef;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HiB {
    private static final PointF Sj = new PointF();

    public static float Sj(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    static int Sj(float f, float f2) {
        return Sj((int) f, (int) f2);
    }

    private static int Sj(int i, int i2) {
        return i - (i2 * sP(i, i2));
    }

    public static int Sj(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static int Sj(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static PointF Sj(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void Sj(sef sefVar, Path path) {
        path.reset();
        PointF Sj2 = sefVar.Sj();
        path.moveTo(Sj2.x, Sj2.y);
        Sj.set(Sj2.x, Sj2.y);
        for (int i = 0; i < sefVar.TKC().size(); i++) {
            com.bytedance.adsdk.sP.TKC.Sj sj = sefVar.TKC().get(i);
            PointF Sj3 = sj.Sj();
            PointF sP = sj.sP();
            PointF TKC = sj.TKC();
            PointF pointF = Sj;
            if (Sj3.equals(pointF) && sP.equals(TKC)) {
                path.lineTo(TKC.x, TKC.y);
            } else {
                path.cubicTo(Sj3.x, Sj3.y, sP.x, sP.y, TKC.x, TKC.y);
            }
            pointF.set(TKC.x, TKC.y);
        }
        if (sefVar.sP()) {
            path.close();
        }
    }

    public static boolean TKC(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static float sP(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private static int sP(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }
}

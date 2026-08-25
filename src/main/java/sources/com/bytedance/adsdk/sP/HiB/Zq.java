package com.bytedance.adsdk.sP.HiB;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Zq implements Ei<com.bytedance.adsdk.sP.TKC.sP.EjP> {
    private int Sj;

    public Zq(int i) {
        this.Sj = i;
    }

    private int Sj(float f, int i, float[] fArr, float[] fArr2) {
        float Sj;
        if (fArr2.length < 2 || f <= fArr[0]) {
            return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
        }
        for (int i2 = 1; i2 < fArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 >= f || i2 == fArr.length - 1) {
                if (f2 <= f) {
                    Sj = fArr2[i2];
                } else {
                    int i3 = i2 - 1;
                    float f3 = fArr[i3];
                    Sj = com.bytedance.adsdk.sP.vS.HiB.Sj(fArr2[i3], fArr2[i2], (f - f3) / (f2 - f3));
                }
                return Color.argb((int) (Sj * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    private com.bytedance.adsdk.sP.TKC.sP.EjP Sj(com.bytedance.adsdk.sP.TKC.sP.EjP ejP, List<Float> list) {
        int i = this.Sj * 4;
        if (list.size() <= i) {
            return ejP;
        }
        float[] Sj = ejP.Sj();
        int[] sP = ejP.sP();
        int size = (list.size() - i) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i2 = 0;
        while (i < list.size()) {
            if (i % 2 == 0) {
                fArr[i2] = list.get(i).floatValue();
            } else {
                fArr2[i2] = list.get(i).floatValue();
                i2++;
            }
            i++;
        }
        float[] Sj2 = Sj(ejP.Sj(), fArr);
        int length = Sj2.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            float f = Sj2[i3];
            int binarySearch = Arrays.binarySearch(Sj, f);
            int binarySearch2 = Arrays.binarySearch(fArr, f);
            if (binarySearch < 0 || binarySearch2 > 0) {
                if (binarySearch2 < 0) {
                    binarySearch2 = -(binarySearch2 + 1);
                }
                iArr[i3] = Sj(f, fArr2[binarySearch2], Sj, sP);
            } else {
                iArr[i3] = Sj(f, sP[binarySearch], fArr, fArr2);
            }
        }
        return new com.bytedance.adsdk.sP.TKC.sP.EjP(Sj2, iArr);
    }

    protected static float[] Sj(float[] fArr, float[] fArr2) {
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            float f = i2 < fArr.length ? fArr[i2] : Float.NaN;
            float f2 = i3 < fArr2.length ? fArr2[i3] : Float.NaN;
            if (Float.isNaN(f2) || f < f2) {
                fArr3[i4] = f;
                i2++;
            } else if (Float.isNaN(f) || f2 < f) {
                fArr3[i4] = f2;
                i3++;
            } else {
                fArr3[i4] = f;
                i2++;
                i3++;
                i++;
            }
        }
        return i == 0 ? fArr3 : Arrays.copyOf(fArr3, length - i);
    }

    int Sj(float f, float f2, float[] fArr, int[] iArr) {
        if (iArr.length < 2 || f == fArr[0]) {
            return iArr[0];
        }
        for (int i = 1; i < fArr.length; i++) {
            float f3 = fArr[i];
            if (f3 >= f || i == fArr.length - 1) {
                int i2 = i - 1;
                float f4 = fArr[i2];
                float f8 = (f - f4) / (f3 - f4);
                int i3 = iArr[i];
                int i4 = iArr[i2];
                return Color.argb((int) (f2 * 255.0f), com.bytedance.adsdk.sP.vS.sP.Sj(f8, Color.red(i4), Color.red(i3)), com.bytedance.adsdk.sP.vS.sP.Sj(f8, Color.green(i4), Color.green(i3)), com.bytedance.adsdk.sP.vS.sP.Sj(f8, Color.blue(i4), Color.blue(i3)));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    @Override // com.bytedance.adsdk.sP.HiB.Ei
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.sP.TKC.sP.EjP sP(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (arrayList.size() == 4 && arrayList.get(0).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add(arrayList.get(1));
            arrayList.add(arrayList.get(2));
            arrayList.add(arrayList.get(3));
            this.Sj = 2;
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.Sj == -1) {
            this.Sj = arrayList.size() / 4;
        }
        int i = this.Sj;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.Sj * 4; i4++) {
            int i8 = i4 / 4;
            double floatValue = arrayList.get(i4).floatValue();
            int i9 = i4 % 4;
            if (i9 == 0) {
                if (i8 > 0) {
                    float f2 = (float) floatValue;
                    if (fArr[i8 - 1] >= f2) {
                        fArr[i8] = f2 + 0.01f;
                    }
                }
                fArr[i8] = (float) floatValue;
            } else if (i9 == 1) {
                i2 = (int) (floatValue * 255.0d);
            } else if (i9 == 2) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i9 == 3) {
                iArr[i8] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        return Sj(new com.bytedance.adsdk.sP.TKC.sP.EjP(fArr, iArr), arrayList);
    }
}

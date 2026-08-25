package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import java.util.HashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    HashMap f5741a = new HashMap();

    public float a(Object obj, String str, int i5) {
        HashMap hashMap;
        float[] fArr;
        if (this.f5741a.containsKey(obj) && (hashMap = (HashMap) this.f5741a.get(obj)) != null && hashMap.containsKey(str) && (fArr = (float[]) hashMap.get(str)) != null && fArr.length > i5) {
            return fArr[i5];
        }
        return Float.NaN;
    }

    public void b(Object obj, String str, int i5, float f5) {
        if (!this.f5741a.containsKey(obj)) {
            HashMap hashMap = new HashMap();
            float[] fArr = new float[i5 + 1];
            fArr[i5] = f5;
            hashMap.put(str, fArr);
            this.f5741a.put(obj, hashMap);
            return;
        }
        HashMap hashMap2 = (HashMap) this.f5741a.get(obj);
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
        }
        if (!hashMap2.containsKey(str)) {
            float[] fArr2 = new float[i5 + 1];
            fArr2[i5] = f5;
            hashMap2.put(str, fArr2);
            this.f5741a.put(obj, hashMap2);
            return;
        }
        float[] fArr3 = (float[]) hashMap2.get(str);
        if (fArr3 == null) {
            fArr3 = new float[0];
        }
        if (fArr3.length <= i5) {
            fArr3 = Arrays.copyOf(fArr3, i5 + 1);
        }
        fArr3[i5] = f5;
        hashMap2.put(str, fArr3);
    }
}

package com.bytedance.sdk.component.adexpress.dynamic.EjP;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class uA {
    public float Sj;
    public float sP;

    public uA(float f, float f2) {
        this.Sj = f;
        this.sP = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            uA uAVar = (uA) obj;
            if (Float.compare(uAVar.Sj, this.Sj) == 0 && Float.compare(uAVar.sP, this.sP) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.Sj), Float.valueOf(this.sP)});
    }
}

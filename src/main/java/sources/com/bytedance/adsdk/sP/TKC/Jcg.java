package com.bytedance.adsdk.sP.TKC;

import android.util.Pair;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Jcg<T> {
    T Sj;
    T sP;

    private static boolean sP(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public void Sj(T t, T t2) {
        this.Sj = t;
        this.sP = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return sP(pair.first, this.Sj) && sP(pair.second, this.sP);
    }

    public int hashCode() {
        T t = this.Sj;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.sP;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.Sj + " " + this.sP + "}";
    }
}

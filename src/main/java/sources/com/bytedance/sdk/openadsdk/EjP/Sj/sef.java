package com.bytedance.sdk.openadsdk.EjP.Sj;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sef {
    public static sef Sj = new sef();
    private volatile boolean EjP;
    private final Map<String, Sj> TKC = new HashMap();
    private Sj sP;

    public static class Sj {
        private final int Sj;
        private final int sP;

        public Sj(int i, int i2) {
            this.Sj = (i < 0 || i > 5) ? 3 : i;
            this.sP = i2 < 10 ? 30 : i2;
        }

        public int Sj() {
            return this.Sj;
        }

        public int sP() {
            return this.sP;
        }
    }

    private int TKC() {
        Sj sj = this.sP;
        if (sj != null) {
            return sj.sP();
        }
        return 30;
    }

    private int sP() {
        Sj sj = this.sP;
        if (sj != null) {
            return sj.Sj();
        }
        return 3;
    }

    public int Sj(String str) {
        if (!Sj()) {
            return 4;
        }
        Sj sj = this.TKC.get(str);
        return sj == null ? sP() : sj.Sj();
    }

    public void Sj(Sj sj) {
        this.sP = sj;
    }

    public void Sj(String str, Sj sj) {
        if (TextUtils.isEmpty(str) || sj == null) {
            return;
        }
        this.TKC.put(str, sj);
    }

    public void Sj(boolean z) {
        this.EjP = z;
    }

    public boolean Sj() {
        return this.EjP;
    }

    public int sP(String str) {
        Sj sj = this.TKC.get(str);
        return sj == null ? TKC() : sj.sP();
    }
}

package com.bytedance.sdk.openadsdk.sU;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Jcg {
    private static Sj Sj;

    public interface Sj {
    }

    public static void Sj(Sj sj) {
        Sj = sj;
    }

    public static void Sj(String str, String str2, Throwable th) {
        if (Sj != null && th == null) {
            new Throwable();
        }
    }

    public static boolean Sj() {
        return Sj != null;
    }
}

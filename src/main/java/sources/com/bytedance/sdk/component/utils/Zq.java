package com.bytedance.sdk.component.utils;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Zq {
    private static boolean Sj = false;
    private static String TKC = "";
    private static int sP = 4;

    public static boolean EjP() {
        return Sj;
    }

    public static void Sj(int i) {
        sP = i;
    }

    public static void Sj(String str) {
        TKC = str;
    }

    public static boolean Sj() {
        return sP <= 3;
    }

    public static void TKC() {
        Sj = false;
        Sj(7);
    }

    public static void sP() {
        Sj = true;
        Sj(3);
    }
}

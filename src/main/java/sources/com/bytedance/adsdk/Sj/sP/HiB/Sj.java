package com.bytedance.adsdk.Sj.sP.HiB;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    public static boolean EjP(char c) {
        return '+' == c || '-' == c || '*' == c || '/' == c || '%' == c || '=' == c || '>' == c || '<' == c || '!' == c || '&' == c || '|' == c || '?' == c || ':' == c;
    }

    public static boolean Sj(char c) {
        return c == ' ';
    }

    public static boolean TKC(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean sP(char c) {
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }
}

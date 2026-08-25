package com.bytedance.adsdk.Sj.sP.TKC.Sj;

import java.util.Deque;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class vS {
    protected char Sj(int i, String str) {
        if (i >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i);
    }

    public abstract int Sj(String str, int i, Deque<com.bytedance.adsdk.Sj.sP.sP.Sj> deque, com.bytedance.adsdk.Sj.sP.TKC.Sj sj);

    protected int sP(int i, String str) {
        while (com.bytedance.adsdk.Sj.sP.HiB.Sj.Sj(Sj(i, str))) {
            i++;
        }
        return i;
    }
}

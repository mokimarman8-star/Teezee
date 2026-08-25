package com.bytedance.adsdk.Sj.sP.EjP;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum Sj implements HiB {
    TRUE,
    FALSE,
    NULL;

    private static final Map<String, Sj> EjP = new HashMap(128);

    static {
        for (Sj sj : values()) {
            EjP.put(sj.name().toLowerCase(), sj);
        }
    }

    public static Sj Sj(String str) {
        return EjP.get(str.toLowerCase());
    }
}

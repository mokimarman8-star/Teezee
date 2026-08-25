package com.transsion.athena.data;

import com.transsion.ga.AthenaAnalytics$c;
import java.lang.ref.SoftReference;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class aethna {
    public String a;
    public SoftReference<AthenaAnalytics$c> b;

    public aethna(String str, AthenaAnalytics$c athenaAnalytics$c) {
        this.a = str;
        this.b = new SoftReference<>(athenaAnalytics$c);
    }
}

package com.bytedance.sdk.component.vS.Sj.Sj.Sj;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.sdk.component.vS.Sj.Sj.Sj.sP;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj extends sP {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Sj Sj;

    private Sj(Context context) {
        super(context);
    }

    public static Sj Sj(Context context) {
        if (Sj == null) {
            synchronized (Sj.class) {
                try {
                    if (Sj == null) {
                        Sj = new Sj(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Sj;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.Sj.sP
    public /* bridge */ /* synthetic */ sP.C0057sP Sj() {
        return super.Sj();
    }
}

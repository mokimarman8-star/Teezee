package com.bytedance.sdk.openadsdk.kF.sP;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.LD;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class vS {
    public static boolean Sj(View view, int i) {
        return Sj(view, false, i);
    }

    public static boolean Sj(View view, boolean z, int i) {
        if (view == null) {
            return false;
        }
        return LD.Sj(view, z ? 30 : 50, i);
    }
}

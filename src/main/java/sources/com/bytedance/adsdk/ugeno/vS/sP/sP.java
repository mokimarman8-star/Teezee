package com.bytedance.adsdk.ugeno.vS.sP;

import android.view.View;
import com.bytedance.adsdk.ugeno.Dq.TKC;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP implements TKC.HiB {
    @Override // com.bytedance.adsdk.ugeno.Dq.TKC.HiB
    public void Sj(View view, float f) {
        if (f < -1.0f || f > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        view.setAlpha(1.0f);
        view.setTranslationX(view.getWidth() * (-f));
        view.setTranslationY(f * view.getHeight());
    }
}

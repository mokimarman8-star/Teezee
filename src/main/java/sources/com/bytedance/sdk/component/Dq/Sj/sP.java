package com.bytedance.sdk.component.Dq.Sj;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.LqL;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP extends LqL implements TKC {
    private final HandlerThread sP;

    sP(HandlerThread handlerThread, LqL.Sj sj) {
        super(handlerThread.getLooper(), sj);
        this.sP = handlerThread;
    }

    @Override // com.bytedance.sdk.component.Dq.Sj.TKC
    public void Sj() {
        removeCallbacksAndMessages(null);
        WeakReference<LqL.Sj> weakReference = this.Sj;
        if (weakReference != null) {
            weakReference.clear();
            this.Sj = null;
        }
    }

    public void Sj(LqL.Sj sj) {
        this.Sj = new WeakReference<>(sj);
    }

    public void sP() {
        HandlerThread handlerThread = this.sP;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }
}

package com.bytedance.sdk.openadsdk.component.vS;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP implements Handler.Callback {
    private boolean Jcg;
    private Sj TKC;
    private final com.bytedance.sdk.openadsdk.component.Dq.Sj sP;
    private Handler Sj = new Handler(Looper.myLooper(), this);
    private int EjP = 0;
    private int HiB = 5;
    private int vS = 0;

    public sP(com.bytedance.sdk.openadsdk.component.Dq.Sj sj) {
        this.sP = sj;
    }

    public void EjP() {
        Handler handler = this.Sj;
        if (handler != null) {
            handler.removeMessages(100);
        }
    }

    public void HiB() {
        this.Sj.removeCallbacksAndMessages(null);
        this.Sj = null;
    }

    public int Sj() {
        return this.vS;
    }

    public void Sj(float f) {
        int i = (int) f;
        this.HiB = i;
        if (i <= 0) {
            this.HiB = 5;
        }
    }

    public void Sj(int i) {
        this.EjP = i;
        int i2 = this.HiB - i;
        this.sP.Sj(i2);
        boolean z = true;
        if (i <= 0) {
            Sj sj = this.TKC;
            if (sj != null && !this.Jcg) {
                sj.sP();
                this.Jcg = true;
            }
            i = 0;
        }
        Sj sj2 = this.TKC;
        if (sj2 != null) {
            int i3 = this.vS;
            int i4 = i3 - i2;
            if (i != 0 && i2 < i3) {
                z = false;
            }
            sj2.Sj(i4, z);
        }
    }

    public void Sj(Sj sj) {
        this.TKC = sj;
    }

    public void TKC() {
        if (this.Sj != null) {
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.arg1 = this.EjP;
            this.Sj.sendMessage(obtain);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 100 && this.Sj != null) {
            int i = message.arg1;
            Sj(i);
            if (i > 0) {
                Message obtain = Message.obtain();
                obtain.what = 100;
                obtain.arg1 = i - 1;
                this.Sj.sendMessageDelayed(obtain, 1000L);
            }
        }
        return true;
    }

    public void sP() {
        Handler handler = this.Sj;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(100, this.HiB, 0));
        }
    }

    public void sP(int i) {
        this.vS = Math.min(i, this.HiB);
    }
}

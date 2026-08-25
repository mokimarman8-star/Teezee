package com.transsion.shorttv_pugc.base.widget.toast.core;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c extends Handler {
    private final Handler a;

    public c(Handler mHandler) {
        Intrinsics.h(mHandler, "mHandler");
        this.a = mHandler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Intrinsics.h(msg, "msg");
        try {
            this.a.handleMessage(msg);
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }
}

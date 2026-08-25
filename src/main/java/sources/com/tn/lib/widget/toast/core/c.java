package com.tn.lib.widget.toast.core;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c extends Handler {
    private final Handler a;

    public c(Handler handler) {
        Intrinsics.h(handler, "mHandler");
        this.a = handler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Intrinsics.h(message, "msg");
        try {
            this.a.handleMessage(message);
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }
}

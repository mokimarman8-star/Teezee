package com.blankj.utilcode.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class KeyboardUtils$1 extends ResultReceiver {
    KeyboardUtils$1(Handler handler) {
        super(handler);
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i, Bundle bundle) {
        if (i == 1 || i == 3) {
            KeyboardUtils.k();
        }
    }
}

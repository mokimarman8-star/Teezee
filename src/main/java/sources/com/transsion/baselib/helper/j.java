package com.transsion.baselib.helper;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j extends ContentObserver {
    private final WeakReference a;
    private final Function1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Handler handler, WeakReference weakReference, Function1 function1) {
        super(handler);
        Intrinsics.h(weakReference, "contextWeak");
        Intrinsics.h(function1, "callback");
        this.a = weakReference;
        this.b = function1;
    }

    public final boolean a(Context context) {
        Intrinsics.h(context, "context");
        try {
            return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation") == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            Log.e("ScreenRotationObserver", "Setting not found: " + e.getMessage());
            return false;
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        Context context = (Context) this.a.get();
        boolean a = context != null ? a(context) : false;
        StringBuilder sb = new StringBuilder();
        sb.append("Auto-rotate is now isAutoRotateEnabled：");
        sb.append(a);
        this.b.invoke(Boolean.valueOf(a));
    }
}

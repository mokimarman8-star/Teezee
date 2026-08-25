package com.transsion.baselib.locale;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/transsion/baselib/locale/LocaleChangedHelper$registerLocalChangeReceiver$2", "Landroid/content/BroadcastReceiver;", "onReceive", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LocaleChangedHelper$registerLocalChangeReceiver$2 extends BroadcastReceiver {
    LocaleChangedHelper$registerLocalChangeReceiver$2() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.h(context, "context");
        Intrinsics.h(intent, "intent");
        d.f.e().n(intent.getStringExtra("key.string.language"));
    }
}

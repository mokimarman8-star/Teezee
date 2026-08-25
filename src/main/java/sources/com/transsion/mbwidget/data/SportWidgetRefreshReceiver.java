package com.transsion.mbwidget.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/transsion/mbwidget/data/SportWidgetRefreshReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", BuildConfig.FLAVOR, "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SportWidgetRefreshReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.h(context, "context");
        Intrinsics.h(intent, "intent");
        if (Intrinsics.c("com.transsion.mbwidget.ACTION_MATCH_REFRESH", intent.getAction())) {
            BroadcastReceiver.PendingResult goAsync = goAsync();
            kotlinx.coroutines.i.d(o0.a(y0.b().plus(l2.b((t1) null, 1, (Object) null))), (CoroutineContext) null, (CoroutineStart) null, new SportWidgetRefreshReceiver$onReceive$1(context.getApplicationContext(), goAsync, null), 3, (Object) null);
        }
    }
}

package com.transsion.mbwidget.guide;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.transsion.core.utils.ToastUtil;
import com.transsion.gslb.BuildConfig;
import com.transsion.mbwidget.R$string;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/transsion/mbwidget/guide/WidgetCallbackReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", BuildConfig.FLAVOR, "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class WidgetCallbackReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final w0 b = c1.b(0, 0, (BufferOverflow) null, 7, (Object) null);

    /* renamed from: com.transsion.mbwidget.guide.WidgetCallbackReceiver$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final w0 a() {
            return WidgetCallbackReceiver.b;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.h(context, "context");
        Intrinsics.h(intent, "intent");
        ToastUtil.e(R$string.widget_succeeded);
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new WidgetCallbackReceiver$onReceive$1(null), 3, (Object) null);
    }
}

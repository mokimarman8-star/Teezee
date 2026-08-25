package androidx.activity;

import android.app.Activity;
import android.window.OnBackInvokedDispatcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ComponentActivity$b {

    /* renamed from: a, reason: collision with root package name */
    public static final ComponentActivity$b f74a = new ComponentActivity$b();

    private ComponentActivity$b() {
    }

    public final OnBackInvokedDispatcher a(Activity activity) {
        Intrinsics.h(activity, "activity");
        OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        Intrinsics.g(onBackInvokedDispatcher, "activity.getOnBackInvokedDispatcher()");
        return onBackInvokedDispatcher;
    }
}

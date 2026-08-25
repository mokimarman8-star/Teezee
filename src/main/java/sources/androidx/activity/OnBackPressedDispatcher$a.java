package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class OnBackPressedDispatcher$a {

    /* renamed from: a, reason: collision with root package name */
    public static final OnBackPressedDispatcher$a f85a = new OnBackPressedDispatcher$a();

    private OnBackPressedDispatcher$a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function0 function0) {
        function0.invoke();
    }

    public final OnBackInvokedCallback b(final Function0 function0) {
        Intrinsics.h(function0, "onBackInvoked");
        return new OnBackInvokedCallback() { // from class: androidx.activity.v
            @Override // android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                OnBackPressedDispatcher$a.c(function0);
            }
        };
    }

    public final void d(Object obj, int i5, Object obj2) {
        Intrinsics.h(obj, "dispatcher");
        Intrinsics.h(obj2, "callback");
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i5, (OnBackInvokedCallback) obj2);
    }

    public final void e(Object obj, Object obj2) {
        Intrinsics.h(obj, "dispatcher");
        Intrinsics.h(obj2, "callback");
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}

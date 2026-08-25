package androidx.compose.ui.window;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.media3.common.PlaybackException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f5553a = new b();

    private b() {
    }

    @JvmStatic
    public static final OnBackInvokedCallback b(final Function0<Unit> function0) {
        return new OnBackInvokedCallback() { // from class: androidx.compose.ui.window.a
            @Override // android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                b.c(function0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    @JvmStatic
    public static final void d(View view, Object obj) {
        OnBackInvokedDispatcher findOnBackInvokedDispatcher;
        if (!(obj instanceof OnBackInvokedCallback) || (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
            return;
        }
        findOnBackInvokedDispatcher.registerOnBackInvokedCallback(PlaybackException.CUSTOM_ERROR_CODE_BASE, (OnBackInvokedCallback) obj);
    }

    @JvmStatic
    public static final void e(View view, Object obj) {
        OnBackInvokedDispatcher findOnBackInvokedDispatcher;
        if (!(obj instanceof OnBackInvokedCallback) || (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
            return;
        }
        findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj);
    }
}

package androidx.appcompat.app;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.media3.common.PlaybackException;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class AppCompatDelegateImpl$k {
    static OnBackInvokedDispatcher a(Activity activity) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        return onBackInvokedDispatcher;
    }

    static OnBackInvokedCallback b(Object obj, final AppCompatDelegateImpl appCompatDelegateImpl) {
        Objects.requireNonNull(appCompatDelegateImpl);
        OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.u
            @Override // android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                appCompatDelegateImpl.G0();
            }
        };
        q.a(obj).registerOnBackInvokedCallback(PlaybackException.CUSTOM_ERROR_CODE_BASE, onBackInvokedCallback);
        return onBackInvokedCallback;
    }

    static void c(Object obj, Object obj2) {
        q.a(obj).unregisterOnBackInvokedCallback(p.a(obj2));
    }
}

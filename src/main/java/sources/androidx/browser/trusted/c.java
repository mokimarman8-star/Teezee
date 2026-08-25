package androidx.browser.trusted;

import android.os.IBinder;
import d.a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final d.a f1212a;

    private c(d.a aVar) {
        this.f1212a = aVar;
    }

    static c a(IBinder iBinder) {
        d.a X0 = iBinder == null ? null : a.AbstractBinderC0130a.X0(iBinder);
        if (X0 == null) {
            return null;
        }
        return new c(X0);
    }
}

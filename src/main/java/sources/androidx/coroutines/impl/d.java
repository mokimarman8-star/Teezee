package androidx.coroutines.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.h;
import androidx.coroutines.InterfaceC0218o;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class d implements InterfaceC0218o {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f14014a = h.a(Looper.getMainLooper());

    @Override // androidx.coroutines.InterfaceC0218o
    public void a(Runnable runnable) {
        this.f14014a.removeCallbacks(runnable);
    }

    @Override // androidx.coroutines.InterfaceC0218o
    public void b(long j5, Runnable runnable) {
        this.f14014a.postDelayed(runnable, j5);
    }
}

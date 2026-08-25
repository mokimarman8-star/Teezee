package androidx.datastore.preferences.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f7509a;

    public b(boolean z5) {
        this.f7509a = new AtomicBoolean(z5);
    }

    public final boolean a() {
        return this.f7509a.get();
    }

    public final void b(boolean z5) {
        this.f7509a.set(z5);
    }
}

package androidx.core.util;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class h extends g {

    /* renamed from: c, reason: collision with root package name */
    private final Object f7128c;

    public h(int i5) {
        super(i5);
        this.f7128c = new Object();
    }

    @Override // androidx.core.util.g, androidx.core.util.f
    public Object acquire() {
        Object acquire;
        synchronized (this.f7128c) {
            acquire = super.acquire();
        }
        return acquire;
    }

    @Override // androidx.core.util.g, androidx.core.util.f
    public boolean release(Object obj) {
        boolean release;
        Intrinsics.h(obj, "instance");
        synchronized (this.f7128c) {
            release = super.release(obj);
        }
        return release;
    }
}

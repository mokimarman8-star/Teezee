package androidx.datastore.flow;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class r extends v {

    /* renamed from: b, reason: collision with root package name */
    private final Throwable f7482b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Throwable th, int i5) {
        super(i5, null);
        Intrinsics.h(th, "readException");
        this.f7482b = th;
    }

    public final Throwable b() {
        return this.f7482b;
    }
}

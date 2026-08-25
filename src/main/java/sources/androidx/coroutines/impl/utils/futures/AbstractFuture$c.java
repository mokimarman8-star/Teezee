package androidx.coroutines.impl.utils.futures;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AbstractFuture$c {

    /* renamed from: c, reason: collision with root package name */
    static final AbstractFuture$c f14095c;

    /* renamed from: d, reason: collision with root package name */
    static final AbstractFuture$c f14096d;

    /* renamed from: a, reason: collision with root package name */
    final boolean f14097a;

    /* renamed from: b, reason: collision with root package name */
    final Throwable f14098b;

    static {
        if (AbstractFuture.d) {
            f14096d = null;
            f14095c = null;
        } else {
            f14096d = new AbstractFuture$c(false, null);
            f14095c = new AbstractFuture$c(true, null);
        }
    }

    AbstractFuture$c(boolean z5, Throwable th) {
        this.f14097a = z5;
        this.f14098b = th;
    }
}

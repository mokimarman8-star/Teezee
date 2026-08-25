package androidx.coroutines;

import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class u0 extends InvalidationTracker$b {

    /* renamed from: b, reason: collision with root package name */
    private final InvalidationTracker f13300b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakReference f13301c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(InvalidationTracker invalidationTracker, InvalidationTracker$b invalidationTracker$b) {
        super(invalidationTracker$b.a());
        Intrinsics.h(invalidationTracker, "tracker");
        Intrinsics.h(invalidationTracker$b, "delegate");
        this.f13300b = invalidationTracker;
        this.f13301c = new WeakReference(invalidationTracker$b);
    }

    @Override // androidx.coroutines.InvalidationTracker$b
    public void c(Set set) {
        Intrinsics.h(set, "tables");
        InvalidationTracker$b invalidationTracker$b = (InvalidationTracker$b) this.f13301c.get();
        if (invalidationTracker$b == null) {
            this.f13300b.y(this);
        } else {
            invalidationTracker$b.c(set);
        }
    }
}

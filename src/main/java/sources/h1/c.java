package h1;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f15462a = new ArrayList();

    public final void a(b bVar) {
        Intrinsics.h(bVar, "listener");
        this.f15462a.add(bVar);
    }

    public final void b() {
        for (int n5 = CollectionsKt.n(this.f15462a); -1 < n5; n5--) {
            ((b) this.f15462a.get(n5)).onRelease();
        }
    }

    public final void c(b bVar) {
        Intrinsics.h(bVar, "listener");
        this.f15462a.remove(bVar);
    }
}

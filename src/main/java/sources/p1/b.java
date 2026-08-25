package p1;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p1.a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b extends a {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b() {
        this(r0, 1, r0);
        a aVar = null;
    }

    public b(a aVar) {
        Intrinsics.h(aVar, "initialExtras");
        b().putAll(aVar.b());
    }

    public /* synthetic */ b(a aVar, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? a.C0164a.f16868b : aVar);
    }

    @Override // p1.a
    public Object a(a.b bVar) {
        Intrinsics.h(bVar, "key");
        return b().get(bVar);
    }

    public final void c(a.b bVar, Object obj) {
        Intrinsics.h(bVar, "key");
        b().put(bVar, obj);
    }
}

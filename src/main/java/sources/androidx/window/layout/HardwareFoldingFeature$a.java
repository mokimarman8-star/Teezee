package androidx.window.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class HardwareFoldingFeature$a {
    private HardwareFoldingFeature$a() {
    }

    public /* synthetic */ HardwareFoldingFeature$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void a(androidx.window.core.b bVar) {
        Intrinsics.h(bVar, "bounds");
        if (bVar.d() == 0 && bVar.a() == 0) {
            throw new IllegalArgumentException("Bounds must be non zero");
        }
        if (bVar.b() != 0 && bVar.c() != 0) {
            throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
        }
    }
}

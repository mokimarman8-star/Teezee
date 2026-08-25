package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class JsonElementMarker {
    private final kotlinx.serialization.internal.e0 a;
    private boolean b;

    public JsonElementMarker(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        this.a = new kotlinx.serialization.internal.e0(descriptor, new JsonElementMarker$origin$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(kotlinx.serialization.descriptors.f fVar, int i) {
        boolean z = !fVar.j(i) && fVar.h(i).b();
        this.b = z;
        return z;
    }

    public final boolean b() {
        return this.b;
    }

    public final void c(int i) {
        this.a.a(i);
    }

    public final int d() {
        return this.a.d();
    }
}

package androidx.datastore.flow;

import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class k extends v {

    /* renamed from: b, reason: collision with root package name */
    private final Throwable f7473b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Throwable th) {
        super(DescriptorProtos$Edition.EDITION_MAX_VALUE, null);
        Intrinsics.h(th, "finalException");
        this.f7473b = th;
    }

    public final Throwable b() {
        return this.f7473b;
    }
}

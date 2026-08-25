package androidx.datastore.flow;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class n {
    public static final m a(String str) {
        Intrinsics.h(str, "filePath");
        return new SingleProcessCoordinator(str);
    }
}

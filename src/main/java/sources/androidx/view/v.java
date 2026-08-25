package androidx.view;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class v {
    public static final LifecycleCoroutineScope a(u uVar) {
        Intrinsics.h(uVar, "<this>");
        return s.a(uVar.getLifecycle());
    }
}

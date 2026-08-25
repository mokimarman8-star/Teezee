package androidx.navigation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class n {
    public static final l a(Function1 function1) {
        Intrinsics.h(function1, "optionsBuilder");
        m mVar = new m();
        function1.invoke(mVar);
        return mVar.b();
    }
}

package androidx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import y3.e;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class r0 {
    public static final Object b(r rVar, String str, Continuation continuation) {
        Object d5 = rVar.d(str, new Function1() { // from class: androidx.room.q0
            public final Object invoke(Object obj) {
                boolean c5;
                c5 = r0.c((e) obj);
                return Boolean.valueOf(c5);
            }
        }, continuation);
        return d5 == IntrinsicsKt.f() ? d5 : Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(e eVar) {
        Intrinsics.h(eVar, "it");
        return eVar.C0();
    }
}

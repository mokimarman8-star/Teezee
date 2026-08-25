package com.transsion.baselib.config;

import ad.j;
import ad.n;
import com.google.android.gms.tasks.Task;
import com.google.firebase.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class e {
    public static final a c = new a((DefaultConstructorMarker) null);
    private static final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.baselib.config.b
        public final Object invoke() {
            e h;
            h = e.h();
            return h;
        }
    });
    private com.google.firebase.remoteconfig.a a;
    private boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(j.b bVar) {
        Intrinsics.h(bVar, "$this$remoteConfigSettings");
        bVar.e(3600L);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e eVar, Function2 function2, Task task) {
        Intrinsics.h(task, "task");
        boolean isSuccessful = task.isSuccessful();
        eVar.b = isSuccessful;
        Boolean valueOf = Boolean.valueOf(isSuccessful);
        com.google.firebase.remoteconfig.a aVar = eVar.a;
        if (aVar == null) {
            Intrinsics.y("remoteConfig");
            aVar = null;
        }
        function2.invoke(valueOf, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e h() {
        return new e();
    }

    public final void e(Function2 function2) {
        Intrinsics.h(function2, "callback");
        com.google.firebase.remoteconfig.a a = n.a(c.a);
        this.a = a;
        com.google.firebase.remoteconfig.a aVar = null;
        if (a == null) {
            Intrinsics.y("remoteConfig");
            a = null;
        }
        a.w(n.b(new c()));
        com.google.firebase.remoteconfig.a aVar2 = this.a;
        if (aVar2 == null) {
            Intrinsics.y("remoteConfig");
        } else {
            aVar = aVar2;
        }
        aVar.h().addOnCompleteListener(new d(this, function2));
    }
}

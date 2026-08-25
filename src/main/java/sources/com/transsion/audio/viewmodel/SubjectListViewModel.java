package com.transsion.audio.viewmodel;

import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubjectListViewModel extends t0 {
    public static final a c = new a(null);
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.audio.viewmodel.f
        public final Object invoke() {
            cx.a j;
            j = SubjectListViewModel.j();
            return j;
        }
    });
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.audio.viewmodel.g
        public final Object invoke() {
            b0 e;
            e = SubjectListViewModel.e();
            return e;
        }
    });

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 e() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final cx.a i() {
        return (cx.a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cx.a j() {
        return (cx.a) kg.c.e.a().h(cx.a.class);
    }

    public final b0 f() {
        return (b0) this.b.getValue();
    }

    public final void g(boolean z, String str, String str2, int i, int i2, int i3, int i4) {
        Intrinsics.h(str2, "nextPage");
        i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new SubjectListViewModel$getDownloadList$1(this, str, str2, i, i2, i3, i4, z, null), 3, (Object) null);
    }
}

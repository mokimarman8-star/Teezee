package com.transsion.postdetail.viewmodel;

import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostDetailCommentsFragmentViewModel extends t0 {
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.c
        public final Object invoke() {
            ao.a d;
            d = PostDetailCommentsFragmentViewModel.d();
            return d;
        }
    });
    private final b0 b = new b0();

    /* JADX INFO: Access modifiers changed from: private */
    public static final ao.a d() {
        return (ao.a) kg.c.e.a().h(ao.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ao.a f() {
        return (ao.a) this.a.getValue();
    }

    public final void e(String str, String str2, String str3, int i) {
        Intrinsics.h(str, "postId");
        Intrinsics.h(str2, "rootCommentId");
        Intrinsics.h(str3, "page");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new PostDetailCommentsFragmentViewModel$getCommentList$1(this, str, str2, str3, i, null), 3, (Object) null);
    }

    public final b0 g() {
        return this.b;
    }
}

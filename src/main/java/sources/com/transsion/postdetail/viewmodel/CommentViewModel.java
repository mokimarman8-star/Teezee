package com.transsion.postdetail.viewmodel;

import android.app.Application;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsion.postdetail.bean.CommentBody;
import com.transsion.postdetail.bean.CommentLikeBody;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CommentViewModel extends androidx.lifecycle.b {
    public static final a i = new a(null);
    private final b0 b;
    private final b0 c;
    private final b0 d;
    private final b0 e;
    private final b0 f;
    private final b0 g;
    private final Lazy h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = new b0();
        this.c = new b0();
        this.d = new b0();
        this.e = new b0();
        this.f = new b0();
        this.g = new b0();
        this.h = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.a
            public final Object invoke() {
                ao.a f;
                f = CommentViewModel.f();
                return f;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ao.a f() {
        return (ao.a) kg.c.e.a().h(ao.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ao.a i() {
        return (ao.a) this.h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String str) {
        a.a.f(wf.a.a, "CommentViewModel", str, false, 4, (Object) null);
    }

    public final void g(String str, String str2) {
        Intrinsics.h(str, "topicType");
        Intrinsics.h(str2, "commentId");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new CommentViewModel$deleteComment$1(str, this, str2, null), 3, (Object) null);
    }

    public final void h(String str, String str2, String str3, String str4, int i2, String str5) {
        Intrinsics.h(str, "postId");
        Intrinsics.h(str2, "topicType");
        Intrinsics.h(str3, "rootCommentId");
        Intrinsics.h(str4, "page");
        Intrinsics.h(str5, "locCommentId");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new CommentViewModel$getCommentList$1(this, str, str2, str3, str4, str5, i2, null), 3, (Object) null);
    }

    public final b0 j() {
        return this.f;
    }

    public final b0 k() {
        return this.c;
    }

    public final b0 l() {
        return this.d;
    }

    public final b0 m() {
        return this.e;
    }

    public final b0 n() {
        return this.b;
    }

    public final b0 o() {
        return this.g;
    }

    public final void p(un.a aVar, String str, String str2, int i2) {
        Intrinsics.h(aVar, "info");
        Intrinsics.h(str, "topicType");
        Intrinsics.h(str2, "page");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new CommentViewModel$getSubCommentList$1(this, aVar, str, str2, i2, null), 3, (Object) null);
    }

    public final void q(CommentLikeBody commentLikeBody) {
        Intrinsics.h(commentLikeBody, "commentBody");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new CommentViewModel$likeComment$1(commentLikeBody, this, null), 3, (Object) null);
    }

    public final void s(String str, CommentBody commentBody) {
        Intrinsics.h(str, "topicType");
        Intrinsics.h(commentBody, "commentBody");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new CommentViewModel$postComment$1(commentBody, str, this, null), 3, (Object) null);
    }

    public final void t(String str) {
        Intrinsics.h(str, "commentId");
        this.g.q(str);
    }
}

package com.transsion.postdetail.comment.ui;

import android.app.Application;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsion.push.bean.MsgStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CommentListViewModel extends androidx.lifecycle.b {
    private final Lazy b;
    private final b0 c;
    private final List d;
    private String e;
    private int f;
    private boolean g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentListViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.comment.ui.c
            public final Object invoke() {
                ao.a j;
                j = CommentListViewModel.j();
                return j;
            }
        });
        this.c = new b0();
        this.d = new ArrayList();
        this.e = MsgStyle.CUSTOM_LEFT_PIC;
        this.f = 20;
        this.g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ao.a j() {
        return (ao.a) kg.c.e.a().h(ao.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ao.a l() {
        return (ao.a) this.b.getValue();
    }

    public final void k(boolean z) {
        if (z) {
            this.e = MsgStyle.CUSTOM_LEFT_PIC;
            this.d.clear();
            this.g = true;
        }
        i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new CommentListViewModel$getCommentList$1(this, null), 3, (Object) null);
    }

    public final b0 m() {
        return this.c;
    }

    public final boolean n() {
        return this.g;
    }
}

package com.cloud.tmc.miniapp.ui;

import android.view.View;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;

@DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniH5Fragment$hideCustomView$1", f = "MiniH5Fragment.kt", l = {738, 739}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class MiniH5Fragment$hideCustomView$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ MiniH5Fragment this$0;

    @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniH5Fragment$hideCustomView$1$1", f = "MiniH5Fragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.cloud.tmc.miniapp.ui.MiniH5Fragment$hideCustomView$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        public int label;
        public final /* synthetic */ MiniH5Fragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MiniH5Fragment miniH5Fragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = miniH5Fragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            View view;
            View view2;
            int i;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            view = this.this$0.contextView;
            if (view == null) {
                Intrinsics.y("contextView");
            }
            view2 = this.this$0.contextView;
            if (view2 == null) {
                Intrinsics.y("contextView");
                view2 = null;
            }
            i = this.this$0.mScrollY;
            view2.scrollTo(0, i);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniH5Fragment$hideCustomView$1(MiniH5Fragment miniH5Fragment, Continuation<? super MiniH5Fragment$hideCustomView$1> continuation) {
        super(2, continuation);
        this.this$0 = miniH5Fragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniH5Fragment$hideCustomView$1(this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            this.label = 1;
            if (kotlinx.coroutines.u0.a(500L, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        a2 c = kotlinx.coroutines.y0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (kotlinx.coroutines.i.g(c, anonymousClass1, this) == f) {
            return f;
        }
        return Unit.a;
    }
}

package com.transsion.search_pugc.fragment;

import com.transsion.gslb.BuildConfig;
import com.transsion.search_pugc.k;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.search_pugc.fragment.SearchSubjectFragment$initView$3", f = "SearchSubjectFragment.kt", l = {119}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SearchSubjectFragment$initView$3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    static final class a implements kotlinx.coroutines.flow.b {
        public static final a a = new a();

        a() {
        }

        public final Object a(k.a aVar, Continuation continuation) {
            throw new NoWhenBranchMatchedException();
        }

        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            android.support.v4.media.session.c.a(obj);
            return a(null, continuation);
        }
    }

    SearchSubjectFragment$initView$3(Continuation<? super SearchSubjectFragment$initView$3> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchSubjectFragment$initView$3(continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            w0 a2 = com.transsion.search_pugc.k.a.a();
            a aVar = a.a;
            this.label = 1;
            if (a2.a(aVar, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}

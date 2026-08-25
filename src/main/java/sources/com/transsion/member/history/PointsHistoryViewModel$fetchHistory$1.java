package com.transsion.member.history;

import com.transsion.gslb.BuildConfig;
import com.transsion.member.bean.PointsHistoryData;
import com.transsion.member.bean.PointsHistoryItem;
import fm.a;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import yx.h;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.member.history.PointsHistoryViewModel$fetchHistory$1", f = "PointsHistoryViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PointsHistoryViewModel$fetchHistory$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $page;
    int label;
    final /* synthetic */ PointsHistoryViewModel this$0;

    static final class a implements h {
        public static final a a = new a();

        a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m apply(Throwable th2) {
            Intrinsics.h(th2, "it");
            return j.l(th2);
        }
    }

    public static final class b extends dg.a {
        final /* synthetic */ PointsHistoryViewModel d;

        b(PointsHistoryViewModel pointsHistoryViewModel) {
            this.d = pointsHistoryViewModel;
        }

        public void a(String str, String str2) {
            StringBuilder sb = new StringBuilder();
            sb.append("error: ");
            sb.append(str);
            sb.append(", msg:");
            sb.append(str2);
            this.d.e().q((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(PointsHistoryData pointsHistoryData) {
            List<PointsHistoryItem> list;
            super.c(pointsHistoryData);
            Boolean valueOf = (pointsHistoryData == null || (list = pointsHistoryData.getList()) == null) ? null : Boolean.valueOf(list.isEmpty());
            StringBuilder sb = new StringBuilder();
            sb.append("list is empty: ");
            sb.append(valueOf);
            this.d.e().q(pointsHistoryData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PointsHistoryViewModel$fetchHistory$1(PointsHistoryViewModel pointsHistoryViewModel, String str, Continuation<? super PointsHistoryViewModel$fetchHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = pointsHistoryViewModel;
        this.$page = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PointsHistoryViewModel$fetchHistory$1(this.this$0, this.$page, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        fm.a f;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        f = this.this$0.f();
        a.C0069a.g(f, this.$page, 0, null, 6, null).v(ey.a.c()).x(a.a).f(dg.d.a.c()).subscribe(new b(this.this$0));
        return Unit.a;
    }
}

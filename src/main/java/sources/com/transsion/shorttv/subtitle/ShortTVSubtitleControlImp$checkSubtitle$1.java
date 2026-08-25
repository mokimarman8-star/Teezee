package com.transsion.shorttv.subtitle;

import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.ShortTvInnerPlayBean;
import com.transsion.shorttv.subtitle.manager.b;
import com.transsion.shorttv.viewmodel.ShortTvViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import nr.e;
import ur.h;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$checkSubtitle$1", f = "ShortTVSubtitleControlImp.kt", l = {177, 179, 184}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTVSubtitleControlImp$checkSubtitle$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ShortTVSubtitleControlImp this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$checkSubtitle$1$1", f = "ShortTVSubtitleControlImp.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$checkSubtitle$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ ShortTvInnerPlayBean $history;
        final /* synthetic */ List<xr.b> $list;
        int label;
        final /* synthetic */ ShortTVSubtitleControlImp this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<xr.b> list, ShortTVSubtitleControlImp shortTVSubtitleControlImp, ShortTvInnerPlayBean shortTvInnerPlayBean, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$list = list;
            this.this$0 = shortTVSubtitleControlImp;
            this.$history = shortTvInnerPlayBean;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$list, this.this$0, this.$history, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            e eVar;
            e eVar2;
            e eVar3;
            e eVar4;
            e eVar5;
            e eVar6;
            String str;
            as.a aVar;
            as.a aVar2;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            List<xr.b> list = this.$list;
            if (list != null && !list.isEmpty()) {
                aVar = this.this$0.h;
                List list2 = (List) aVar.d().f();
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.clear();
                list2.addAll(this.$list);
                a.a.g(wf.a.a, "checkSubtitle setList, size:" + list2.size(), false, 2, (Object) null);
                aVar2 = this.this$0.h;
                aVar2.d().q(list2);
                ShortTVSubtitleControlImp shortTVSubtitleControlImp = this.this$0;
                ShortTvInnerPlayBean shortTvInnerPlayBean = this.$history;
                shortTVSubtitleControlImp.y(list2, shortTvInnerPlayBean != null ? shortTvInnerPlayBean.getSubtitleSelectId() : null);
            }
            if (l.a.e()) {
                eVar = this.this$0.e;
                String e = eVar.e();
                eVar2 = this.this$0.e;
                String e2 = eVar2.e();
                eVar3 = this.this$0.e;
                String str2 = e2 + "_" + eVar3.c() + "short";
                eVar4 = this.this$0.e;
                ShortTVItem d = eVar4.d();
                String id = d != null ? d.getId() : null;
                eVar5 = this.this$0.e;
                int c = eVar5.c();
                eVar6 = this.this$0.e;
                ShortTVItem d2 = eVar6.d();
                int se = d2 != null ? d2.getSe() : 0;
                str = this.this$0.f;
                b.C0064b.a(com.transsion.shorttv.subtitle.manager.b.a.b(), new xr.a(e, str2, BuildConfig.FLAVOR, BuildConfig.FLAVOR, id, c, se, str), null, 2, null);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTVSubtitleControlImp$checkSubtitle$1(ShortTVSubtitleControlImp shortTVSubtitleControlImp, Continuation<? super ShortTVSubtitleControlImp$checkSubtitle$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTVSubtitleControlImp;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVSubtitleControlImp$checkSubtitle$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ShortTvViewModel shortTvViewModel;
        ShortTvInnerPlayBean shortTvInnerPlayBean;
        h A0;
        e eVar;
        e eVar2;
        List list;
        e eVar3;
        e eVar4;
        a2 c;
        AnonymousClass1 anonymousClass1;
        Function1 function1;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            shortTvViewModel = this.this$0.d;
            if (shortTvViewModel == null || (A0 = shortTvViewModel.A0()) == null) {
                shortTvInnerPlayBean = null;
                com.transsion.shorttv.subtitle.manager.b b = com.transsion.shorttv.subtitle.manager.b.a.b();
                eVar2 = this.this$0.e;
                String f2 = eVar2.f();
                this.L$0 = shortTvInnerPlayBean;
                this.label = 2;
                obj = b.a(f2, this);
                if (obj == f) {
                    return f;
                }
                List list2 = (List) obj;
                list = list2;
                if (list != null) {
                    function1 = this.this$0.i;
                    function1.invoke(Boxing.a(true));
                }
                a.a aVar = wf.a.a;
                eVar3 = this.this$0.e;
                String f3 = eVar3.f();
                eVar4 = this.this$0.e;
                if (list2 != null) {
                }
                a.a.g(aVar, "checkSubtitle subtitleResId:" + f3 + ", subjectId:" + eVar4.e() + ", size:" + (list2 != null ? Boxing.d(list2.size()) : null), false, 2, (Object) null);
                c = y0.c();
                anonymousClass1 = new AnonymousClass1(list2, this.this$0, shortTvInnerPlayBean, null);
                this.L$0 = null;
                this.label = 3;
                if (i.g(c, anonymousClass1, this) == f) {
                }
                return Unit.a;
            }
            eVar = this.this$0.e;
            String e = eVar.e();
            this.label = 1;
            obj = A0.c(e, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                shortTvInnerPlayBean = (ShortTvInnerPlayBean) this.L$0;
                ResultKt.b(obj);
                List list22 = (List) obj;
                list = list22;
                if (list != null && !list.isEmpty() && function1 != null) {
                    function1.invoke(Boxing.a(true));
                }
                a.a aVar2 = wf.a.a;
                eVar3 = this.this$0.e;
                String f32 = eVar3.f();
                eVar4 = this.this$0.e;
                a.a.g(aVar2, "checkSubtitle subtitleResId:" + f32 + ", subjectId:" + eVar4.e() + ", size:" + (list22 != null ? Boxing.d(list22.size()) : null), false, 2, (Object) null);
                c = y0.c();
                anonymousClass1 = new AnonymousClass1(list22, this.this$0, shortTvInnerPlayBean, null);
                this.L$0 = null;
                this.label = 3;
                if (i.g(c, anonymousClass1, this) == f) {
                    return f;
                }
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        shortTvInnerPlayBean = (ShortTvInnerPlayBean) obj;
        com.transsion.shorttv.subtitle.manager.b b2 = com.transsion.shorttv.subtitle.manager.b.a.b();
        eVar2 = this.this$0.e;
        String f22 = eVar2.f();
        this.L$0 = shortTvInnerPlayBean;
        this.label = 2;
        obj = b2.a(f22, this);
        if (obj == f) {
        }
        List list222 = (List) obj;
        list = list222;
        if (list != null) {
        }
        a.a aVar22 = wf.a.a;
        eVar3 = this.this$0.e;
        String f322 = eVar3.f();
        eVar4 = this.this$0.e;
        if (list222 != null) {
        }
        a.a.g(aVar22, "checkSubtitle subtitleResId:" + f322 + ", subjectId:" + eVar4.e() + ", size:" + (list222 != null ? Boxing.d(list222.size()) : null), false, 2, (Object) null);
        c = y0.c();
        anonymousClass1 = new AnonymousClass1(list222, this.this$0, shortTvInnerPlayBean, null);
        this.L$0 = null;
        this.label = 3;
        if (i.g(c, anonymousClass1, this) == f) {
        }
        return Unit.a;
    }
}

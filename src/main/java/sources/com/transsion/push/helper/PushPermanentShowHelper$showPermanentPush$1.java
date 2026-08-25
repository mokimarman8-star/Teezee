package com.transsion.push.helper;

import android.content.Context;
import android.graphics.Bitmap;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.PermanentItemBean;
import com.transsion.push.bean.PushConfigHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.helper.PushPermanentShowHelper$showPermanentPush$1", f = "PushPermanentShowHelper.kt", l = {353, 369}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PushPermanentShowHelper$showPermanentPush$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<PermanentItemBean> $msgList;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushPermanentShowHelper$showPermanentPush$1(List<PermanentItemBean> list, Context context, Continuation<? super PushPermanentShowHelper$showPermanentPush$1> continuation) {
        super(2, continuation);
        this.$msgList = list;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PushPermanentShowHelper$showPermanentPush$1 pushPermanentShowHelper$showPermanentPush$1 = new PushPermanentShowHelper$showPermanentPush$1(this.$msgList, this.$context, continuation);
        pushPermanentShowHelper$showPermanentPush$1.L$0 = obj;
        return pushPermanentShowHelper$showPermanentPush$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x019d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Throwable th2;
        Object a;
        List list;
        List<PermanentItemBean> list2;
        int i;
        List list3;
        Context context;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        Continuation continuation = null;
        try {
        } catch (Throwable th3) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th3));
        }
        if (i2 == 0) {
            ResultKt.b(obj);
            n0 n0Var = (n0) this.L$0;
            List<PermanentItemBean> list4 = this.$msgList;
            Context context2 = this.$context;
            Result.Companion companion2 = Result.Companion;
            int curAbType = PushConfigHelper.INSTANCE.getCurAbType();
            List synchronizedList = Collections.synchronizedList(new ArrayList());
            List synchronizedList2 = Collections.synchronizedList(new ArrayList());
            int h = curAbType != 1 ? curAbType != 2 ? 1 : RangesKt.h(list4.size(), 4) : RangesKt.h(list4.size(), 10);
            a.a.f(wf.a.a, "PUSH_SHOW", "postPushPermanent, curAbType:" + curAbType, false, 4, (Object) null);
            IntRange s = RangesKt.s(0, h);
            ArrayList arrayList = new ArrayList(CollectionsKt.v(s, 10));
            IntIterator it = s.iterator();
            while (it.hasNext()) {
                ArrayList arrayList2 = arrayList;
                arrayList2.add(kotlinx.coroutines.i.b(n0Var, (CoroutineContext) null, (CoroutineStart) null, new PushPermanentShowHelper$showPermanentPush$1$1$deferredList$1$1(list4, it.a(), context2, continuation), 3, (Object) null));
                arrayList = arrayList2;
                synchronizedList2 = synchronizedList2;
                synchronizedList = synchronizedList;
                continuation = null;
            }
            List list5 = synchronizedList2;
            List list6 = synchronizedList;
            this.L$0 = list4;
            this.L$1 = context2;
            this.L$2 = list6;
            this.L$3 = list5;
            this.I$0 = curAbType;
            this.label = 1;
            a = kotlinx.coroutines.f.a(arrayList, this);
            if (a == f) {
                return f;
            }
            list = list6;
            list2 = list4;
            i = curAbType;
            list3 = list5;
            context = context2;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                obj2 = Result.constructor-impl(Unit.a);
                th2 = Result.exceptionOrNull-impl(obj2);
                if (th2 != null) {
                    wf.a.a.c("PUSH_SHOW", "load complete-error:" + th2.getMessage(), true);
                    th2.printStackTrace();
                }
                return Unit.a;
            }
            int i3 = this.I$0;
            List list7 = (List) this.L$3;
            List list8 = (List) this.L$2;
            Context context3 = (Context) this.L$1;
            list2 = (List) this.L$0;
            ResultKt.b(obj);
            list3 = list7;
            list = list8;
            context = context3;
            i = i3;
            a = obj;
        }
        for (Pair pair : (Iterable) a) {
            Bitmap bitmap = (Bitmap) pair.component1();
            PermanentItemBean permanentItemBean = (PermanentItemBean) CollectionsKt.l0(list2, ((Number) pair.component2()).intValue());
            if (permanentItemBean != null) {
                if (bitmap == null) {
                    PushPermanentShowHelper.d = 0L;
                    if (list.size() < 5) {
                        list.add(null);
                        list3.add(permanentItemBean);
                    }
                } else {
                    list.add(bitmap);
                    Boxing.a(list3.add(permanentItemBean));
                }
            }
        }
        wf.a.a.c("PUSH_SHOW", "load complete-size:" + list.size(), true);
        a2 c = y0.c();
        PushPermanentShowHelper$showPermanentPush$1$1$2 pushPermanentShowHelper$showPermanentPush$1$1$2 = new PushPermanentShowHelper$showPermanentPush$1$1$2(context, list3, list, i, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (kotlinx.coroutines.i.g(c, pushPermanentShowHelper$showPermanentPush$1$1$2, this) == f) {
            return f;
        }
        obj2 = Result.constructor-impl(Unit.a);
        th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
        }
        return Unit.a;
    }
}

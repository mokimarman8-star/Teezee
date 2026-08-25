package com.tn.tranpay.helper;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.tn.tranpay.helper.IPHelper$getCurrentIP$2", f = "IPHelper.kt", l = {49}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class IPHelper$getCurrentIP$2 extends SuspendLambda implements Function2<n0, Continuation<? super String>, Object> {
    final /* synthetic */ boolean $useCache;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IPHelper$getCurrentIP$2(boolean z, Continuation<? super IPHelper$getCurrentIP$2> continuation) {
        super(2, continuation);
        this.$useCache = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IPHelper$getCurrentIP$2(this.$useCache, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super String> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0098 A[Catch: Exception -> 0x0019, TRY_LEAVE, TryCatch #0 {Exception -> 0x0019, blocks: (B:6:0x0015, B:7:0x0085, B:12:0x0076, B:18:0x0089, B:21:0x0090, B:23:0x0098), top: B:5:0x0015 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0082 -> B:7:0x0085). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List list;
        Iterator it;
        String str;
        long j;
        String str2;
        String str3;
        boolean k;
        String str4;
        String str5;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            if (this.$useCache) {
                str = IPHelper.b;
                if (str != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j = IPHelper.c;
                    if (currentTimeMillis - j < 300000) {
                        lh.a aVar = lh.a.a;
                        str2 = IPHelper.b;
                        lh.a.g(aVar, "使用缓存的IP地址: " + str2, null, 2, null);
                        str3 = IPHelper.b;
                        return str3;
                    }
                }
            }
            list = IPHelper.d;
            it = list.iterator();
            if (it.hasNext()) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str6 = (String) this.L$1;
            it = (Iterator) this.L$0;
            try {
                ResultKt.b(obj);
            } catch (Exception e) {
                lh.a.e(lh.a.a, "从 " + str6 + " 获取IP失败: " + e.getMessage(), null, 2, null);
            }
            String str7 = (String) obj;
            if (str7 != null && !StringsKt.q0(str7)) {
                k = IPHelper.a.k(str7);
                if (k) {
                    IPHelper.b = StringsKt.n1(str7).toString();
                    IPHelper.c = System.currentTimeMillis();
                    lh.a aVar2 = lh.a.a;
                    str4 = IPHelper.b;
                    lh.a.g(aVar2, "成功获取IP地址: " + str4 + " (来源: " + str6 + ")", null, 2, null);
                    str5 = IPHelper.b;
                    return str5;
                }
            }
            if (it.hasNext()) {
                str6 = (String) it.next();
                IPHelper iPHelper = IPHelper.a;
                this.L$0 = it;
                this.L$1 = str6;
                this.label = 1;
                obj = iPHelper.h(str6, this);
                if (obj == f) {
                    return f;
                }
                String str72 = (String) obj;
                if (str72 != null) {
                    k = IPHelper.a.k(str72);
                    if (k) {
                    }
                }
                if (it.hasNext()) {
                    lh.a.e(lh.a.a, "所有IP服务都获取失败", null, 2, null);
                    return null;
                }
            }
        }
    }
}

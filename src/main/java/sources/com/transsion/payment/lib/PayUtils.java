package com.transsion.payment.lib;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PayUtils {
    public static final PayUtils a = new PayUtils();

    private PayUtils() {
    }

    public static /* synthetic */ Object b(PayUtils payUtils, long j, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 3000;
        }
        return payUtils.a(j, (i2 & 2) != 0 ? 2 : i, function1, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00a6 -> B:11:0x00a9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(long j, int i, Function1 function1, Continuation continuation) {
        PayUtils$retryWithBackoff$1 payUtils$retryWithBackoff$1;
        int i2;
        Exception e;
        long j2;
        int i3;
        if (continuation instanceof PayUtils$retryWithBackoff$1) {
            payUtils$retryWithBackoff$1 = (PayUtils$retryWithBackoff$1) continuation;
            int i4 = payUtils$retryWithBackoff$1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                payUtils$retryWithBackoff$1.label = i4 - Integer.MIN_VALUE;
                Object obj = payUtils$retryWithBackoff$1.result;
                Object f = IntrinsicsKt.f();
                i2 = payUtils$retryWithBackoff$1.label;
                if (i2 == 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i3 = payUtils$retryWithBackoff$1.I$0;
                        j2 = payUtils$retryWithBackoff$1.J$0;
                        function1 = (Function1) payUtils$retryWithBackoff$1.L$0;
                        ResultKt.b(obj);
                        i = i3 - 1;
                        j = j2 * 2;
                        try {
                        } catch (Exception e2) {
                            e = e2;
                            long j3 = j;
                            i3 = i;
                            j2 = j3;
                            if (i3 > 0) {
                            }
                        }
                        i0 a2 = y0.a();
                        PayUtils$retryWithBackoff$2 payUtils$retryWithBackoff$2 = new PayUtils$retryWithBackoff$2(function1, null);
                        payUtils$retryWithBackoff$1.L$0 = function1;
                        payUtils$retryWithBackoff$1.J$0 = j;
                        payUtils$retryWithBackoff$1.I$0 = i;
                        payUtils$retryWithBackoff$1.label = 1;
                        obj = i.g(a2, payUtils$retryWithBackoff$2, payUtils$retryWithBackoff$1);
                        if (obj == f) {
                            return f;
                        }
                        long j4 = j;
                        i3 = i;
                        j2 = j4;
                        System.out.println((Object) "Action succeeded");
                        return obj;
                    }
                    i3 = payUtils$retryWithBackoff$1.I$0;
                    j2 = payUtils$retryWithBackoff$1.J$0;
                    function1 = (Function1) payUtils$retryWithBackoff$1.L$0;
                    try {
                        ResultKt.b(obj);
                    } catch (Exception e3) {
                        e = e3;
                        if (i3 > 0) {
                            System.out.println((Object) "All retry attempts exhausted");
                            throw e;
                        }
                        System.out.println((Object) ("Action failed: " + e.getMessage() + ". Retries left: " + i3));
                        payUtils$retryWithBackoff$1.L$0 = function1;
                        payUtils$retryWithBackoff$1.J$0 = j2;
                        payUtils$retryWithBackoff$1.I$0 = i3;
                        payUtils$retryWithBackoff$1.label = 2;
                        if (u0.a(j2, payUtils$retryWithBackoff$1) == f) {
                            return f;
                        }
                        i = i3 - 1;
                        j = j2 * 2;
                        i0 a22 = y0.a();
                        PayUtils$retryWithBackoff$2 payUtils$retryWithBackoff$22 = new PayUtils$retryWithBackoff$2(function1, null);
                        payUtils$retryWithBackoff$1.L$0 = function1;
                        payUtils$retryWithBackoff$1.J$0 = j;
                        payUtils$retryWithBackoff$1.I$0 = i;
                        payUtils$retryWithBackoff$1.label = 1;
                        obj = i.g(a22, payUtils$retryWithBackoff$22, payUtils$retryWithBackoff$1);
                        if (obj == f) {
                        }
                    }
                    System.out.println((Object) "Action succeeded");
                    return obj;
                }
                ResultKt.b(obj);
                i0 a222 = y0.a();
                PayUtils$retryWithBackoff$2 payUtils$retryWithBackoff$222 = new PayUtils$retryWithBackoff$2(function1, null);
                payUtils$retryWithBackoff$1.L$0 = function1;
                payUtils$retryWithBackoff$1.J$0 = j;
                payUtils$retryWithBackoff$1.I$0 = i;
                payUtils$retryWithBackoff$1.label = 1;
                obj = i.g(a222, payUtils$retryWithBackoff$222, payUtils$retryWithBackoff$1);
                if (obj == f) {
                }
            }
        }
        payUtils$retryWithBackoff$1 = new PayUtils$retryWithBackoff$1(this, continuation);
        Object obj2 = payUtils$retryWithBackoff$1.result;
        Object f2 = IntrinsicsKt.f();
        i2 = payUtils$retryWithBackoff$1.label;
        if (i2 == 0) {
        }
    }
}

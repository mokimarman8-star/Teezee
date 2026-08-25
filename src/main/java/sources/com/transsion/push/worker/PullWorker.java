package com.transsion.push.worker;

import android.content.Context;
import androidx.coroutines.CoroutineWorker;
import androidx.work.WorkerParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/transsion/push/worker/PullWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/i$a;", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "Landroid/content/Context;", "mContext", "i", "a", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class PullWorker extends CoroutineWorker {
    public static final a i = new a((DefaultConstructorMarker) null);

    /* renamed from: h, reason: from kotlin metadata */
    private Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.h(context, "context");
        Intrinsics.h(workerParameters, "params");
        this.mContext = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|(1:(1:9)(2:18|19))(2:20|(1:22))|10|11|12|13))|23|6|(0)(0)|10|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0075, code lost:
    
        r9.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.coroutines.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object r(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.transsion.push.worker.PullWorker.doWork.1
            if (r0 == 0) goto L13
            r0 = r9
            com.transsion.push.worker.PullWorker$doWork$1 r0 = (com.transsion.push.worker.PullWorker.doWork.1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.push.worker.PullWorker$doWork$1 r0 = new com.transsion.push.worker.PullWorker$doWork$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r9)
            goto L62
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L31:
            kotlin.ResultKt.b(r9)
            kotlin.random.Random$Default r9 = kotlin.random.Random.INSTANCE
            r2 = 0
            r4 = 120(0x78, float:1.68E-43)
            int r9 = r9.nextInt(r2, r4)
            wf.a$a r2 = wf.a.a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "doWork random * "
            r4.append(r5)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "PullWorker"
            r2.c(r5, r4, r3)
            long r4 = (long) r9
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            r0.label = r3
            java.lang.Object r9 = kotlinx.coroutines.u0.a(r4, r0)
            if (r9 != r1) goto L62
            return r1
        L62:
            com.transsion.push.utils.NotificationUtil r9 = com.transsion.push.utils.NotificationUtil.a     // Catch: java.lang.Exception -> L74
            android.content.Context r0 = r8.mContext     // Catch: java.lang.Exception -> L74
            r1 = 2
            r2 = 0
            com.transsion.push.utils.NotificationUtil.Q(r9, r0, r2, r1, r2)     // Catch: java.lang.Exception -> L74
            r9.v()     // Catch: java.lang.Exception -> L74
            com.transsion.push.notification.ToolbarNotificationUtils r9 = com.transsion.push.notification.ToolbarNotificationUtils.a     // Catch: java.lang.Exception -> L74
            r9.i()     // Catch: java.lang.Exception -> L74
            goto L78
        L74:
            r9 = move-exception
            r9.printStackTrace()
        L78:
            androidx.work.i$a r9 = androidx.work.i.a.c()
            java.lang.String r0 = "success(...)"
            kotlin.jvm.internal.Intrinsics.g(r9, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.worker.PullWorker.r(kotlin.coroutines.Continuation):java.lang.Object");
    }
}

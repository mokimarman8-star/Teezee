package com.transsion.push.worker;

import android.content.Context;
import androidx.coroutines.CoroutineWorker;
import androidx.work.WorkerParameters;
import androidx.work.i;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/transsion/push/worker/ReportWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/i$a;", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "a", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ReportWorker extends CoroutineWorker {
    public static final a h = new a((DefaultConstructorMarker) null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.h(context, "context");
        Intrinsics.h(workerParameters, "params");
    }

    @Override // androidx.coroutines.CoroutineWorker
    public Object r(Continuation continuation) {
        try {
            a.a.f(a.a, "ReportWorker", "ReportWorker doWork " + System.currentTimeMillis(), false, 4, (Object) null);
            i.a c = i.a.c();
            Intrinsics.g(c, "success(...)");
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            i.a a = i.a.a();
            Intrinsics.g(a, "failure(...)");
            return a;
        }
    }
}

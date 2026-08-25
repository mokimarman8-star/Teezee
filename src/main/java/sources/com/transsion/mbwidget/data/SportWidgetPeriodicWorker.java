package com.transsion.mbwidget.data;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import androidx.work.i;
import com.transsion.mbwidget.SportSchedulePreviewWidgetProvider;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/transsion/mbwidget/data/SportWidgetPeriodicWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/i$a;", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "a", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SportWidgetPeriodicWorker extends CoroutineWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SportWidgetPeriodicWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.h(context, "context");
        Intrinsics.h(workerParameters, "params");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|(2:3|(11:5|6|7|(1:(2:10|11)(2:25|26))(3:27|28|(4:30|17|18|(1:23)(2:20|21))(2:31|(1:33)(1:34)))|12|(1:14)|15|16|17|18|(0)(0)))|37|6|7|(0)(0)|12|(0)|15|16|17|18|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0037, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ca, code lost:
    
        r0 = kotlin.Result.Companion;
        r14 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r14));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b A[Catch: all -> 0x0037, LOOP:0: B:13:0x0089->B:14:0x008b, LOOP_END, TryCatch #0 {all -> 0x0037, blocks: (B:11:0x0033, B:12:0x0083, B:14:0x008b, B:16:0x00a5, B:17:0x00c5, B:28:0x0045, B:30:0x0064, B:31:0x0070), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object r(Continuation continuation) {
        SportWidgetPeriodicWorker$doWork$1 sportWidgetPeriodicWorker$doWork$1;
        int i;
        Throwable th2;
        AppWidgetManager appWidgetManager;
        SportWidgetPeriodicWorker sportWidgetPeriodicWorker;
        int[] iArr;
        i.a c;
        if (continuation instanceof SportWidgetPeriodicWorker$doWork$1) {
            sportWidgetPeriodicWorker$doWork$1 = (SportWidgetPeriodicWorker$doWork$1) continuation;
            int i2 = sportWidgetPeriodicWorker$doWork$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                sportWidgetPeriodicWorker$doWork$1.label = i2 - Integer.MIN_VALUE;
                Object obj = sportWidgetPeriodicWorker$doWork$1.result;
                Object f = IntrinsicsKt.f();
                i = sportWidgetPeriodicWorker$doWork$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    Result.Companion companion = Result.Companion;
                    appWidgetManager = AppWidgetManager.getInstance(b());
                    int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(b(), (Class<?>) SportSchedulePreviewWidgetProvider.class));
                    Intrinsics.e(appWidgetIds);
                    if (appWidgetIds.length == 0) {
                        wf.a.a.c("SportWidget", "SportWidgetPeriodicWorker: no sport widget instance, skip", true);
                        c = i.a.c();
                        Object obj2 = Result.constructor-impl(c);
                        th2 = Result.exceptionOrNull-impl(obj2);
                        if (th2 == null) {
                            return obj2;
                        }
                        a.a.k(wf.a.a, "SportWidget", "SportWidgetPeriodicWorker error: " + th2.getMessage(), th2, false, 8, (Object) null);
                        i.a a = i.a.a();
                        Intrinsics.g(a, "failure(...)");
                        return a;
                    }
                    SportWidgetDataManager sportWidgetDataManager = SportWidgetDataManager.a;
                    sportWidgetPeriodicWorker$doWork$1.L$0 = this;
                    sportWidgetPeriodicWorker$doWork$1.L$1 = appWidgetManager;
                    sportWidgetPeriodicWorker$doWork$1.L$2 = appWidgetIds;
                    sportWidgetPeriodicWorker$doWork$1.label = 1;
                    if (sportWidgetDataManager.g(sportWidgetPeriodicWorker$doWork$1) == f) {
                        return f;
                    }
                    sportWidgetPeriodicWorker = this;
                    iArr = appWidgetIds;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    iArr = (int[]) sportWidgetPeriodicWorker$doWork$1.L$2;
                    appWidgetManager = (AppWidgetManager) sportWidgetPeriodicWorker$doWork$1.L$1;
                    sportWidgetPeriodicWorker = (SportWidgetPeriodicWorker) sportWidgetPeriodicWorker$doWork$1.L$0;
                    ResultKt.b(obj);
                }
                Intrinsics.e(iArr);
                for (int i3 : iArr) {
                    SportSchedulePreviewWidgetProvider.Companion companion2 = SportSchedulePreviewWidgetProvider.INSTANCE;
                    Context b = sportWidgetPeriodicWorker.b();
                    Intrinsics.g(b, "getApplicationContext(...)");
                    Intrinsics.e(appWidgetManager);
                    SportSchedulePreviewWidgetProvider.Companion.r(companion2, b, appWidgetManager, i3, false, 8, null);
                }
                wf.a.a.c("SportWidget", "SportWidgetPeriodicWorker: refreshed " + iArr.length + " sport widget(s)", true);
                c = i.a.c();
                Object obj22 = Result.constructor-impl(c);
                th2 = Result.exceptionOrNull-impl(obj22);
                if (th2 == null) {
                }
            }
        }
        sportWidgetPeriodicWorker$doWork$1 = new SportWidgetPeriodicWorker$doWork$1(this, continuation);
        Object obj3 = sportWidgetPeriodicWorker$doWork$1.result;
        Object f2 = IntrinsicsKt.f();
        i = sportWidgetPeriodicWorker$doWork$1.label;
        if (i != 0) {
        }
        Intrinsics.e(iArr);
        while (r12 < r14) {
        }
        wf.a.a.c("SportWidget", "SportWidgetPeriodicWorker: refreshed " + iArr.length + " sport widget(s)", true);
        c = i.a.c();
        Object obj222 = Result.constructor-impl(c);
        th2 = Result.exceptionOrNull-impl(obj222);
        if (th2 == null) {
        }
    }
}

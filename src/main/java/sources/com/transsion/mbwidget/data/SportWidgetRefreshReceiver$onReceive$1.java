package com.transsion.mbwidget.data;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import com.transsion.gslb.BuildConfig;
import com.transsion.mbwidget.SportSchedulePreviewWidgetProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.mbwidget.data.SportWidgetRefreshReceiver$onReceive$1", f = "SportWidgetRefreshReceiver.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SportWidgetRefreshReceiver$onReceive$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ BroadcastReceiver.PendingResult $pendingResult;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.mbwidget.data.SportWidgetRefreshReceiver$onReceive$1$1", f = "SportWidgetRefreshReceiver.kt", l = {33}, m = "invokeSuspend")
    /* renamed from: com.transsion.mbwidget.data.SportWidgetRefreshReceiver$onReceive$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                SportWidgetDataManager sportWidgetDataManager = SportWidgetDataManager.a;
                this.label = 1;
                if (sportWidgetDataManager.g(this) == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SportWidgetRefreshReceiver$onReceive$1(Context context, BroadcastReceiver.PendingResult pendingResult, Continuation<? super SportWidgetRefreshReceiver$onReceive$1> continuation) {
        super(2, continuation);
        this.$ctx = context;
        this.$pendingResult = pendingResult;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SportWidgetRefreshReceiver$onReceive$1(this.$ctx, this.$pendingResult, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        try {
            try {
                a.a aVar = wf.a.a;
                aVar.c("SportWidget", "SportWidgetRefreshReceiver: alarm fired at " + System.currentTimeMillis(), true);
                kotlinx.coroutines.i.f((CoroutineContext) null, new AnonymousClass1(null), 1, (Object) null);
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.$ctx);
                int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this.$ctx, (Class<?>) SportSchedulePreviewWidgetProvider.class));
                Intrinsics.e(appWidgetIds);
                if (appWidgetIds.length == 0) {
                    aVar.c("SportWidget", "SportWidgetRefreshReceiver: no sport widget instance, skip", true);
                } else {
                    Context context = this.$ctx;
                    for (int i : appWidgetIds) {
                        SportSchedulePreviewWidgetProvider.Companion companion = SportSchedulePreviewWidgetProvider.INSTANCE;
                        Intrinsics.e(context);
                        Intrinsics.e(appWidgetManager);
                        companion.q(context, appWidgetManager, i, true);
                    }
                    wf.a.a.c("SportWidget", "SportWidgetRefreshReceiver: refreshed " + appWidgetIds.length + " sport widget(s)", true);
                }
            } catch (Exception e) {
                a.a aVar2 = wf.a.a;
                a.a.k(aVar2, "SportWidget", "SportWidgetRefreshReceiver error: " + e.getMessage(), e, false, 8, (Object) null);
                aVar2.c("SportWidget", "SportWidgetRefreshReceiver FAILED: " + e.getMessage(), true);
            }
            this.$pendingResult.finish();
            return Unit.a;
        } catch (Throwable th2) {
            this.$pendingResult.finish();
            throw th2;
        }
    }
}

package com.transsion.mbwidget.data;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.GslbSdk;
import com.transsion.mbwidget.SportSchedulePreviewWidgetProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.mbwidget.data.SportWidgetDataManager$forceRefresh$1", f = "SportWidgetDataManager.kt", l = {235, 236}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SportWidgetDataManager$forceRefresh$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.mbwidget.data.SportWidgetDataManager$forceRefresh$1$1", f = "SportWidgetDataManager.kt", l = {}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.transsion.mbwidget.data.SportWidgetDataManager$forceRefresh$1$1, reason: invalid class name */
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
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Context applicationContext = GslbSdk.context.getApplicationContext();
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(applicationContext);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(applicationContext, (Class<?>) SportSchedulePreviewWidgetProvider.class));
            Intrinsics.e(appWidgetIds);
            if (!(appWidgetIds.length == 0)) {
                for (int i : appWidgetIds) {
                    SportSchedulePreviewWidgetProvider.Companion companion = SportSchedulePreviewWidgetProvider.INSTANCE;
                    Intrinsics.e(applicationContext);
                    Intrinsics.e(appWidgetManager);
                    companion.q(applicationContext, appWidgetManager, i, true);
                }
                wf.a.a.c("SportWidget", "Force refresh: updated " + appWidgetIds.length + " sport widget(s)", true);
            }
            return Unit.a;
        }
    }

    SportWidgetDataManager$forceRefresh$1(Continuation<? super SportWidgetDataManager$forceRefresh$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SportWidgetDataManager$forceRefresh$1(continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object q;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            SportWidgetDataManager sportWidgetDataManager = SportWidgetDataManager.a;
            this.label = 1;
            q = sportWidgetDataManager.q(this);
            if (q == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        a2 c = y0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
        this.label = 2;
        if (kotlinx.coroutines.i.g(c, anonymousClass1, this) == f) {
            return f;
        }
        return Unit.a;
    }
}
